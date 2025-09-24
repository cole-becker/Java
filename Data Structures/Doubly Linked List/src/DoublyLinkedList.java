public class DoublyLinkedList<E> {
    cNode<E> head;
    cNode<E> tail;
    int size;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getLength(){
        return size;
    }

    public void addToFront(E val){
        cNode<E> newNode = new cNode<E>(val);
        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    public void addToEnd(E val){
        cNode<E> newNode = new cNode<E>(val);
        if (tail == null){
            head = newNode;
            tail = newNode;
        }
        else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }

    public void removeFromFront(){

    }

    public void removeFromEnd(){

    }

    public String toString(){
        String temp = "[";
        cNode<E> cur = head;
        while(cur != null)
        {
            temp += cur.getValue();
            if(cur.getNext() != null){
                cur = cur.getNext();
                temp += " | ";
            }
            else {
                break;
            }
        }
        temp += "]";
        return temp;
    }
}
