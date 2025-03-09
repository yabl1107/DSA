
public class Stack {

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

}