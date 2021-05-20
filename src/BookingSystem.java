import java.util.ArrayList;

public class BookingSystem{
	private static ArrayList<BookableRoom> bookableRooms = new ArrayList<>();
	private static ArrayList<AssistantOnShift> assistantsOnShift = new ArrayList<>();
	private static ArrayList<Booking> bookings = new ArrayList<>();
	private static BookableRoom lastBookableRoomDeleted;
	private static AssistantOnShift lastAssistantOnShiftDeleted;
	private static Booking lastBookingDeleted;

	
	public static void addBookableRoom(String roomID, String date, String time){
		ArrayList<Room> rooms = UniversityResources.getRooms();
		Room room = null;
		for (int i=0; i< rooms.size(); i++){
			Room x = rooms.get(i);
			if (x.getCode() == roomID){
				room = x;
			}
		}
		BookableRoom bookableRoom = new BookableRoom(room, date, time);
		bookableRooms.add(bookableRoom);
	}
	
	public static void addBookableRoom(String[] input)throws IndexOutOfBoundsException, NumberFormatException, ArithmeticException{
		if (input.length != 3){
			throw new ArithmeticException("error");
		}
		String code = (input[0]);
		String date = (input[1]);
		String time = (input[2]);
		ArrayList<Room> rooms = UniversityResources.getRooms();
		Room room = rooms.get(Integer.parseInt(code) -11);
		BookableRoom bookableRoom = new BookableRoom(room, date, time);
		bookableRooms.add(bookableRoom);
	}
	
	public static void removeBookableRoom(String code) throws IndexOutOfBoundsException, NumberFormatException{
		ArrayList<BookableRoom> listOfEmptyBookableRooms = getEmptyBookableRooms();
		int codeNumber = Integer.parseInt(code);
		BookableRoom emptyBookableRoom = listOfEmptyBookableRooms.get(codeNumber - 11);
		for (int i =0; i<bookableRooms.size(); i++){
			BookableRoom x = bookableRooms.get(i);
			if (x == emptyBookableRoom){
				bookableRooms.remove(x);
				lastBookableRoomDeleted = x;
				break;
			}
		}
	}
	
	public static ArrayList<BookableRoom> getBookableRooms(){
		return bookableRooms;
	}
	
	public static ArrayList<BookableRoom> getEmptyBookableRooms(){
		ArrayList<BookableRoom> emptyBookableRooms = new ArrayList<>();
		for (int i=0; i<bookableRooms.size(); i++){
			BookableRoom x = bookableRooms.get(i);
			if (x.getStatus() == BookableRoomStatus.EMPTY){
				emptyBookableRooms.add(x);
			}
		}
		return emptyBookableRooms;
	}
	
	public static ArrayList<BookableRoom> getAvailableBookableRooms(){
		ArrayList<BookableRoom> emptyBookableRooms = new ArrayList<>();
		for (int i=0; i<bookableRooms.size(); i++){
			BookableRoom x = bookableRooms.get(i);
			if (x.getStatus() == BookableRoomStatus.EMPTY || x.getStatus() == BookableRoomStatus.AVAILABLE){
				emptyBookableRooms.add(x);
			}
		}
		return emptyBookableRooms;
	}
	
	public static void printBookableRooms(){
		for (int i=0; i<bookableRooms.size(); i++){
			BookableRoom x = bookableRooms.get(i);
			x.printBookableRoom();
		}
	}	
	
	public static void printEmptyBookableRooms(){
		ArrayList<BookableRoom> listOfEmptyBookableRooms = getEmptyBookableRooms();
		for (int i=0; i<listOfEmptyBookableRooms.size(); i++){
			BookableRoom x = listOfEmptyBookableRooms.get(i);
			String element = x.getPrintTemplate();
			System.out.println((i+11) + ". " + element);
		}
	}

	public static void addAssistantOnShift(String[] input) throws IndexOutOfBoundsException, NumberFormatException, ArithmeticException{
		if (input.length != 2){
			throw new ArithmeticException("error");
		}
		int code = Integer.parseInt(input[0]);
		ArrayList<Assistant> assistants = UniversityResources.getAssistants();
		Assistant assistant = assistants.get(code -11);
		String date = input[1];
		for (int i=0; i<3; i++){
			int hour = i+7;
			String time = "0" + Integer.toString(hour) +":00";
			AssistantOnShift assistantOnShift = new AssistantOnShift(assistant, date, time);
			assistantsOnShift.add(assistantOnShift);
		}
	}
	
