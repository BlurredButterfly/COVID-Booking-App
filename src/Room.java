public class Room {
	//Attributes
	private String code;
	private int capacity;
	
	public Room (String code, int capacity){
		this.code = code;
		this.capacity = capacity;
	}
	
	public String getCode(){
		return this.code;
	}
	
	public int getCapacity(){
		return this.capacity;
	}
	
	public void printRoom() {
		System.out.println("| " + this.code + " | capacity:" + this.capacity + " |");
	}
	
	public String getPrintTemplate(){
		String printTemplate = "| " + this.code + " | capacity:" + this.capacity + " |";
		return printTemplate;
	}
}