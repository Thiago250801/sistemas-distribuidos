
public class UnsynchronizedBuffer implements Buffer{
	private int buffer =  -1; //compartilhado pelas threads producer e consumer
	
	//coloca o valor no buffer
	@Override
	public void blockingPut(int value) throws InterruptedException {
		System.out.printf("Producer writes\t%2d", value);
		buffer = value;
	}

	@Override
	public int blockingGet() throws InterruptedException {
		System.out.printf("Consumer readss\t%2d", buffer);
		return buffer;
	}

}
