package com.hotel.problem.service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.hotel.problem.models.Room;
import com.hotel.problem.models.Booking;
import com.hotel.problem.models.Guest;
import com.hotel.problem.models.RoomStatus;

/**
 * Created by deepika sharma on 29/05/18.
 */
public class BookingManager {


    public static List<Booking> bookings = new ArrayList<>();
    public static int[] rooms = generateRandomRoomNumbers(5);
    
    public Map<Integer,Map<Date, Booking>> hotelDateBookingMap = new ConcurrentHashMap<>();

    public boolean isRoomAvailable(Integer roomId, Date date) {

        Map<Date, Booking> dateBookingMap = hotelDateBookingMap.get(roomId.intValue());
        Booking booking;
        if(dateBookingMap != null) {
            booking = dateBookingMap.get(date);
            if(booking != null && booking.getRoom().getStatus()==RoomStatus.BOOKED) {
                return false;
            }
        }

        return true;

    }

    public Booking addBooking(Guest guest, Integer roomId, Date date) {
    	if(isRoomAvailable(roomId, date)) {
    		Map<Date, Booking> dateBookingMap = hotelDateBookingMap.get(roomId);
    		if(dateBookingMap == null) {
    			return getLockAndBook(guest, roomId, date);
    		} else if(dateBookingMap.get(date) !=null) {
    			Booking booking = dateBookingMap.get(date);
    			if(booking.getRoom().getStatus() != RoomStatus.BLOCKED) {
    				return getLockAndBook(guest, roomId, date);
            } else {
                return null;
            }
        }else {
            return getLockAndBook(guest, roomId.intValue(), date);
        }
    }
    	else {
    		return null;
    	}
    	

    }

    private synchronized Booking getLockAndBook(Guest guest, Integer room, Date date) {
        Map<Date, Booking> dateBookingMap = hotelDateBookingMap.get(room);
        if(dateBookingMap == null) {
            dateBookingMap = new ConcurrentHashMap<>();
            Booking booking = new Booking(guest.getLastName(), new Room(room.intValue(),RoomStatus.BOOKED), date);
            dateBookingMap.put(date, booking);
            hotelDateBookingMap.put(room, dateBookingMap);
            return booking;
        } else if(dateBookingMap.get(date) != null) {
            Booking booking = dateBookingMap.get(date);
            if(booking.getRoom().getStatus() == RoomStatus.CANCELLED) {
                booking = new Booking(guest.getLastName(), new Room(room.intValue(),RoomStatus.BOOKED), date);
                dateBookingMap.put(date, booking);
                hotelDateBookingMap.put(room, dateBookingMap);
                return booking;
            } else {
                return null;
            }
        }else {
            Booking booking = new Booking(guest.getLastName(), new Room(room.intValue(),RoomStatus.BOOKED), date);
            dateBookingMap.put(date, booking);
            hotelDateBookingMap.put(room, dateBookingMap);
            return booking;
        }
    }
    
    public Iterable<Integer> getAllAvailableRooms(Date date){
    	List<Integer> availableRooms = new ArrayList<Integer>();
    	if(rooms != null && rooms.length!=0) {
    		for(int j=0; j<rooms.length; j++) {
    			if(isRoomAvailable(rooms[j], date)) {
    				availableRooms.add(rooms[j]);
    			}
    		}
    	}
    	return availableRooms;
    }
    
    public static int[] generateRandomRoomNumbers(int n) {
    	Random r = new Random();
    	int [] roomNumbers = new int[n];
    	int Low = 100;
    	int High = 200;
    	for(int i =0; i<n; i++) {
    		roomNumbers[i]=r.nextInt(High-Low) + Low;
    	}
    	return roomNumbers;
     }
}
