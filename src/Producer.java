
import java.security.SecureRandom;

public class Producer implements Runnable{
	private static final SecureRandom generator = new SecureRandom();
	private final Buffer sharedLocation;	//refer�ncia a objeto compartilhado
	
	//construtor
	public Producer(Buffer sharedLocation) {
		this.sharedLocation = sharedLocation;
	}
	
	//armazena os valores de 1 a 10 em sharredLocation	
	@Override
	public void run() {
		int sum = 0;
		
		for(int cont = 1; cont <= 10; cont++) {
			try {	//dorme de 0 a 3 segundos, entao coloca o valor no Buffer
				Thread.sleep(generator.nextInt(3000)); //sono aleat�rio
				sharedLocation.blockingPut(cont);
				sum += cont;
				System.out.printf("\t%2d%n", sum);
				
			}catch(InterruptedException exception) {
				Thread.currentThread().interrupt();
			}
		}
		
		System.out.printf("Producer done producing%nTerminating Producer%n");
	}
}
