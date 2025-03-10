import java.util.EmptyStackException;
import java.util.Iterator;

public class Stack<T> {

    LinkedList<T> list = new LinkedList<T>();

    public Stack(){}
    public Stack(T firstElement){
        push(firstElement);
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public void push(T elem){
        list.addLast(elem);
    }

    public T pop(T elem){
        if(isEmpty()) throw new EmptyStackException();
        return list.removeLast();
    }

    public T peek(){
        if(isEmpty()) throw new EmptyStackException();
        return list.peekLast();
    }





        public static void main(String[] args) {
            LinkedList<Integer> myList = new LinkedList<Integer>();
            System.out.println(myList);
            myList.add(4);
            System.out.println(myList);
            myList.add(8);
            myList.add(19);
            System.out.println(myList);

            myList.removeFirst();
            myList.removeLast();


            System.out.println(myList);
            myList.add(90);
            myList.add(56);
            myList.add(38);
            System.out.println(myList);
            myList.removeAt(2);
            System.out.println(myList);
            myList.addLast(73);
            System.out.println("Numero : " + myList.indexOf(90));

        }


    public java.util.Iterator<T> iterator(){
        return list.iterator();
    }

}