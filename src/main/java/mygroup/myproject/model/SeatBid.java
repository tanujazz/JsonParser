package mygroup.myproject.model;

public class SeatBid {
	
	private Bid bid;
	private String seat;
	
	public SeatBid() {
		
	}
	public SeatBid(Bid bid, String seat) {
		super();
		this.bid = bid;
		this.seat = seat;
	}

	public Bid getBid() {
		return bid;
	}
	public void setBid(Bid bid) {
		this.bid = bid;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	

}
