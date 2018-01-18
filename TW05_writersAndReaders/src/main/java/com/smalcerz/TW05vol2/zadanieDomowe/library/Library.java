package com.smalcerz.TW05vol2.zadanieDomowe.library;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.smalcerz.TW05vol2.zadanieDomowe.helpers.Random;
import com.smalcerz.TW05vol2.zadanieDomowe.ludziki.FifoOfPeople;
import com.smalcerz.TW05vol2.zadanieDomowe.ludziki.Reader;
import com.smalcerz.TW05vol2.zadanieDomowe.ludziki.Writer;
//singleton
@SuppressWarnings("unused")
public class Library {

	private static Library library;
	
	//fifo
	private FifoOfPeople fifo;
	//locks
	private Lock lock;
	private Lock writerLock;
	//conditions
	private Condition writerIsWaiting;
	private Condition noMoreReaders;
	//helpers
	private boolean writerIsWaitingForEmptyLibrary = false;
	private int countOfReadersInLibrary = 0;
	
	private Library() {
		this.fifo = new FifoOfPeople();
		this.lock = new ReentrantLock();
		this.writerLock = new ReentrantLock();
		this.writerIsWaiting = this.lock.newCondition();
		this.noMoreReaders = this.lock.newCondition();
	}
	
	
	
	@SuppressWarnings("static-access")
	public void startWriterTask(Writer writer) throws InterruptedException {
		this.writerLock.lock();
		this.lock.lock();
		
		
//		System.out.println("HERE2");
		this.writerIsWaitingForEmptyLibrary = true;
//		System.out.println("HERE3");
		while(this.countOfReadersInLibrary > 0) {
			//System.out.println("writer is waiting for readers to go out of library, writer id: " + writer.getId());
			this.noMoreReaders.await();
			
		}
		
	
		
		//System.out.println("Writer with id: " + writer.getId() + " has started writing");
		//writer.sleep(Random.getRandom(10, 100));
		Writer.sleep(100);
		//System.out.println("Writer with id: " + writer.getId() + " has just finished writing\n\n");
		
		
		this.writerIsWaiting.signalAll();//signal all of readers that are waiting in the queque
		this.writerIsWaitingForEmptyLibrary = false;
		
		this.writerLock.unlock();
		this.lock.unlock();
		
	}
	
	
	@SuppressWarnings("static-access")
	public void startReaderTask(Reader reader) throws InterruptedException {
		
		
		this.lock.lock();
		while(this.writerIsWaitingForEmptyLibrary) {
			//System.out.println(" reader is waiting, writer is waiting for library or is in library, reader id: " + reader.getId());
			this.writerIsWaiting.await();
		}
		this.countOfReadersInLibrary +=1;
		this.lock.unlock();
		
		//System.out.println("Reader with id: " + reader.getId() + " has started reading");
		//reader.sleep(Random.getRandom(100, 500));
		Reader.sleep(120);
		//System.out.println("Reader with id: " + reader.getId() + " has just finished reading");
		
		
		this.lock.lock();
		this.countOfReadersInLibrary -=1;
		if(this.countOfReadersInLibrary <= 0) {
			this.noMoreReaders.signal();
			//System.out.println("\n\nreaders out of library");
		}
		this.lock.unlock();
		
		
		
		
	}
	
	public FifoOfPeople getFifo() {
		return this.fifo;
	}
	
	public synchronized static Library getInstanceOfLibrary() {
		if(library == null) {
			  library = new Library();
		}
		return library;
	}
	
	
	
}
