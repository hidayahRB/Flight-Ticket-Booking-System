/*@author Afifah
 * Updated by Hidayah
 * Updated by Hanii
 */
public class LinkedList<T> {
   Node head;
   static  int size=0;

   static class Node<T> {
   
    T name;
    T passport;
    T phone;
    T address;
    T age;
    Flight data;
    Node<T> nextNode;
   
    // Constructor
        Node(Flight d)
        {
            data = d;
            nextNode = null;
        }
    
    Node(T name, T passport, T age, T phone, T add){
        this.name = name;
        this.passport = passport;
        this.age = age;
        this.phone = phone;
        this.address = add;
    }
    
      public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getPassport() {
        return passport;
    }

    public void setPassport(T passport) {
        this.passport = passport;
    }

    public T getPhone() {
        return phone;
    }

    public void setPhone(T phone) {
        this.phone = phone;
    }

    public T getAddress() {
        return address;
    }

    public void setAddress(T address) {
        this.address = address;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }
    
    @Override
    public String toString(){
        return "Name: " + this.name + "\nPassport: " + this.passport +
                "\nAge: " + this.age + "\nPhone: " + this.phone +
                "\nAdress: " + this.address;
    }}
          
     public static LinkedList insert(LinkedList list, Flight data)
    {
        
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.nextNode = null;
   
        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = list.head;
            while (last.nextNode != null) {
                last = last.nextNode;
            }
   
            // Insert the new_node at last node
            last.nextNode = new_node;
        }
    size++;
        // Return the list by head
        return list;
       
    }
    
     public static void printList(LinkedList list)
    {
        Node currNode = list.head;
    
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.println(currNode.data+ " ");
    
            // Go to next node
            currNode = currNode.nextNode;
        }
    }
        }
  
   
  
    

