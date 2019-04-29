package graph.consistsOf;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {
    private Node head;
    private Node tail;

    public DoublyLinkedList(){

    }

    public DoublyLinkedList(T data){
        if(data == null){
            throw new NullPointerException("Error! Defining the head of the sll with null data");
        } else {
            head = new Node(data);
            tail = head;
        }
    }

    public void add(T data){
        if(data == null){
            throw new NullPointerException("Error! Defining the head of the sll with null data.");
        }
        if(head == null){
            head = new Node(data);
            tail = head;
        } else {
            Node tail = this.tail;
            this.tail.next = new Node(data);
            this.tail = this.tail.next;
            tail.next = this.tail;
            this.tail.prev = tail;
        }
    }

    public void addHead(T value){
        Node temp = new Node(value);
        Node current = head;
        head = temp;
        head.next = current;
        head.prev = null;
    }

    public void remove(T data){
        if(head == null){
            throw new NullPointerException("Error! Cannot remove the head, the node is undefined.");
        } else {
            if(head.data == data){
                removeHead();
            } else {
                if(head.next == null){
                    throw new NoSuchElementException("Error! No such elements in the sll with data " + data.toString() + ", try again with another input parameter.");
                } else {
                    if(!removeRecursive(head, head.next, data)){
                        throw new NoSuchElementException("Error! No such elements in the sll with data " + data.toString() + ", try again with another input parameter.");
                    }
                }
            }
        }
    }

    private boolean removeRecursive(Node previous, Node current, T data){
        if(current != null){
            if(current.data.equals(data)){
                if(current.next != null){
                    previous.next = current.next;
                } else {
                    previous.next = null;
                }
                return true;
            } else {
                removeRecursive(current, current.next, data);
            }
        }
        return false;
    }

    public void removeHead(){
        if(head == null){
            throw new  NullPointerException("Error! Cannot remove the head, the node is undefined.");
        } else {
            if(head.next != null){
                head = head.next;
                head.prev = null;
            } else {
                head = null;
            }
        }
    }

    public void removeTail(){
        if(head == null){
            throw new  NullPointerException("Error! Cannot remove the head, the node is undefined.");
        } else {
            Node temp = head;
            if(temp.next == null){
                head = null;
            } else {
                while(temp.next != tail){
                    temp = temp.next;
                }
                tail = temp;
                tail.next = null;
            }
        }
    }

    public void removeDLL(){
        head = null;
    }

    public int size(){
        return sizeRecursive(head, 0);
    }

    private int sizeRecursive(Node node, int amount){
        if(node != null){
            return sizeRecursive(node.next, amount + 1);
        } else {
            return amount;
        }
    }

    @Override
    public String toString() {
        return display(head, new StringBuilder("null<->{head}/"));
    }

    private String display(Node node, StringBuilder sll){
        if(node != null){
            sll
                    .append("(")
                    .append(node.data)
                    .append(")")
                    .append("<->");
            if(node.next != null){
                return display(node.next, sll);
            } else {
                return sll.toString().concat("null");
            }
        } else {
            return sll.toString().concat("null");
        }
    }

    class Node {
        private T data;
        private Node next = null;
        private Node prev = null;

        Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
