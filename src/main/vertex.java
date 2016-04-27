package main;
//////////////////
//  adam pluth	//
//  cs 201	//
//  Kruskal's 	//
//  algorithim	//
//  Project 3	//
//  4/20/16	//
//////////////////

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Vertex {
	public int Depth;
	public Integer Id;
	public Integer tempW;
	public Integer rank=0;
	public String color="w";
	public boolean root=true;
	public boolean bfsroot=false;
	private ArrayList<Edge> edges=new ArrayList<Edge>();
	public Vertex Parent=this;
	
  public Vertex(Integer id){
	  Id=id;
  }
  
  public Vertex(Integer id,Vertex id2){
	  Id=id;
	  addEdge(id2,1);
  }
  
  public Vertex(Integer id,Vertex id2,Integer w){
	  Id=id;
	  addEdge(id2,w);
  }

  public void addEdge(Vertex e){
	if(contains(e)==-1){edges.add(new Edge(this,e));}
	Collections.sort(edges,new Comparator<Edge>(){
		public int compare(Edge  o1, Edge o2){
			return o1.Weight-o2.Weight;
		}
	});
  }
  
  public void addEdge(Vertex e,Integer w){
	if(contains(e)==-1){edges.add(new Edge(this,e,w));}
	Collections.sort(edges,new Comparator<Edge>(){
		public int compare(Edge  o1, Edge o2){
			return o1.Weight-o2.Weight;
		}
	});
  }
	
  public Integer contains(Vertex id){
	    if(edges==null){return -1;}//if empty
		for(int i=0;i<getEdges().size();i++){
			if(getEdges().get(i).end!=null&&getEdges().get(i).end.equals(id)){return i;}
		}
		return -1;//if not in list
  }
  
  public Integer contains(Integer id){
    if(edges==null){return -1;}//if empty
	for(int i=0;i<getEdges().size();i++){
		if(getEdges().get(i).end!=null&&getEdges().get(i).end.Id.equals(id)){return i;}
	}
	return -1;//if not in list
}
  
  public void setParent(Vertex v){Parent=v;}
  
  public Vertex getRoot(){return Parent;}

  public ArrayList<Edge> getEdges() {
	return edges;
  }
  
  public void setEdges(ArrayList<Edge> edges) {
	this.edges = edges;
  }

  public void sort(){
	Collections.sort(edges,new Comparator<Edge>(){
		public int compare(Edge  o1, Edge o2){
			return o1.Weight-o2.Weight;
		}
	});
  }

}
