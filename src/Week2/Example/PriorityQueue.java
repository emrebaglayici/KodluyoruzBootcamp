package Week2.Example;

public class PriorityQueue<T> {
    private Node<T> head;
    private Node<T> tail;


    public void add(T obj,Priority priority){
        Node<T> node=new Node<>(obj,null,null,priority);
        if (head==null){
            head=node;
            tail=node;
        }else {

            if (tail.getPriority().getValue()>=node.getPriority().getValue()){
                tail.setNext(node);
                node.setPrev(tail);
                tail=node;
            }else {
                Node<T> tempNode=tail.getPrev();
                while (tempNode!=null){
                    if (tempNode.getPriority().getValue()>=node.getPriority().getValue()){
                        node.setNext(tempNode.getNext());
                        tempNode.setNext(node);


                        node.setPrev(tempNode);
                        node.getNext().setPrev(node);
                        break;
                    }

                    tempNode=tempNode.getPrev();
                }
            }

        }
    }
    public  T peek(){
        if (head==null)
            return null;
        return head.getValue();
    }
    public T pop(){
        if (head==null)
            return null;
        Node<T> temp=head;
        head=temp.getNext();
        if (head==null)
            tail=null;
        return temp.getValue();
    }
}
