package com.hotel.problem.models;



import java.util.Date;


/**
 * Created by deepika sharma on 29/05/18.
 */

public class Booking {

    private int id;

    private String guestLastName;

    private Room room;

    private Date date;

    public Booking(String guestLastName, Room room, Date date) {
        this.setGuestLastName(guestLastName);
        this.room = room;
        this.date = date;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", guestLastName=" + guestLastName +
                ", room=" + room +
                ", date=" + date +
  '}';
    }

	public String getGuestLastName() {
		return guestLastName;
	}

	public void setGuestLastName(String guestLastName) {
		this.guestLastName = guestLastName;
	}
}
