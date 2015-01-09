package com.yogeshn.pep.pra.ex4;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class Model extends AbstractTableModel {

	ArrayList<Edge> edges =  new ArrayList<Edge>();
	
	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return edges.size();
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "From";
		case 1:	
			return "To";
		case 2:
			return "Distance";
		}
		return null;
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0:
			return edges.get(row).getStart();
		case 1:	
			return edges.get(row).getFinish();
		case 2:
			return edges.get(row).getDistance();
		}
		return null;
	}
	
	public boolean addEdge(Edge e) {
		for (int i = 0; i < edges.size(); i++) {
			Edge f = edges.get(i);
			if (f.getStart() == e.getStart() && f.getFinish() == e.getFinish()) return false;
		}
		edges.add(e);
		return true;
		
	}
	
	public Edge getEdge(int i) {
		return edges.get(i);
	}

	public void removeEdge(int i) {
		edges.remove(i);
	}
	
}
