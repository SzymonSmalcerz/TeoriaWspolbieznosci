package com.smalcerz.vertex;

import java.io.BufferedWriter;
import java.io.IOException;

public class VertexDrawer {
	public static int guard = 0;
	public static void draw(Vertex node,BufferedWriter writer) {
		node = node.getMaxAtLeftElement().getMaxAtTopElement();
		
		
		try {
			writer.newLine();
			writer.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Vertex temp = node.getMaxAtLeftElement().getMaxAtTopElement();
		Vertex temp2 = temp;
		
		do {
			try {
				writer.write("		");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			do{
				int label = temp.getLabel();
				try {
					writer.write(Integer.toString(label));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				temp = temp.getRight();
				if(temp!=null) {
					
					for(int t=0;t<4-Math.min(Math.floor(label/10), 1);t++) {
						try {
							writer.write("-");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
				
			}while(temp != null);
			temp2 = temp2.getDown();
			temp = temp2;
			try {
				writer.newLine();
				writer.write("		");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int k=0; k<node.getWidth()-1;k++) {
				try {
					writer.write("_____");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			try {
				writer.write("__");
				writer.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(temp2!=null);
	}
}
