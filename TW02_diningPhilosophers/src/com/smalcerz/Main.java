package com.smalcerz;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		
		ArrayList<KonWyscigowy> konieWyscigowe = new ArrayList<>();
		konieWyscigowe.add(new KonWyscigowy("artur"));
		konieWyscigowe.add(new KonWyscigowy("szymon"));
		konieWyscigowe.add(new KonWyscigowy("janek"));
		konieWyscigowe.add(new KonWyscigowy("krzysiek"));
		konieWyscigowe.add(new KonWyscigowy("tomek"));
		
		konieWyscigowe.forEach(kon -> kon.start());
		
		
	}
}
