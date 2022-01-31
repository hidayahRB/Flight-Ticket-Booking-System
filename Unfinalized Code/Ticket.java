/**
 *
 * @author hanif
 */
public class Ticket {
        public int id;
        public String name;
	public String Date;
        public float price;
        public int seatNumber;
	
	public Ticket(int id, String name, String Date, float price, int seatNumber) {
		super();
		this.id = id;
                this.name = name;
		this.Date = Date;
                this.price = price;
                this.seatNumber = seatNumber;
	}
	
	public int getId(){
            return id;
        }
        public void setId(){
            this.id = id;
        }
        public String getName() {
            return name;
	}
	public void setName(String name) {
            this.name = name;
	}
	public String getDate() {
            return Date;
	}
	public void setfDate(String Date) {
            this.Date = Date;
	}
        public float getPrice() {
            return price;
	}
	public void setPrice(float price) {
            this.price = price;
	}
        public int getSeatNumber() {
            return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
            this.seatNumber = seatNumber;
	}
	
	@Override
	public String toString() {
		return "Ticket [Id=" + id + ", Name=" + name + ", Date=" + Date +  ", Price=" + price +  ", SeatNumber=" + seatNumber + "]";
	}
	
	
}
