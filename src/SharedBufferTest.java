
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedBufferTest {

	public static void main(String[] args) throws InterruptedException{
		// cri novo pool de threads com duas threads
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		//cria UnsynchronizedBufer para armazenar ints
		Buffer sharedLocation = new UnsynchronizedBuffer();
		
		System.out.println("Action\t\tValue\tSum of Produced\tSum of Consumed");
		System.out.printf("------\t\t-----\t---------------\t------------%n%n");
		
		//executar producer e Consumer, dando a cada um acesso a sharedLocation
		executorService.execute(new Producer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		
		executorService.shutdown();//termina o aplicativo quando as tarefsa concluem
		executorService.awaitTermination(1, TimeUnit.MINUTES);
	}
}
