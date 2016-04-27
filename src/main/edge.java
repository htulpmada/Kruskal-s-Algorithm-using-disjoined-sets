package main;
//////////////////
//  adam pluth	//
//  cs 201	//
//  Kruskal's 	//
//  algorithim	//
//  Project 3	//
//  4/20/16	//
//////////////////


public class Edge {

	public Integer Weight=null;
	public Vertex start=null;
	public Vertex end=null;
	
	public Edge(Vertex id1,Vertex id2){
		start=id1;
		end=id2;
		Weight=1;
	}
	public Edge(Vertex id1,Vertex id2,Integer w){
		start=id1;
		end=id2;
		Weight=w;
	}
	public Edge(Edge e) {
		start=e.end;
		end=e.start;
		Weight=e.Weight;
	}
	public int compareTo(Edge e1, Edge e2) {
		// TODO Auto-generated method stub
		int i =e1.Weight-e2.Weight;
		return i;
	}
	
}
