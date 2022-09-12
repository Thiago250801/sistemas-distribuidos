
import java.security.SecureRandom;

public class Consumer implements Runnable{
	private static final SecureRandom generator = new SecureRandom();
	private final Buffer sharedLocation;	//refer�ncia a objeto compartilhado
	
	//construtor
	public Consumer(Buffer sharedLocation) {
		this.sharedLocation = sharedLocation;
	}
	
	//le o valor do sharedLocation 10 vezes e soma os valores
	@Override
	public void run() {
		int sum = 0;
		
		for(int cont = 1; cont <= 10; cont++) {
			try {	//dorme de 0 a 3 segundos, le o valor do Buffer e adiciona a soma
				Thread.sleep(generator.nextInt(3000)); //sono aleat�rio
				sum += sharedLocation.blockingGet();
				System.out.printf("\t\t\t%2d%n", sum);
				
			}catch(InterruptedException exception) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.printf("%n%s %d%n%s%n", "Consumer read values totaling",sum,"Terminating consumer");
	}
}