	public static void addAssistantOnShift(String name, String date){
		ArrayList<Assistant> assistants = UniversityResources.getAssistants();
		for (int i=0; i<assistants.size(); i++){
			Assistant assistant = assistants.get(i);
			String assistantName = assistant.getName();
			if (assistantName.equals(name)){
				for (int j=0; j<3; j++){
					int hour = j+7;
					String time = "0" + Integer.toString(hour) +":00";
					AssistantOnShift assistantOnShift = new AssistantOnShift(assistant, date, time);
					assistantsOnShift.add(assistantOnShift);
				}
				break;
			}
		}
	}

	public static void printAssistantsOnShift(){
		for (int i=0; i<assistantsOnShift.size(); i++){
			AssistantOnShift x = assistantsOnShift.get(i);
			x.printAssistantOnShift();
		}
	}
	
	public static void printLastBookableRoomDeleted(){
		lastBookableRoomDeleted.printBookableRoom();
	}
	
	public static void printLastAssistantOnShiftDeleted(){
		lastAssistantOnShiftDeleted.printAssistantOnShift();
	}

	public static void printLastBookingDeleted(){
		System.out.println(lastBookableRoomDeleted.getPrintTemplate());
	}

	public static ArrayList<AssistantOnShift> getAssistantsOnShift(){
		return assistantsOnShift;
	}
	
	public static ArrayList<AssistantOnShift> getFreeAssistantsOnShift(){
		ArrayList<AssistantOnShift> freeAssistantsOnShift = new ArrayList<>();
		for (int i=0; i<assistantsOnShift.size(); i++){
			AssistantOnShift x = assistantsOnShift.get(i);
			if (x.getStatus() == AssistantOnShiftStatus.FREE){
				freeAssistantsOnShift.add(x);
			}
		}
		return freeAssistantsOnShift;
	}
	
	public static void printFreeAssistantsOnShift(){
		ArrayList<AssistantOnShift> listOfFreeAssistantsOnShift = getFreeAssistantsOnShift();
		for (int i=0; i<listOfFreeAssistantsOnShift.size(); i++){
			AssistantOnShift x = listOfFreeAssistantsOnShift.get(i);
			String element = x.getPrintTemplate();
			System.out.println((i+11) + ". " + element + "\n");
		}
	}
		
	public static void removeAssistantOnShift(String code) throws IndexOutOfBoundsException, NumberFormatException{
		ArrayList<AssistantOnShift> listOfFreeAssistantsOnShift = getFreeAssistantsOnShift();
		int codeNumber = Integer.parseInt(code);
		AssistantOnShift freeAssistantOnShift = listOfFreeAssistantsOnShift.get(codeNumber - 11);
		for (int i =0; i<assistantsOnShift.size(); i++){
			AssistantOnShift x = assistantsOnShift.get(i);
			if (x == freeAssistantOnShift){
				assistantsOnShift.remove(x);
				lastAssistantOnShiftDeleted = x;
				break;
			}
		}
	}
	
	public static void printAvailableTimeSlots(){
		ArrayList<String> availableTimeSlots = getAvailableTimeSlots();
		for (int i=0; i<availableTimeSlots.size(); i++){
			String timeSlot = availableTimeSlots.get(i);
			System.out.print((i+11)+". " + timeSlot +"\n");
		}
	}
	
	public static ArrayList<String> getAvailableTimeSlots(){
		ArrayList<String> availableTimeSlots = new ArrayList<>();
		ArrayList<BookableRoom> availableBookableRooms = getAvailableBookableRooms();
		ArrayList<AssistantOnShift> freeAssistantsOnShift = getFreeAssistantsOnShift();
		for (int i=0; i<availableBookableRooms.size(); i++){
			BookableRoom bookableRoom = availableBookableRooms.get(i);
			String timeSlot = bookableRoom.getTimeSlot();
			if (!availableTimeSlots.contains(timeSlot)){
				for (int j=0; j<freeAssistantsOnShift.size(); j++){
					AssistantOnShift assistantOnShift = freeAssistantsOnShift.get(j);
					String optimisedBookableRoomTimeslot = bookableRoom.getOptimisedTimeSlot();
					if (optimisedBookableRoomTimeslot.equals(assistantOnShift.getTimeSlot())){
						availableTimeSlots.add(timeSlot);
					}
				}
			}
		}
		return availableTimeSlots;
	}
	
