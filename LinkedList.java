
public class LinkedList<T> implements Iterable<T>{

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    // Node class to represent data
    private class Node<T>{
        T data;
        Node <T> prev, next;
        public Node(T data, Node<T> prev, Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        @Override
        public String toString(){
            return data.toString();
        }
    }

    public void clear(){
        Node<T> trav = head;
        Node<T> follow = head;

        while(trav!=null){
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public void add(T elem){
        addLast(elem);
    }

    public void addFirst(T elem){
        if(isEmpty()){
            head = tail = new Node<T>(elem,null,null);
        }else{
            head.prev = new Node<T>(elem,null,head);
            head = head.prev;
        }
        size++;
    }

    public void addLast(T elem){
        if(isEmpty()){
            head = tail = new Node<T>(elem,null,null);
        }else{
            tail.next = new Node<T>(elem,tail,null);
            tail = tail.next;
        }
        size++;
    }

    public T peekFirst(){
        if( isEmpty()) throw new RuntimeException("Empty list");
        return head.data;
    }
    public T peekLast(){
        if( isEmpty()) throw new RuntimeException("Empty list");
        return tail.data;
    }

    public T removeFirst(){
        if( isEmpty()) throw new RuntimeException("Empty list");

        T data = head.data;
        head = head.next;
        size--;

        if(isEmpty()){
            tail = null;
        }
        else{
            head.prev = null;
        }
        return data;
    }

    public T removeLast(){
        if(isEmpty()) throw new RuntimeException("Empty list");
        T data = tail.data;
        tail = tail.prev;
        size--;
        if(isEmpty()){
            head = null;
        }else{
            tail.next = null;
        }
        return data;
    }

    public T remove(Node <T> node){
        if(node.prev == null) return removeFirst();
        if(node.next == null) return removeLast();

        T data = node.data;
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node = node.prev = node.next = null;
        size--;
        return data;
    }

    //Eliminar un nodo de un indice en especifico
    public T removeAt(int index){
        if(index<0 || index >=size ) throw new IllegalArgumentException();
        int i;
        Node<T> trav;

        if(index < size/2){ //Buscar desde Head
            for(i =0, trav=head;i!=index;i++){
                trav = trav.next;
            }
        }else{ //Buscar desde tail
            for(i =size-1, trav=tail;i!=index;i--){
                trav = trav.prev;
            }
        }
        return remove(trav);
    }

    //Eliminar un valor particular
    public boolean remove(Object obj){
        Node <T> trav = head;

        if(obj ==null){ // Buscar nodo con valor null
            for(trav=head;trav!=null;trav=trav.next){
                if(trav.data==null){
                    remove(trav);
                    return true;
                }
            }
        }else{ //not null search
            for(trav=head; trav!=null; trav=trav.next){
                if(obj.equals(trav.data)){
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    public int indexOf(Object obj){
        int count=0;
        Node<T> trav;
        if(obj ==null){ // Buscar nodo con valor null
            for(trav=head;trav!=null;trav=trav.next, count++){
                if(trav.data==null){
                    return count;
                }
            }
        }else {
            for (trav = head; trav != null; trav = trav.next, count++) {
                if (obj.equals(trav.data)) {
                    return count;
                }
            }
        }
        return -1;
    }
    public boolean contains(Object obj){
        int idx = indexOf(obj);
        return idx!=-1;
    }

    @Override public java.util.Iterator<T> iterator(){
        return new java.util.Iterator<T>(){
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav!=null;
            }
            @Override
            public T next(){
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }

    @Override public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> trav = head;
        while (trav != null) {
            sb.append(trav.data + ", ");
            trav = trav.next;
        }
        sb.append("]");
        return sb.toString();
    }

}

