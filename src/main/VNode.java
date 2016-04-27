package main;
//////////////////
//  adam pluth	//
//  cs 201	//
//  Kruskal's 	//
//  algorithim	//
//  Project 3	//
//  4/20/16	//
//////////////////


public class VNode {
	private VNode Left,Right,Parent;
	private Vertex data;
	private boolean red;
	private int frequency;
	private int depth;
	
	public VNode(Vertex s,VNode p, int i){
		Left=Right=null;
		data=s;
		red=true;
		frequency=1;
		depth=i;
		Parent=p;
	}

	public boolean isRed(){
		if(red){return true;}
		else{return false;}
		}
	
	public void setLeft(VNode n){this.Left=n;}
	
	public void setRight(VNode n){this.Right=n;}
	
	public void setParent(VNode n){this.Parent=n;}
	
	public void setData(Vertex s){this.data=s;}
	
	public void makeRed(){this.red=true;}
	
	public void makeBlack(){this.red=false;}
	
	public void incFreq(){this.frequency++;}
	
	public void decFreq(){this.frequency--;}

	public void setDepth(int d){this.depth=d;}
	
	public VNode getLeft(){return this.Left;}
	
	public VNode getRight(){return this.Right;}
	
	public VNode getParent(){return this.Parent;}
	
	public Vertex getData(){return this.data;}
	
	public int getFreq(){return this.frequency;}
	
	public int getDepth(){return this.depth;}
	
	public String getLorR() {
		if(this.Parent.Left!=null&&this.data==this.Parent.Left.data){return "L";}
		else {return "R";}
	}

	public VNode getUncle() {//might be wrong
		if(this.Parent.getLorR()=="L"){return this.Parent.Parent.Right;}
		else{return this.Parent.Parent.Left;}
	}

	public boolean linear() {
		if(this.getLorR()=="L"&&this.Parent.getLorR()=="L"||this.getLorR()=="R"&&this.Parent.getLorR()=="R"){return true;}
		else{return false;}
	}

	public VNode getSib() {
		if(this.getLorR()=="L"){return this.Parent.Right;}
		else if(this.getLorR()=="R"){return this.Parent.Left;}
		else return null;
	}

	public VNode getNeph() {
		if(this.getLorR()=="L"){return this.Parent.Right.Right;}
		else if(this.getLorR()=="R"){return this.Parent.Left.Left;}
		else return null;
	}

	public VNode getNeice() {
		if(this.getLorR()=="L"){return this.Parent.Right.Left;}
		else if(this.getLorR()=="R"){return this.Parent.Left.Right;}
		else return null;
	}

	public String isRedPrint() {
		if(red){return "*";}
		else{return "";}
	}

}
