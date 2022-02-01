/**
 *
 * idea by Hanii
 * Updated by Hidayah
 * @param <T>
 */

public class Flight<T> {
    private NodeFlight<T> head;
    private NodeFlight<T> tail;
    private int size;
    
    // constructor
    public Flight(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    // check whether there is a list or not
    public boolean isEmpty(){
        return this.size == 0;
    }

    public NodeFlight<T> getHead() {
        return head;
    }
    
    // add element at tail
    public void addLast(T fName, T fDate){
        NodeFlight<T> newNode = new NodeFlight<>(fName, fDate);
        if (isEmpty()) {
            this.head = newNode;  // points head to new Node
        }else{
            tail.setNextNode(newNode);  // set newNode as a node after current tail
        }
        this.tail = newNode;    // update current tail
        this.size++;
    }
    
    public static void printList(Flight list){
        NodeFlight currNode = list.head;
    
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.println(currNode.toString());
            
            // Go to next node
            currNode = currNode.nextNode;
        }
    }
}
