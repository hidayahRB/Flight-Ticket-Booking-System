package flight.system;

/**
 *
 * @author hanif
 */
public class Flight {
     public String fName;
	public String fDate;
	
	public Flight(String fName, String fDate) {
		super();
		this.fName = fName;
		this.fDate = fDate;
	}
	
        public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfDate() {
		return fDate;
	}
	public void setfDate(String fDate) {
		this.fDate = fDate;
	}
	
	@Override
	public String toString() {
		return "Flight [fName=" + fName + ", fDate=" + fDate + "]";
	}
    
}
