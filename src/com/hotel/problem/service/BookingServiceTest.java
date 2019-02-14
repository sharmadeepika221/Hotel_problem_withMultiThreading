package com.hotel.problem.service;

import java.util.Date;
import com.hotel.problem.models.Guest;

/**
 * Created by deepika sharma on 29/05/18.
 */
public class BookingServiceTest implements Runnable{
	
	Guest guest;
	int roomid;
	Date date;
	
    public BookingServiceTest(Guest guest,  int roomid, Date date) {
		super();
		this.guest = guest;
		this.roomid = roomid;
		this.date = date;
	}

	public static void main(String[] args) {
        //Guest guest = new Guest("deepika" , "sharma");

        //System.out.println(guest);

        //Guest guest1 = new Guest("deepika1" , "sharma1");
        //System.out.println(guest1);
        //Date date = new Date();
        
        
        BookingServiceTest bst1 = new BookingServiceTest(new Guest("deepika", "Sharma"), BookingManager.rooms[0], new Date());
        BookingServiceTest bst2 = new BookingServiceTest(new Guest("deepika1", "Sharma1"), BookingManager.rooms[0], new Date());
        
        Thread t1 = new Thread(bst1);
        Thread t2 = new Thread(bst2);
        
        t1.start();
        t2.start();
        
        //Room room = new Room(BookingManager.rooms[0], RoomStatus.AVAILABLE);
        //System.out.println(bookingManager.isRoomAvailable(101, date));
        
        //Booking booking = bookingManager.addBooking(guest, room.getNumber(), date);

        //Booking booking1 = bookingManager.addBooking(guest1, room.getNumber(), date);

        ////System.out.println(booking1);
        //System.out.println(bookingManager.isRoomAvailable(101, date));

        //System.out.println(booking);

        /*Iterable<Integer> availableRooms = bookingManager.getAllAvailableRooms(date);
        
        for(Integer r : availableRooms) {
        	System.out.println(r);
        }*/

    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		BookingManager bookingManager = new BookingManager();
		System.out.println(this.guest+ " "+ this.roomid  +" "+this.date);
		bookingManager.addBooking(this.guest, this.roomid, this.date);
		Iterable<Integer> availableRooms = bookingManager.getAllAvailableRooms(date);
        
        for(Integer r : availableRooms) {
        	System.out.println(r);
        }
		
		
		
	}
}
