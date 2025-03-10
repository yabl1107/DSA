public class Queue <T>{
    LinkedList<T> list = new LinkedList<T>();

    public Queue(){}
    public Queue(T elem){
        offer(elem);
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public T peek(){
        if(isEmpty()) throw new RuntimeException("Queue empty");
        return list.peekFirst();
    }

    public T poll(){
        if(isEmpty()){
            throw new RuntimeException("Queue empty");
        }
        return list.removeFirst();
    }

    public void offer(T elem){
        list.addLast(elem);
    }



    public void





}
