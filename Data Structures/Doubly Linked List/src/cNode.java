public class cNode<E> {
    E val;
    cNode<E> next;
    cNode<E> prev;

    public cNode(E value){
        this.val = value;
        this.next = null;
        this.prev = null;
    }

    public E getValue(){
        return val;
    }

    public cNode<E> getNext(){
        return next;
    }

    public cNode<E> getPrev(){
        return prev;
    }

    public void setNext(cNode<E> node){
        this.next = node;
    }

    public void setPrev(cNode<E> node){
        this.prev = node;
    }
}
