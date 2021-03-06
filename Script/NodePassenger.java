/**
 *
 * @author Hidayah
 * @param <T>
 */
public class NodePassenger<T> {
    T name;
    T passport;
    T phone;
    T address;
    T age;
    NodePassenger<T> nextNode;
    
    // constructor for class Passenger
    NodePassenger(T name, T passport, T age, T phone, T add){
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

    public NodePassenger<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(NodePassenger<T> nextNode) {
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
                "\nAdress: " + this.address +"\n";
    }
    
}
