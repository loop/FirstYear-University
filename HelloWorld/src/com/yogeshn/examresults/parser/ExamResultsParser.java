package com.yogeshn.examresults.parser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The purpose of this program is to make parsing files simple. There are two
 * Files in the main method. The program reads first file, on each of its line
 * invokes <tt>change</tt> method, and writes the result to the second file.
 * Once finished, the program invokes <tt>lastPrint</tt> method.
 * <p>
 * Because fields and two mentioned methods can be freely modified, the program
 * can do different kind of calculations while reading a file. This one reads
 * a html file with provisional results (the ones from Moodle). Although it
 * a second file while reading, all information are printed out and that file
 * is not used at all by the program (however you can use it for your own
 * purposes).
 * 
 * @author Jaroslaw Pawlak
 */
public class ExamResultsParser {
    private static HashMap<String, Integer> sum = new HashMap<String, Integer>();
    private static HashMap<String, Integer> sits = new HashMap<String, Integer>();
    private static HashMap<String, Integer> missed = new HashMap<String, Integer>();
    private static HashMap<String, int[]> modules = new HashMap<String, int[]>();
    
    private static String lastCandidate = "";
    private static String lastModule = "";
    
    /** returned null will be skipped */
    private static String change(String line) {
        String newLine = "";
        if (line.trim().matches(
                "(<tr><td colspan=\"3\">&nbsp;</td></tr>\\s+)?"
                + "<tr><td>"
                + "([A-Z]\\d{5})?"
                + "</td><td>"
                + "(\\dCCS\\d[A-Z]{2}[A-Z0-9])?"
                + "</td><td>"
                + "\\d{1,3}[\\s\\(\\)\\w]*"
                + "</td></tr>"
                )) {
            newLine = line.replace("<tr><td colspan=\"3\">&nbsp;</td></tr>", "").trim();
            newLine = newLine.replace("<tr><td>", "");
            if (newLine.charAt(0) == '<') {
                newLine = lastCandidate + newLine;
            } else {
                lastCandidate = newLine.substring(0, 6);
            }
            newLine = newLine.replace("</td><td>", " ");
            if (newLine.substring(7, 15).matches("\\dCCS\\d[A-Z]{2}[A-Z0-9]")) {
                lastModule = newLine.substring(7, 15);
            } else {
                newLine = newLine.substring(0, 7) + lastModule + newLine.substring(7);
            }
            newLine = newLine.replace("</td></tr>", "");
            
            if (newLine.contains("Exam") || newLine.contains("coursework")) {
                return null;
            }
            
            if (newLine.contains("overall")) {
                newLine = newLine.replace(" (overall)", "");
            } else if (newLine.contains("resit")) {
                newLine = newLine.replace(" (capped resit)", "");
            }
            
            String key = newLine.split(" ")[1];
            if (key.equals("5CCS2ELA")) {
                key = "4CCS1ELA";
            }
            if (sum.get(key) == null) {
                sum.put(key, 0);
                sits.put(key, 0);
                modules.put(key, new int[9]);
                missed.put(key, 0);
            }
            int result = Integer.parseInt(newLine.split(" ")[2]);
            if (result == 0) {
                missed.put(key, missed.get(key) + 1);
            } else {
                sum.put(key, sum.get(key) + result);
                sits.put(key, sits.get(key) + 1);
            }
            
            int grade; //0 - A++, 1 - A+, 2 - A, 3 - B, 4 - C, 5 - D, 6 - E, 7 - F, 8 - 0%
            if (result >= 90) {
                grade = 0;
            } else if (result >= 80) {
                grade = 1;
            } else if (result >= 70) {
                grade = 2;
            } else if (result >= 60) {
                grade = 3;
            } else if (result >= 50) {
                grade = 4;
            } else if (result >= 40) {
                grade = 5;
            } else if (result >= 33) {
                grade = 6;
            } else if (result > 0) {
                grade = 7;
            } else {
                grade = 8;
            }
            int[] array = modules.get(key);
            array[grade]++;
            modules.put(key, array);
        } else {
            return null;
        }

        return newLine;
    }

    private static void lastPrint() {
        System.out.println("Students with 0% overall result are considered absent.");
        System.out.println("Their results are included only in the total average.");
        System.out.println();
        System.out.println("MODULE    STUDENTS  AVERAGE  STUD. WITH 0%  TOT AVG  ABSENT");
        DecimalFormat df = new DecimalFormat("0.0%");
        for (String key : sum.keySet()) {
            String students = "" + sits.get(key);
            if (students.length() == 2) {
                students = students + " ";
            }
            String average = "" + (sum.get(key) / sits.get(key)) + "%";
            String miss = "" + missed.get(key);
            if (miss.length() == 1) {
                miss = miss + " ";
            }
            String absent = "" + df.format(missed.get(key) * 1.0d / (missed.get(key) + sits.get(key)));
            if (absent.length() == 4) {
                absent = " " + absent;
            }

            String totalaverage = "" + (sum.get(key) / (sits.get(key) + missed.get(key))) + "%";
            System.out.println(key + "  " + students + "       " + average + "      " + miss + "             " + totalaverage + "      " + absent);
        }
        System.out.println();
        System.out.println("Grades distribution:");
        for (String key : sum.keySet()) {
            System.out.println(key);
            int[] array = modules.get(key);
            System.out.println("A++: " + array[0]);
            System.out.println("A+ : " + array[1]);
            System.out.println("A  : " + array[2]);
            System.out.println("B  : " + array[3]);
            System.out.println("C  : " + array[4]);
            System.out.println("D  : " + array[5]);
            System.out.println("E  : " + array[6]);
            System.out.println("F  : " + array[7]);
            System.out.println("0% : " + array[8]);
        }
        System.out.println();
        System.out.println("Made by: Jaroslaw Pawlak");
    }

    public static void main(String[] args) {
        File input = new File("INPUT2.txt");
        if (!input.exists()) {
            try {
                input.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(ExamResultsParser.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Enter your text in INPUT.txt on the desktop");
            System.exit(0);
        }

        File output = new File("OUTPUT2.txt");
        if (!output.exists()) {
            try {
                output.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(ExamResultsParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Scanner in = null;
        Writer out = null;
        try {
            in = new Scanner(input);
            out = new OutputStreamWriter(new FileOutputStream(output));
            while (in.hasNextLine()) {
                String changed = change(in.nextLine());
                if (changed != null) {
                    out.write(changed + "\r\n");
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExamResultsParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExamResultsParser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(ExamResultsParser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        lastPrint();
    }
}