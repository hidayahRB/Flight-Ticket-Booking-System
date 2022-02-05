
/**
 *
 * @author Afifah Abdul Halim
 */
public class Queue<T> {
    int head;   //this is pointer 1, doesnt move, only use to remove element(dequeue)
    int tail;   //this is pointer 2, similar to top in stack, to add element(enqueue)
    int size;
    T data[];
    
    public Queue(int n) {
        this.head = -1;
        this.tail = -1;
        this.size = n;
        data = (T[]) new Object[size];
    }
    
    public boolean isEmpty(){
        return tail == -1;   
    }
    
    public boolean isFull() {
        return tail >= size-1;
    }
    
    public void enqueue(T input) {
        if (isEmpty()) { //queue is empty 
            tail++;
            data[tail] = input;
            head++;
            //System.out.println("Enqueue " + "[" +tail + "]" + input + " done..");
        }
        else {
            if (isFull()) { //queue is full 
                System.out.println("Queue is full..");
            }
            else { //not full and not empty
                tail++;
                data[tail] = input;
                //System.out.println("Enqueue " + "[" +tail + "]" + input + " done..");
            }
        }
    }
    
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty, cannot dequeue element..");
        }
        else {
            T temp = data[head];
            for (int i = 0; i < tail; i++) {
                data[i] = data[i+1];
            }
            tail--;
            System.out.println("Dequeue " + temp + " from the queue..");
        }
    }
    
    public void peek() {
        System.out.println("Peek last element in the queue " +  data[tail]);
    }
    
    public void display() {
        for (int i = 0; i < tail; i++) {
            System.out.print("[" + i + "]" + data[i] + "  ");
        }
        System.out.println();
    }
}
