package mygroup.myproject.model;

import java.util.ArrayList;

public class SeatBidd {
	
	private String id;
	private ArrayList<SeatBid> seatbid;
	
	public SeatBidd() {
		
	}
	public SeatBidd(String id, ArrayList<SeatBid> seatbid) {
		super();
		this.id = id;
		this.seatbid = seatbid;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<SeatBid> getSeatBid() {
		return seatbid;
	}
	public void setSeatBid(ArrayList<SeatBid> seatbid) {
		this.seatbid = seatbid;
	}
	
	

}
