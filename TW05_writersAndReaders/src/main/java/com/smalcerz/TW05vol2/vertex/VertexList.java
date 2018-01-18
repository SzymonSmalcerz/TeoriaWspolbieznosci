package com.smalcerz.TW05vol2.vertex;

public class VertexList {

	private Vertex root;
	private Vertex guard;
	
	
	public VertexList(){
		this.guard = new Vertex("guard");
	}
	
	public void printList() {
		
		Vertex current = this.guard;
		
		while(current.getNext() != null) {
			current = current.getNext();
			System.out.print(current.getValue() + " ");
		}
		
	}
	
	
	public void add(Object newLastValue) {
		
		Vertex current = this.guard;
		
		current.lock();
		
		while(current.getNext() != null) {
			current.getNext().lock();
			current.unlock();
			current = current.getNext();
		}
		
		Vertex newLastElement = new Vertex(newLastValue);
		current.setNext(newLastElement);

		current.unlock();
		
		return;
	}
	
	
	public boolean remove(Object obj) {
		
		Vertex current = this.guard;
		
		current.lock();
		
		while(current.getNext() != null) {
			if(current.getNext().getValue().equals(obj)) {
				current.getNext().lock();
				
				current.setNext(current.getNext().getNext());
				
				current.unlock();
				return true;
			}else {
				current.getNext().lock();
				current.unlock();
				current = current.getNext();
			}
		}
		current.unlock();
		
		return false;
		
	}
	
	
	public boolean contains(Object obj) {
		
		Vertex current = this.guard;
		
		
		current.lock();
		
		while(current.getNext() != null) {
			
			current.getNext().lock();
			
			
			if(current.getNext().getValue().equals(obj)) {
				current.getNext().unlock();
				current.unlock();
				return true;
			}
			
			
			current.unlock();
			current = current.getNext();
			
		}

		current.unlock();
		
		return false;
		
	}
	
	public Vertex getFirstElement() {
		return this.root;
	}
}
