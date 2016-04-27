package main;
//////////////////
//  adam pluth	//
//  cs 201	//
//  Kruskal's 	//
//  algorithim	//
//  Project 3	//
//  4/20/16	//
//////////////////

public class VQNode {
	private Vertex index;
	private VQNode next;
	public Integer weight;
	
	public VQNode(){}
	
	public Vertex get(){return index;}
	public VQNode next(){return next;}
	
	public void setItem(Vertex v){index=v;}
	public void setNext(VQNode q){next=q;}
	
}
