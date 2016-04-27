package main;
//////////////////
//  adam pluth	//
//  cs 201	//
//  Kruskal's 	//
//  algorithim	//
//  Project 3	//
//  4/20/16	//
//////////////////

public class VQueue {
	private VQNode head,tail;
	private int size;
	
	public VQueue(){
		size=0;
		tail=head=null;
	}

	public VQNode getfront(){return head;}
	public VQNode getnext(){return head.next();}
	public int getsize(){return size;}
	
	public void insert(Vertex v){
		VQNode temp = new VQNode();
		temp.setItem(v);
		temp.setNext(null);
		if(size==0)head=tail=temp;
		else {tail.setNext(temp);tail=temp;}
		size++;
		}
	
	public Vertex gethead(){
		Vertex temp =null;
		if(size>0){
			temp=head.get();
			head=head.next();
			size--;
			if(size==0){tail=head=null;}
		}
		return temp;
	}	
}
