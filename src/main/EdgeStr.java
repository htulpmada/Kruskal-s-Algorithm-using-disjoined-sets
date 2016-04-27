package main;
//////////////////
//  adam pluth	//
//  cs 201	//
//  Kruskal's 	//
//  algorithim	//
//  Project 3	//
//  4/20/16	//
//////////////////

public class EdgeStr {
	
	public Integer ID,P,W;
	public boolean root;
	
	public EdgeStr(Integer id,Integer p,Integer w){
		ID=id;
		P=p;
		W=w;
		root=false;
	}
	
	public EdgeStr(Integer id) {
		ID=id;
		P=ID;
		W=1;
		root=true;
	}
	
	public void print(){
		if(root){System.out.print(" "+ID+";");}
		else{System.out.print(" "+ID+"("+P+")"+W+";");}
	}
	
}
