package com.KatsProject.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
public class MakeFile {
	public static void main(String[] args) throws IOException {
		 DecimalFormat df = new DecimalFormat("00000000");
		 Integer numWords, NodeID, counter, numNodes   = 0;
		 Integer numLines = 1;
		 String newNodeID = "";
		 String  header   =   "road_id	    #_of_nodes      	node_id	        node_x_coord	    node_y_coord	... end of list";
		 String finishedLine1 = " ";
		 String finishedLine2 = " ";
		 String finishedLine3 = " ";
		 String finishedLine  = " ";
		 String roadID  = "";
		 String roadID2 = "";
		 String match   = " ";
		 String match2  = " ";
		 BufferedReader br = null;
		 BufferedWriter bw = null;
		 HashMap<String, String> nodes = new HashMap<String, String>();
		 br = new BufferedReader(new FileReader("C:\\Users\\gary\\Desktop\\roads.txt"));
		 try {
			    bw = new BufferedWriter(new FileWriter("C:\\Users\\gary\\Desktop\\Secretfile"));
			} catch (IOException e) {
				System.out.println("Error writing file");
				e.printStackTrace();
			}
		 String line  = null;
		 while( (line = br.readLine())!= null )
	     {   
		    if(numLines > 1){
			numWords = 0;  
			nodeID  += 1; 
			newNodeID = df.format(nodeID);
			String [] tokens = line.split("\\s+");
			roadID = tokens[0];                                  // save roadID for comparison
			finishedLine1 = "";
		      for(String s :tokens){
		    	  numWords += 1; 
			      if(numWords ==2 ){
			    	 match  += s;
			      }
			      if(numWords ==3 ){
			    	 match2 += s;
			      }
			      if(numWords == 4 ){
			    	  finishedLine3 += s.trim();				//for hash table
			    	  finishedLine3 = finishedLine3.trim();
			    	  finishedLine1 += s;
			    	  finishedLine1 = finishedLine1.trim();
			    	  finishedLine1 += "      ";
			      }
			      if(numWords == 5){
			    	  finishedLine3 += s.trim();                 //for hash table
			    	  finishedLine3 = finishedLine3.trim();
			    	  finishedLine1 += s;
			    	  finishedLine1 = finishedLine1.trim();
				      finishedLine1 += "      ";
			          Set<String> keySet = nodes.keySet();
			          Iterator<String> keyIterator = keySet.iterator();
			          if(nodes.containsKey(finishedLine3))
			          {  
			        	 while (keyIterator.hasNext()) {
				        	  counter += 1;
				        	  String keys = keyIterator.next();
				        	  keys = keys.trim();
				        	  String varchar = nodes.get(keys);
				        	  if (keys.equals(finishedLine3))
						      {
				        		  newNodeID = varchar;
				        		  nodes.put(finishedLine3, newNodeID );
						          finishedLine3 = "";
						      }
				          }
			          }
			          else{
			          nodes.put(finishedLine3,newNodeID );
			          }
			          match2 = "";
			    	  match  = "";
        		   }
    		  }
		      if ((!(roadID.equals(roadID2))) && (match.equals(match2)) &&  numNodes > 0 )
		      {
		    	   finishedLine += roadID2;
			       finishedLine += "              ";
			       finishedLine += numNodes;
			       finishedLine += "             ";
			       finishedLine += finishedLine2;
			       finishedLine += "...end of list \n";
			       bw.write(finishedLine);
				   bw.write("\n");
				   finishedLine  = " ";
				   finishedLine2 = " ";
				   finishedLine3 = " ";
				   numNodes = 0;
				   roadID2  = roadID;
			   	   match    = "";
		    	   match2   = "";
		      }
		      if((roadID.equals(roadID2)) || roadID2 == ""){
		    	  finishedLine2 += newNodeID;
		    	  finishedLine2 += "          ";
		    	  finishedLine2 += finishedLine1;
		    	  finishedLine2 += "              ";
		       	  numNodes += 1;
		    	  finishedLine1 = "";
		    	  match2 = "";
		    	  match = "";
		      }
			  finishedLine3 = "";
		 }
	     else{
			   bw.write(header + "\n");
			   numLines += 1;
     	  }
		  roadID2 = roadID;
		  match   = "";
   	      match2  = "";
	   }    
	   br.close(); 
	}	 
}


