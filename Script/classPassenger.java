/**
 *
 * @author Hidayah
 * @param <T>
 */
public class Passenger <T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    // constructor
    public Passenger(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    // retrieve the size of list
    public int getSize(){
        return this.size;
    }

    // check whether there is a list or not
    public boolean isEmpty(){
        return this.size == 0;
    }
    
    // Return passenger's name (implement getLast method from LL)
   public T getPassengerName(){
        if (isEmpty()) {
            return null;
        }
        return tail.getName();
    }
    
    // add element at tail
    public void addLast(T name, T passport, T age, T phone, T add){
        Node<T> newNode = new Node<>(name, passport, age, phone, add);
        if (isEmpty()) {
            this.head = newNode;    // points head to new Node
        }else{
            tail.setNextNode(newNode);  // set newNode as a node after current tail
        }
        this.tail = newNode;    // update current tail
        this.size++;
        
    }
    
    // remove element at head
    public void removeFirst(){
        if (isEmpty()) {
            System.out.println("There are no passengers for this flight...");
        }
        Node e = head;
        head = head.getNextNode();  // set new head, which is the node next to head
        this.size--;    
        if (isEmpty()) {
            tail = null;
        }
        
        System.out.println("-----REMOVED-----");
        System.out.println(e.toString());
        System.out.println("-----------------");
    }
    
    public boolean contains(T passport){
        if (isEmpty()) {
            return false;
        }
        Node<T> current = head;
        while(current != null && !current.getPassport().equals(passport)){
            current = current.getNextNode();
        }
        
        if (current != null) {
            return current.getPassport().equals(passport);
        }else{
            return false;
        }
        
    }
    
    @Override
    public String toString(){
        if (isEmpty()) {
            return null;
        }
        String result = "";
        result += "[Total Passenger =" + getSize() + "]"; 
        Node<T> current = this.head;
        while(current != null){
            result += current.toString();
            current = current.getNextNode();
        }
        return result;
    }
    
    // 3# Edit Information 
    public void setNewName(T user, T newName){
        Node<T> current = head;
        // traverse the nodes
        while(current != null){
            if (current.getPassport().equals(user)) {
                break;
            }
            current = current.getNextNode();
        }
        // now CURRENT is the same as USER
        // we are setting a NEW NAME for this USER
        current.setName(newName);
    }
    
    public void setNewPassport(T user, T newPass){
        Node<T> current = head;
        // traverse the nodes
        while(current != null){
            if (current.getPassport().equals(user)) {
                break;
            }
            current = current.getNextNode();
        }
        // now CURRENT is the same as USER
        // we are setting a NEW NAME for this USER
        current.setPassport(newPass);
    }
    
    public void setNewAge(T user, T newAge){
        Node<T> current = head;
        // traverse the nodes
        while(current != null){
            if (current.getPassport().equals(user)) {
                break;
            }
            current = current.getNextNode();
        }
        // now CURRENT is the same as USER
        // we are setting a NEW NAME for this USER
        current.setAge(newAge);
    }
    
    public void setNewPhone(T user, T newPhone){
        Node<T> current = head;
        // traverse the nodes
        while(current != null){
            if (current.getPassport().equals(user)) {
                break;
            }
            current = current.getNextNode();
        }
        // now CURRENT is the same as USER
        // we are setting a NEW NAME for this USER
        current.setPhone(newPhone);
    }
    
    public void setNewAdd(T user, T newAdd){
        Node<T> current = head;
        // traverse the nodes
        while(current != null){
            if (current.getPassport().equals(user)) {
                break;
            }
            current = current.getNextNode();
        }
        // now CURRENT is the same as USER
        // we are setting a NEW NAME for this USER
        current.setAddress(newAdd);
    }
    
}
