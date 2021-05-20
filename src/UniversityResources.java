import java.util.ArrayList;

public class UniversityResources{
	private static ArrayList<Assistant> assistants = new ArrayList<>();
	private static ArrayList<Room> rooms = new ArrayList<>();
	
	public static ArrayList<Assistant> getAssistants(){
		return assistants;
	}
	
	public static void addAssistant(String name, String email){
		Assistant assistant = new Assistant(name, email);
		assistants.add(assistant);
	}
	
	public static void printAssistants() {
		for (int i =0; i<assistants.size(); i++){
			Assistant x = assistants.get(i);
			x.printAssistant();
		}
	}
	public static void printAssistantList() {
		for (int i =0; i<assistants.size(); i++){
			Assistant x = assistants.get(i);
			System.out.print((i+11) +": " + x.getPrintTemplate()+"\n");
		}
	}
	
	
	public static void addRoom(String code, int capacity){
		Room room = new Room(code, capacity);
		rooms.add(room);
	}
	
	public static void printRooms(){
		for (int i=0; i<rooms.size(); i++){
			Room x = rooms.get(i);
			x.printRoom();
		}
	}
	public static void printRoomsList(){
		for (int i =0; i<rooms.size(); i++){
			Room x = rooms.get(i);
			System.out.print((i+11) +": " + x.getPrintTemplate()+"\n");
		}
	}
	
	public static ArrayList<Room> getRooms(){
		return rooms;
	}
}

	//public static isValidRoom()