public class NodeFlight<T> {
    T fName;
    T fDate;
    NodeFlight<T> nextNode;
    
    // constructor for class Flight
    public NodeFlight(T fName, T fDate) {
	this.fName = fName;
	this.fDate = fDate;
    }

    public T getfName() {
        return fName;
    }

    public T getfDate() {
        return fDate;
    }

    public NodeFlight<T> getNextNode() {
        return nextNode;
    }
    
    public void setNextNode(NodeFlight<T> nextNode) {
        this.nextNode = nextNode;
    }
    
    @Override
    public String toString(){
        return "\nFlight Destination: " + this.fName + "\nDeparture Date: " + this.fDate;
    }
}
