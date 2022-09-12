public class SynchronizedBuffer implements Buffer{
    //compartilahdo pelas threads producer e consumer
    private int buffer = -1;
    private boolean occupied = false;

    //coloca o valor no buffer
    @Override
    public synchronized void blockingPut(int value) throws InterruptedException {
        // Enquanto nao houver posicoes vazias, coloca a thread em esado de espera
        while(occupied) {
            //envia informacoes da thread e do buffer para a saida, enao espera
            System.out.println("Producer tries to write.");
            displayState("Buffer full. Producer waits");
            wait();
        }
        buffer = value;    //configurando novo valor de buffer

        //indica que a produtora nao pode armazenar outro valor
        //ate a consumidora recuperar valor atual de buffer
        occupied = true;

        displayState("Producer writes "+buffer);

        notifyAll();//inclui threads em espera a entrar no estado de executável
    }

    //retorna o valor do buffer
    @Override
    public synchronized int blockingGet() throws InterruptedException {
        // enquanto o dados nao sao lidos, coloca athread em estado de espera
        while(!occupied) {
            //envia informacoes da thread e do buffer para a saida, entao espera
            System.out.println("Consumer tries to read.");
            displayState("Buffer empty. Consumer waits");
            wait();
        }
        //indica que a produtora pode armazenar outro valor
        //porque a consumidora acabou de recuperar o valor do buffer
        occupied = false;

        displayState("Consumer reads "+buffer);

        notifyAll();//Insrui threads em espera a entrar no estado executavel
        return buffer;
    }

    //exibe a operação atual e o estado de buffer
    private synchronized void displayState(String operation) {
        System.out.printf("%-40s%d\t\t%b%n%n", operation, buffer, occupied);
    }

}