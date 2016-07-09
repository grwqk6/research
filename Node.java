package com.KatsProject.net;

public class Node {
	String roadID;
	String nodeID;
	String x_coord;
	String y_coord;
	
	public Node( String nodeID) {
		
		this.nodeID = nodeID;
	
	}
	
	public String getNodeID() {
		return nodeID;
	}

	public void setRoadID(String roadID) {
		this.roadID = roadID;
	}
	public void setNodeID(String nodeID) {
		this.nodeID = nodeID;
	}
	public void setX_coord(String x_coord) {
		this.x_coord = x_coord;
	}
	public void setY_coord(String y_coord) {
		this.y_coord = y_coord;
	}
	public String getX_coord() {
		return x_coord;
	}
	public String getY_coord() {
		return y_coord;
	}
	public String getRoadID() {
		return roadID;
	}

}
