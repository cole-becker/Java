public class listy<E> {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> myList = new DoublyLinkedList<Integer>();

        myList.addToEnd(5);
        myList.addToEnd(6);
        myList.addToEnd(7);
        System.out.println(myList);

        myList.addToFront(4);
        myList.addToFront(3);
        myList.addToFront(2);
        System.out.println(myList);

        myList.addToEnd(8);
        myList.addToEnd(9);
        myList.addToEnd(10);
        System.out.println(myList);
    }
}
