package com.smalcerz.TW05vol2.zadanieDomowe.library;

import java.util.Iterator;

import com.smalcerz.TW05vol2.zadanieDomowe.ludziki.Person;
import com.smalcerz.TW05vol2.zadanieDomowe.ludziki.Writer;

public class Runner {
	
	private Library library;
	
	public Runner() {
		this.library = Library.getInstanceOfLibrary();
	}
	
	
	public void addPerson(Person person) {
		this.library.getFifo().putElement(person);
	}
	
	public void addPeople(Iterator<Person> iOfPeople) {
		
		while(iOfPeople.hasNext()) {
			this.library.getFifo().putElement(iOfPeople.next());
		}
		
	}
	
	public void startTask() {
		
		while(true) {
			if(this.library.getFifo().getElement() instanceof Writer) {
				
			}
		}
		
	}
}

