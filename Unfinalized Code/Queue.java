package flight.system;

/**
 *
 * @author hanif
 */
public class Queue {

    private Ticket[] waitingList; 
    private Ticket[] confirmed;// array to store queue elements
    private int front;      // front points to the front element in the queue
    private int rear;       // rear points to the last element in the queue
    private int capacity;   // maximum capacity of the queue
    private int count;      // current size of the queue
    private int index;
 
    // Constructor to initialize a queue
    Queue(int size)
    {
        waitingList=new Ticket[size];// array with 
         confirmed= new Ticket[size];
         index=0;
        
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }
 
    // Utility function to dequeue the front element
    public Ticket dequeue()
    {
        // check for queue underflow
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
 
        Ticket x = waitingList[front]; 
        confirmed[index]=x; // adding ticket from queue to array
             
        front = (front + 1) % capacity; // removing ticket from queue
        count--;
        index++;
 
        return x;
    }
 
    // Utility function to add an item to the queue
    public void enqueue(Ticket item)
    {
        // check for queue overflow
        if (isFull())
        {
            System.out.println("Overflow\nProgram Terminated");
            System.exit(-1);
        }
 
      
        rear = (rear + 1) % capacity;
       waitingList[rear] = item;
       
        count++;
    }
 
    // Utility function to return the size of the queue
    public int size() {
        return count;
    }
 
    // Utility function to check if the queue is empty or not
    public boolean isEmpty() {
        return (size() == 0);
    }
 
    // Utility function to check if the queue is full or not
    public boolean isFull() {
        return (size() == capacity);
    }
    public void printQueue()
    {
        
        System.out.println("Printing confirmed tickets list");
        for(int i=0;i<index;i++)
        {
        System.out.println(confirmed[i]);
  
    }
}
}