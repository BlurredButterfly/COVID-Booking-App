enum AssistantOnShiftStatus {
FREE, BUSY
}
	

public class AssistantOnShift {
	Assistant assistant;
	String date;
	String time;
	AssistantOnShiftStatus status;
	String timeSlot;
	
	public AssistantOnShift(Assistant assistant, String date, String time){
		this.assistant = assistant;
		this.time = time;
		this.date = date;
		this.timeSlot = date + " " + time;
		this.status = AssistantOnShiftStatus.FREE;
	}
	
	public Assistant getAssistant(){
		return this.assistant;
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
	
	public AssistantOnShiftStatus getStatus(){
		return this.status;
	}
	
	public void printAssistantOnShift(){
		System.out.println("| "+this.timeSlot+" | "+this.status+" | " + this.assistant.getEmail()+" |");
	}
	
	public String getPrintTemplate(){
		String printTemplate = "| "+this.timeSlot+" | "+this.status+" | "+this.assistant.getEmail()+" |";
		return printTemplate;
	}
	
	public void addBooking(){
		this.status = AssistantOnShiftStatus.BUSY;
	}
	
	public void removeBooking(){
		this.status = AssistantOnShiftStatus.FREE;
	}
}