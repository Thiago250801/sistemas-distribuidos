
public interface Buffer {
	//coloca o valor no Buffer
	public void blockingPut(int value) throws InterruptedException;
	
	//retorna o valor int no Buffer
	public int blockingGet() throws InterruptedException;
}
