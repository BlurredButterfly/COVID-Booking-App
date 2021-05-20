import java.util.ArrayList;

enum BookableRoomStatus {
EMPTY, AVAILABLE, FULL
}

public class BookableRoom {
	private Room room;
	private BookableRoomStatus status;
	private String date;
	private String time;
	private String timeSlot;
	private int occupancy;
	private int capacity;
	
	public BookableRoom(Room room, String date, String time){
		this.room = room;
		this.capacity = (this.room).getCapacity();
		this.occupancy = 0;
		this.status = BookableRoomStatus.EMPTY;
		this.date = date;
		this.time = time;
		this.timeSlot = date + " " + time;
	}

	public Room getRoom(){
		return this.room;
	}
	
	public BookableRoomStatus getStatus(){
		return this.status;
	}
	
	public String getDate(){
		return this.date;
	}
	
	public String getTime(){
		return this.time;
	}
	
	public String getTimeSlot(){
		return this.timeSlot;
	}
	
	public int occupancy(){
		return this.occupancy;
	}
	
	public void printBookableRoom(){
		System.out.println("| "+this.timeSlot+" | "+this.status+" | "+(this.room).getCode()+" | occupancy: "+this.occupancy+" |");
	}
	
	public String getPrintTemplate(){
		String stringOccupancy = Integer.toString(this.occupancy);
		String printTemplate = ("| "+this.timeSlot+" | "+this.status+" | "+(this.room).getCode()+" | occupancy: "+stringOccupancy+" |");
		return printTemplate;
	}
	
	public void addBooking(){
		this.occupancy += 1;
		if (this.occupancy == capacity){
			this.status = BookableRoomStatus.FULL;
		}else if (this.occupancy >0 && this.occupancy < capacity){
			this.status = BookableRoomStatus.AVAILABLE;
		}
	}

	public void removeBooking(){
		this.occupancy -= 1;
		if (this.occupancy == 0){
			this.status = BookableRoomStatus.EMPTY;
		}else if (this.occupancy >0){
			this.status = BookableRoomStatus.AVAILABLE;
		}
	}

	public String getOptimisedTimeSlot(){
		String[] timeArray = (this.time).split(":");
		String fullHour = timeArray[0];
		String[] fullHourArray = fullHour.split("");
		int hour = Integer.parseInt(fullHourArray[1]);
		if (!timeArray[1].equals("00")){
			hour +=1;
		}
		String optimisedHour = fullHourArray[0] + fullHourArray[1] + timeArray[1];
		String optimisedTimeSlot = this.date + " " + optimisedHour;
		return optimisedTimeSlot;
	}
}
	
	