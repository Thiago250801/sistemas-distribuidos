
public class ArrayWriter implements Runnable{
	private final ArraySimples sharedArraySimples;
	private final int startValue;
	
	//construtor
	public ArrayWriter(int valor, ArraySimples vetor) {
		startValue = valor;
		sharedArraySimples = vetor;
	}
	
	@Override
	public void run() {
		for(int i = startValue; i < startValue + 3; i++) {
			sharedArraySimples.add(i);
		}
	}

}
