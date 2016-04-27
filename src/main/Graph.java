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


public class Graph {
	
	public VBst VertList;
	public ArrayList<Edge> EList;
	public ArrayList<ArrayList<Integer>> EdgeList=new ArrayList<ArrayList<Integer>>();
	public ArrayList<Vertex> vlist=new ArrayList<Vertex>();

	public Vertex Root;
	public Graph(){}
	public Graph(ArrayList<Vertex> VList,ArrayList<Edge> eList,Integer r){
		EList=eList;
		for(Edge e : eList){
			ArrayList<Integer> tempE = new ArrayList<Integer>();
			tempE.add(e.start.Id);
			tempE.add(e.end.Id);
			tempE.add(e.Weight);
			EdgeList.add(tempE);
		}
		VertList=MakeVertList();
		VertList.Iterate(VertList.root);
		vlist=VertList.vlist;
		Root=findV(r);
	}

	public Graph(ArrayList<ArrayList<Integer>> edgeList,Integer r) {
		EdgeList=edgeList;
		VertList=MakeVertList();
		Root=findV(r);
		VertList.Iterate(VertList.root);
		vlist=VertList.vlist;
		
	}
		
	public VBst MakeVertList(){
		VBst inList=new VBst();
		for(int i = 0;i<EdgeList.size();i++){
			ArrayList<Integer> edge=EdgeList.get(i);
			Vertex v1=inList.find(edge.get(0).toString());
			Vertex v2=inList.find(edge.get(1).toString());
			if(v1==null&&v2==null){//both not in bst
				v1=new Vertex(edge.get(0));
				v2=new Vertex(edge.get(1));
				v1.addEdge(v2,edge.get(2));
				v2.addEdge(v1,edge.get(2));
				inList.ins(v1);
				inList.ins(v2);
			}
			else if(v1!=null&&v2==null){//1 in bst but not 2
				v2=new Vertex(edge.get(1));
				v1.addEdge(v2,edge.get(2));
				v2.addEdge(v1,edge.get(2));
				inList.ins(v2);
			}
			else if(v1==null&&v2!=null){//2 in bst but not 1
				v1=new Vertex(edge.get(0));
				v1.addEdge(v2,edge.get(2));
				v2.addEdge(v1,edge.get(2));
				inList.ins(v1);
				inList.ins(v2);	
			}
			else{//both in bst
				v1.addEdge(v2,edge.get(2));
				v2.addEdge(v1,edge.get(2));
				inList.ins(v1);
				inList.ins(v2);	
			}
		}
		return inList;
	}

	public Vertex findV(Integer i){
		return VertList.find(i.toString());
	}

	@SuppressWarnings("unused")
	public ArrayList<Integer> Bfs() {
		ArrayList<ArrayList<EdgeStr>> res = new ArrayList<ArrayList<EdgeStr>>();
		ArrayList<EdgeStr> r = new ArrayList<EdgeStr>();
		ArrayList<Integer> results = new ArrayList<Integer>();
		Integer noReach=0;
		Integer w =0;
		Root.Depth=0;
		VQueue nodes=new VQueue();
		Vertex t=Root;
		t.bfsroot=true;
		t.setParent(t);
		nodes.insert(t);
		noReach++;
		if(VertList.root==null){
			System.out.println("!Empty Tree!");
			return new ArrayList<Integer>(2);
		}
		int nxtLv=1;
		while(nodes.getfront()!=null){
			t=nodes.gethead();
			for(Edge e:t.getEdges()){e.end.setParent(t);}
			if(t.color=="b"){continue;}
			t.color="b";
			if(t==null){continue;}
			if(nxtLv==t.Depth){
				nxtLv++;
				res.add(r);
				r = new ArrayList<EdgeStr>();
				r.add(new EdgeStr(t.Id,t.getRoot().Id,t.tempW));
				for(Edge e : t.getEdges()){
					if(e.end==null){continue;}
					if(e.end.color.equals("b")){continue;}
					w+=e.Weight;
					e.end.Depth=nxtLv;
					e.end.setParent(t);
					e.end.tempW=e.Weight;
					nodes.insert(e.end);
					noReach++;
				}
				continue;
			}
			else{
				if(t.bfsroot==true){
					r.add(new EdgeStr(t.Id));
				}
				else{
					r.add(new EdgeStr(t.Id,t.getRoot().Id,t.tempW));
				}
				for(Edge e : t.getEdges()){
					if(e.end==null){continue;}
					if(e.end.color.equals("b")){continue;}
					w+=e.Weight;
					e.end.Depth=nxtLv;
					e.end.setParent(t);
					e.end.tempW=e.Weight;
					nodes.insert(e.end);
					noReach++;
				}
			}
		}
		res.add(r);
		//sort then print list of edges by level in traversal 
		for(ArrayList<EdgeStr> row : res){
			Collections.sort(row,new Comparator<EdgeStr>(){
				public int compare(EdgeStr  o1, EdgeStr o2){
					return o1.W-o2.W;
				}
			});
		}
		for(int i=0;i<res.size();i++){
			System.out.print((i)+":");
			for(EdgeStr e : res.get(i)){
				e.print();
			}
			System.out.println();
		}
		results.add(noReach);
		results.add(w);
		return results;
	}
		


	
	
}
