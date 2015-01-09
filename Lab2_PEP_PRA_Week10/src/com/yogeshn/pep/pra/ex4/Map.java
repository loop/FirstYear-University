package com.yogeshn.pep.pra.ex4;

import java.util.ArrayList;

public class Map {
	ArrayList<Edge> roads = new ArrayList<Edge>();
	
	public void addRoad(Edge road) {
		Edge back = new Edge(road.getFinish(), road.getStart(), road.getDistance());
		roads.add(road);
		roads.add(back);
	}
	
	public ArrayList<Edge> getRoadsFrom(char from) {
		ArrayList<Edge> ret = new ArrayList<Edge>();
		for (Edge e : roads) {
			if (e.getStart() == from) {
				ret.add(e);
			}
		}
		
		return ret;
	}
	
}
