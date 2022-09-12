
import java.security.SecureRandom;
import java.util.Arrays;

public class ArraySimples {
	private static SecureRandom generator = new SecureRandom();
	//array de inteiros compartilhado
	private final int[] vetor;
	//índice compartilhado do proximo elemento a gravar
	private int writeIndex = 0;
	
	//construtor - cria um ArraySimples
	//de um determinado tamanho
	public ArraySimples(int size) {
		vetor = new int[size];
	}
	
	//adiciona um valor ao array compartilhado
	public void add(int valor) {
		//armazena o índice de gravação
		int posicao = writeIndex;
		
		try {
			//coloca a thread para dorir durante
			//0 a 499 milissegundos
			Thread.sleep(generator.nextInt(500));
		}catch(InterruptedException ex) {
			//reinterrompe a thread
			Thread.currentThread().interrupt();
		}
		vetor[posicao] = valor;
		System.out.printf("%s write %2d to element %d.%n", Thread.currentThread().getName(), valor, posicao);
		//indice de incremento de eleemtno a  ser gravado depois
		++writeIndex;
		System.out.printf("Next write index: %d%n", writeIndex);	
	}
	
	//usado para gerar sapida do conteudo do array
	//de inteiros compartilhado
	public String toString() {
		return Arrays.toString(vetor);
	}

}
