import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DinamicArray<T> implements Iterable<T>{

    private T[] arr;
    private int len=0;
    private int capacity=0;

    public DinamicArray(){this(16);}

    public DinamicArray(int capacity){
        if(capacity<0) throw new IllegalArgumentException("Illeagal Capacity: "+capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size(){return len;}
    public boolean isEmpty() {return size()==0;}

    public T get(int index){return arr[index];}
    public void set(int index, T elem){arr[index]=elem;}

    public void clear(){
        for(int i=0;i<capacity;i++){
            arr[i] = null;
            len=0;
        }
    }

    public void add(T elem){
        if(len+1>=capacity){ //Resize the array

            if(capacity==0) capacity=1;
            else capacity*=2;//Double the size
            T[] new_arr = (T[]) new Object[capacity];
            for(int i=0;i<len;i++){
                new_arr[i] = arr[i];

            }
            arr = new_arr;
        }
        //arr[len++]=elem;

        arr[len]=elem;
        len++;


    }

    public T removeAt(int idx){
        if(idx>=len || idx<0) throw new IndexOutOfBoundsException();
        T data = arr[idx];
        T[] new_arr = (T[]) new Object[len-1];
        for(int i=0,j=0;j<len;i++,j++){
            if(j==idx) {
                i--;
            }
            else {
                new_arr[i] = arr[j];
            }
        }
        arr = new_arr;
        capacity = --len;
        return data;
    }

    public boolean remove(T obj){
        for(int i=0;i<len;i++){
            if(arr[i].equals(obj)){
                System.out.println("Found at "+ i);
                removeAt(i); return true;
            }
        }
        return false;
    }

    public int indexOf(T obj){
        for(int i=0;i<len;i++){
            if(arr[i].equals(obj)){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T obj){
        int idx = indexOf(obj);
        return idx!=-1;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index =0;
            @Override
            public boolean hasNext() {
                return index<len;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }

    @Override public String toString(){
        if(len==0) return "[]";
        else{
            StringBuilder sb = new StringBuilder("len : "+ len).append("[");
            for(int i=0;i<len-1;i++){
                sb.append(arr[i]).append(", ");
            }
            return sb.append(arr[len - 1]).append("]").toString();
        }
    }
}
