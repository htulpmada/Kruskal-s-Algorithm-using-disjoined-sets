package main;
//////////////////
//  adam pluth	//
//  cs 201	//
//  Kruskal's 	//
//  algorithim	//
//  Project 3	//
//  4/20/16	//
//////////////////


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class kruskal {
	static int i=0;
	private static Integer root=null;
	static ArrayList<ArrayList<Integer>> EdgeList=new ArrayList<ArrayList<Integer>>();
	
	
	public static void main(String[] args) {
		i=processArgs(args);
		readInFiles(args[i]);
		if(root==null){root=EdgeList.get(0).get(0);}
		new DisJoinSet(new Graph(EdgeList,root));
	}	
	
	public static void readInFiles(String args){
		File file = new File(args);
		try {
			ArrayList<Integer> E=new ArrayList<Integer>();
			Scanner s = new Scanner(file);
			String word;
			while(s.hasNext()){
				word=s.next();
				if(word.equals(";")){
					if(E.size()<3){E.add(1);}
					EdgeList.add(E);
					E=new ArrayList<Integer>();
					continue;
				}
				try{
					int vert=Integer.parseInt(word);
					E.add(vert);
				}
				catch(NumberFormatException n){//example input 11 12 2;
					word=word.substring(0,word.length()-1);
					int vert=Integer.parseInt(word);
					E.add(vert);
					EdgeList.add(E);
					E=new ArrayList<Integer>();
					continue;
				}
			}
			s.close();	
		}
		catch(IndexOutOfBoundsException e){
			System.out.println("Out Of Bounds/ invalid input");
			e.printStackTrace();			
		}
		catch (FileNotFoundException e) {
			System.out.println("File not Found");
			e.printStackTrace();
			System.exit(0);
		}	
	}
				
	public static int processArgs(String[] args){
		int index=0;
		for(int i=0;i<args.length;i++){
			if(args[i].equals("-r")){
				root=Integer.parseInt(args[i+1]);
				i++;
				continue;
			}
			else{
				index=i;
				break;
			}
		}
		return index;
	}

}
