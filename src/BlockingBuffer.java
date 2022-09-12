import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer{
    private final ArrayBlockingQueue<Integer> buffer;    //buffer compartilhado

    //construto
    public BlockingBuffer() {
        buffer = new ArrayBlockingQueue<Integer>(1);
    }

    //coloca o valor no buffer
    @Override
    public void blockingPut(int value) throws InterruptedException {
        // coloca o valor no buffer
        buffer.put(value);
        System.out.printf("%s%2d\t%s%d%n",
                "Producer writes", value,
                "Buffer cells occupied: ",
                buffer.size());
    }

    //retorna o valor do buffer
    @Override
    public int blockingGet() throws InterruptedException {
        int readValue = buffer.take();//remove o valor do buffer
        System.out.printf("%s%2d\t%s%d%n",
                "Consumer reads",
                readValue,
                "Buffer cells occupied: ",
                buffer.size());
        return readValue;
    }

}