	public static void addBooking(String[] input) throws IndexOutOfBoundsException, NumberFormatException, ArithmeticException{
		if (input.length != 2)
			throw new ArithmeticException("error");
		int code = Integer.parseInt(input[0]);
		ArrayList<String> availableTimeSlots = getAvailableTimeSlots();
		ArrayList<BookableRoom> availableBookableRooms = getAvailableBookableRooms();
		ArrayList<AssistantOnShift> freeAssistantsOnShift = getFreeAssistantsOnShift();
		String studentEmail = input[1];
		String timeSlot = availableTimeSlots.get(code -11);
		BookableRoom bookableRoom = null;
		AssistantOnShift assistantOnShift = null;
		for (int i=0; i< availableBookableRooms.size();i++){
			BookableRoom x = availableBookableRooms.get(i);
			if (timeSlot.equals(x.getTimeSlot())){
				bookableRoom = x;
				for (int j=0; j<freeAssistantsOnShift.size(); j++){
					AssistantOnShift y = freeAssistantsOnShift.get(j);
					if ((bookableRoom.getOptimisedTimeSlot()).equals(y.getTimeSlot())){
						assistantOnShift = y;
						break;
					}
				}
				break;
			}
		}
		Booking booking = new Booking(timeSlot, studentEmail, assistantOnShift, bookableRoom);
		bookings.add(booking);
	}
	
	public static void addBooking(String timeSlot, String studentEmail) {
		ArrayList<String> availableTimeSlots = getAvailableTimeSlots();
		ArrayList<BookableRoom> availableBookableRooms = getAvailableBookableRooms();
		ArrayList<AssistantOnShift> freeAssistantsOnShift = getFreeAssistantsOnShift();
		BookableRoom bookableRoom = null;
		AssistantOnShift assistantOnShift= null;
		for (int i=0; i< availableBookableRooms.size();i++){
			BookableRoom x = availableBookableRooms.get(i);
			if (timeSlot.equals(x.getTimeSlot())){
				bookableRoom = x;
				for (int j=0; j<freeAssistantsOnShift.size(); j++){
					AssistantOnShift y = freeAssistantsOnShift.get(j);
					if ((bookableRoom.getOptimisedTimeSlot()).equals(y.getTimeSlot())){
						assistantOnShift = y;
						break;
					}
				}
				break;
			}
		}
		Booking booking = new Booking(timeSlot, studentEmail, assistantOnShift, bookableRoom);
		bookings.add(booking);
	}
	
	public static void printBookings(){
		for (int i=0; i< bookings.size(); i++){
			Booking x = bookings.get(i);
			System.out.println((i+11) + ". "+x.getPrintTemplate()+"\n");
		}
	}
	
	public static ArrayList<Booking> getBookings(){
		return bookings;
	}

	public static ArrayList<Booking> getScheduledBookings(){
		ArrayList<Booking> scheduledBookings = new ArrayList<>();
		for (int i=0; i< bookings.size(); i++){
			Booking x = bookings.get(i);
			if (x.getStatus() == BookingStatus.SCHEDULED){
				scheduledBookings.add(x);
			}
		}
		return scheduledBookings;
	}
	
	public static void printScheduledBookings(){
		ArrayList<Booking> scheduledBookings = getScheduledBookings();
		for (int i=0; i< scheduledBookings.size(); i++){
			Booking x = scheduledBookings.get(i);
			System.out.println((i+11) + ". " + x.getPrintTemplate()+"\n");
		}
	}
	public static ArrayList<Booking> getCompletedBookings(){
		ArrayList<Booking> completedBookings = new ArrayList<>();
		for (int i=0; i< bookings.size(); i++){
			Booking x = bookings.get(i);
			if (x.getStatus() == BookingStatus.COMPLETED){
				completedBookings.add(x);
			}
		}
		return completedBookings;
	}
	
	public static void printCompletedBookings(){
		ArrayList<Booking> completedBookings = getCompletedBookings();
		for (int i=0; i< completedBookings.size(); i++){
			Booking x = completedBookings.get(i);
			System.out.println((i+11) + ". " + x.getPrintTemplate()+"\n");
		}
	}
	
	public static void removeBooking(String code) throws IndexOutOfBoundsException, NumberFormatException{
		ArrayList<Booking> listOfScheduledBookings = getScheduledBookings();
		int codeNumber = Integer.parseInt(code);
		Booking scheduledBooking = listOfScheduledBookings.get(codeNumber - 11);
		for (int i =0; i<bookings.size(); i++){
			Booking x = bookings.get(i);
			if (x == scheduledBooking){
				x.freeAttributes();
				bookings.remove(x);
				lastBookingDeleted = x;
				break;
			}
		}
	}
	
	public static void concludeBooking(String code) throws IndexOutOfBoundsException, NumberFormatException{
		ArrayList<Booking> listOfScheduledBookings = getScheduledBookings();
		int codeNumber = Integer.parseInt(code);
		Booking scheduledBooking = listOfScheduledBookings.get(codeNumber - 11);
		for (int i =0; i<bookings.size(); i++){
			Booking x = bookings.get(i);
			if (x == scheduledBooking){
				x.concludeBooking();
				x.freeAttributes();
				break;	
			}
		}
	}
}
		