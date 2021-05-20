enum BookingStatus{
SCHEDULED, COMPLETED
}

public class Booking{
	private AssistantOnShift assistantOnShift;
	private BookableRoom bookableRoom;
	private BookingStatus status;
	private String timeSlot;
	private String studentEmail;
	
	public Booking(String timeSlot, String studentEmail, AssistantOnShift assistantOnShift, BookableRoom bookableRoom){
		this.timeSlot = timeSlot;
		this.assistantOnShift = assistantOnShift;
		this.bookableRoom = bookableRoom;
		this.status = BookingStatus.SCHEDULED;
		this.studentEmail = studentEmail;
		this.assistantOnShift.addBooking();
		this.bookableRoom.addBooking();
	}
	
	public void freeAttributes(){
		this.assistantOnShift.removeBooking();
		(this.bookableRoom).removeBooking();
	}
	
	public void concludeBooking(){
		this.status = BookingStatus.COMPLETED;
	}
	
	public String getTimeSlot(){
		return this.timeSlot;
	}
	
	public BookingStatus getStatus(){
		return this.status;
	}
	
	public BookableRoom getBookableRoom(){
		return this.bookableRoom;
	}
	
	public AssistantOnShift getAssistantOnShift(){
		return this.assistantOnShift;
	}
	
	public String getPrintTemplate(){
		Assistant assistant = this.assistantOnShift.getAssistant();
		String assistantEmail = assistant.getEmail();
		Room room = (this.bookableRoom).getRoom();
		String roomCode = room.getCode();
		String printTemplate = "| "+this.timeSlot+" | "+this.status+" | "+ assistantEmail +" | "+roomCode+" | "+this.studentEmail+" |";
		return printTemplate;
	}
}