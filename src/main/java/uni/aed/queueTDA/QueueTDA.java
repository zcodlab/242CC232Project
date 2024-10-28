package uni.aed.queueTDA;

public interface QueueTDA<E> {
    public void enqueue(E data);
    public E dequeue() throws QueueEmptyExceptionTDA;
    public E peek() throws QueueEmptyExceptionTDA;
    public void clear();
    public boolean isEmpty();
    public int size();
}
