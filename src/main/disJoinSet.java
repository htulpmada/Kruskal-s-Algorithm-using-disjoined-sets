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

public class DisJoinSet {
	public Graph G;
	public Integer root;
	public ArrayList<Edge> DisEdges= new ArrayList<Edge>();
	public DisJoinSet(){}
	public DisJoinSet(Graph g){
		G=g;
		try{root=g.Root.Id;}
		catch(NullPointerException e){root=G.VertList.root.getData().Id;}
		makeSet();
		PrintSpanningTree(root);
	}

	public void makeSet() {
		getEdges();
		Bst verts =new Bst(); 
		for(Edge edge : G.EList){
			verts=Union(edge,verts);
			verts.ins(edge.start.Id.toString());
			verts.ins(edge.end.Id.toString());
		}
	}
	
	private Bst Union(Edge edge,Bst disSet) {
		Vertex s=edge.start,d=edge.end;
		s=findSet(s);
		d=findSet(d);
		//check for cycle here
		//			|
		//			|
		//			v
		if(disSet.getFreq(edge.start.Id.toString())!=0&&disSet.getFreq(edge.end.Id.toString())!=0){
			if(edge.start.Parent.Id.equals(edge.end.Parent.Id)){
			//		^
			//		|
				edge.start.getEdges().remove(edge);
				edge.end.getEdges().remove(edge);
				return disSet;
			}
		}
		if(s.Parent.rank>d.Parent.rank){
			d.setParent(s.Parent);
			d.root=false;
		}
		else if(s.Parent.rank<d.Parent.rank){
			s.setParent(d.Parent);
			s.root=false;
		}
		else{
			s.setParent(d.Parent);
			d.rank++;
			s.root=false;
		}
		DisEdges.add(edge);
		return disSet;
	}

	public Vertex findSet(Vertex vert) {
		if(vert.Parent==vert){return vert;}
		else{
			vert.Parent=findSet(vert.Parent);
			return vert.Parent;
		}
	}
	
	public void PrintSpanningTree(Integer r){
		if(G.findV(r)==null){
			System.out.println("root "+r+" not in Graph");
			return;
		}
		Vertex root=findSet(G.findV(r));
		if(root==null){
			System.out.println("root "+r+" not in Graph");
			return;
			}
		G.VertList.Iterate(G.VertList.root);
		G.vlist=G.VertList.vlist;
		ArrayList<Vertex> V = G.vlist;
		ArrayList<Vertex> VL = new ArrayList<Vertex>();
		Graph g=null;
		int i=0;
		int j=0;		
		for(Vertex v : V){
			i++;
			if(v.getRoot().Id.equals(root.Id)){
				j++;
				VL.add(v);
				
			}
		}
		g=new Graph(VL,DisEdges,r);//should have set with no cycle and no other nodes in graph g original in graph G
		ArrayList<Integer> unReach=g.Bfs();
		System.out.println("weight: "+unReach.get(1));
		System.out.println("unreachable: "+(G.VertList.count-g.VertList.count));
	}

	public Vertex findRoot(Integer root) {
		for(Vertex v : G.vlist){
			if(v.Id.equals(root)){
				G.Root=v;
				v=findRoot(v,root);
				return v;
			}
		}
		return null;
	}
	
	public Vertex findRoot(Vertex v ,Integer r) {
		if((v.getRoot()==v)){
			return v;
		}
		else{
			v.setParent(findRoot(v.getRoot().Id));
			return v;
		}
	}
	
	public void getEdges(){
		ArrayList<Edge> elis =new ArrayList<Edge>();
		for(Vertex v : G.vlist){
			ArrayList<Edge> Vedges=v.getEdges();
			for(Edge e : Vedges){	
				elis.add(e);
			}
		}
		Collections.sort(elis,new Comparator<Edge>(){
			public int compare(Edge  o1, Edge o2){
				return o1.Weight-o2.Weight;
			}
		});
		G.EList=elis;
	}

}
