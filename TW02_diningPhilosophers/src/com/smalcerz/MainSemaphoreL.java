package com.smalcerz;

import java.util.ArrayList;

public class MainSemaphoreL {
	public static void main(String[] args) {
		try {
			SemaphoreL semaphoreL = new SemaphoreL(2);
			
			ArrayList<KonWyscigowyL> konieWyscigowe = new ArrayList<>();
			konieWyscigowe.add(new KonWyscigowyL("artur",semaphoreL));
			konieWyscigowe.add(new KonWyscigowyL("szymon",semaphoreL));
			konieWyscigowe.add(new KonWyscigowyL("janek",semaphoreL));
			konieWyscigowe.add(new KonWyscigowyL("krzysiek",semaphoreL));
			konieWyscigowe.add(new KonWyscigowyL("tomek",semaphoreL));
			
			konieWyscigowe.forEach(kon -> kon.start());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
