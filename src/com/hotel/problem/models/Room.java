package com.hotel.problem.models;

/**
 * Created by deepika sharma on 29/05/18.
 */

public class Room {

    private int number;
    private RoomStatus status;
    
    public Room(int number, RoomStatus status) {
		super();
		this.number = number;
		this.status = status;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public RoomStatus getStatus() {
		return status;
	}

	public void setStatus(RoomStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Room [number=" + number + ", Status=" + status + "]";
	}
    
	
    
}
