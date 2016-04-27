package main;
//////////////////
//  adam pluth	//
//  cs 201	//
//  Kruskal's 	//
//  algorithim	//
//  Project 3	//
//  4/20/16	//
//////////////////

public class QNode {
	private Node index;
	private QNode next;
	
	public QNode(){}
	
	public Node get(){return index;}
	public QNode next(){return next;}
	
	public void setItem(Node n){index=n;}
	public void setNext(QNode q){next=q;}
	
}
