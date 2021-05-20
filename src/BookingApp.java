import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.*;
import java.lang.*;
import java.io.IOException;

public class BookingApp {
	
	private static final Logger LOGGER = Logger.getLogger(BookingApp.class.getName());
	public static void main (String[] args){
		FileHandler fileHandler = null;
		try{
			fileHandler = new FileHandler("systemLog.log");
			LOGGER.addHandler(fileHandler);
			fileHandler.setLevel(Level.ALL);
			LOGGER.setLevel(Level.ALL);
		}catch(IOException e){
			LOGGER.log(Level.SEVERE, "Error setting up file handler", e);
		}
		UniversityResources.addAssistant("Jack", "Jack@uok.ac.uk"); 
		UniversityResources.addAssistant("Sonia", "Sonia@uok.ac.uk"); 
		UniversityResources.addAssistant("Emma", "Emma@uok.ac.uk"); 
		UniversityResources.addRoom("IC215", 2);
		UniversityResources.addRoom("PT101", 5);
		UniversityResources.addRoom("ER404", 1);
		BookingSystem.addBookableRoom("IC215", "20/8/2020", "07:00");
		BookingSystem.addBookableRoom("IC215", "20/8/2020", "08:00");
		BookingSystem.addBookableRoom("IC215", "20/8/2020", "09:00");
		BookingSystem.addBookableRoom("PT101", "20/8/2020", "07:00");
		BookingSystem.addBookableRoom("PT101", "20/8/2020", "08:00");
		BookingSystem.addBookableRoom("PT101", "20/8/2020", "09:00");
		BookingSystem.addBookableRoom("ER404", "20/8/2020", "07:00");
		BookingSystem.addBookableRoom("ER404", "20/8/2020", "08:00");
		BookingSystem.addBookableRoom("ER404", "20/8/2020", "09:00");
		BookingSystem.addAssistantOnShift("Jack","20/8/2020");
		BookingSystem.addAssistantOnShift("Sonia","20/8/2020");
		mainMenuScreen();
	}
	/** @param prints Main Menu and controls user input*/
	public static void mainMenuScreen() {
		//Prints MainMenu
		clearConsole();
		System.out.println("University of Knowledge - COVID test");
		System.out.println("\n");
		System.out.println("Manage Bookings");
		System.out.println("\n");
		System.out.println("Please, enter the number to select your option:");
		System.out.println("To manage Bookable Rooms:");
		System.out.println("\t 1. List");
		System.out.println("\t 2. Add");
		System.out.println("\t 3. Remove");
		System.out.println("To manage Assistants on Shift");
		System.out.println("\t 4. List");
		System.out.println("\t 5. Add");
		System.out.println("\t 6. Remove");
		System.out.println("To manage Bookings:");
		System.out.println("\t 7. List");
		System.out.println("\t 8. Add");
		System.out.println("\t 9. Remove");
		System.out.println("\t 10. Conclude");
		System.out.println("After selecting one the options above, you will be presented other screens.");
		System.out.println("If you press 0, you will be able to return to this main menu.");
		System.out.println("Press -1 (or ctrl+c) to quit this application.");
		System.out.println("\n");
		//Checks for a valid user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				LOGGER.log(Level.FINE, "Program terminating");
				System.exit(0);
				break;
			case "0":
				LOGGER.log(Level.FINE, "Screen changing to mainMenuScreen");
				mainMenuScreen();
				break;
			case "1":
				LOGGER.log(Level.FINE, "Screen changing to listBookableRoomsScreen");
				listBookableRoomsScreen();
				break;
			case "2":
				LOGGER.log(Level.FINE, "Screen changing to addBookableRoomsScreen");
				addBookableRoomsScreen();
				break;
			case "3":
				LOGGER.log(Level.FINE, "Screen changing to removeBookableRoomsScreen");
				removeBookableRoomsScreen();
				break;
			case "4":
				LOGGER.log(Level.FINE, "Screen changing to listAssistantOnShiftScreen");
				listAssistantOnShiftScreen();
				break;
			case "5":
				LOGGER.log(Level.FINE, "Screen changing to addAssistantOnShiftScreen");
				addAssistantOnShiftScreen();
				break;
			case "6":
				LOGGER.log(Level.FINE, "Screen changing to removeAssistantOnShiftScreen");
				removeAssistantOnShiftScreen();
				break;
			case "7": 
				LOGGER.log(Level.FINE, "Screen changing to listBookingsScreen");
				listBookingsScreen();
				break;
			case "8":
				LOGGER.log(Level.FINE, "Screen changing to addBookingScreen");
				addBookingScreen();
				break;
			case "9":
				LOGGER.log(Level.FINE, "Screen changing to removeBookingScreen");
				removeBookingScreen();
				break;
			case "10":
				LOGGER.log(Level.FINE, "Screen changing to concludeBookingScreen");
				concludeBookingScreen();
				break;
			default:
				LOGGER.log(Level.INFO, "Invalid input, screen changing to mainMenuScreen");
				mainMenuScreen();
				break;
		}
	}
	
	/** @param prints the listBookableRooms screen and lists all bookable rooms*/
	public static void listBookableRoomsScreen() {
		clearConsole();
		//print ListBookableRooms
		System.out.println("University of Knowledge - COVID test");
		System.out.println("\n");
		LOGGER.log(Level.FINE, "printing Bookable rooms");
		BookingSystem.printBookableRooms();
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//check user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				LOGGER.log(Level.FINE, "Program terminating");
				System.exit(0);
				break;
			case "0":
				LOGGER.log(Level.FINE, "Screen changing to mainMenuScreen");
				mainMenuScreen();
				break;
			default:
				LOGGER.log(Level.INFO, "Invalid input, screen changing to listBookableRoomsScreen");
				listBookableRoomsScreen();
				break;
		}
	}
	
	/** @param prints the addBookableRooms screen and adds a bookable,
	room based on user input*/
	public static void addBookableRoomsScreen() {
		clearConsole();
		//print addBookableRooms screen
		System.out.println("University of Knowledge - COVID test");
		System.out.println("\n");
		System.out.println("Adding bookable room");
		System.out.println("\n");
		LOGGER.log(Level.FINE, "Printing list of rooms");
		UniversityResources.printRoomsList();
		System.out.println("Please, enter one of the following:");
		System.out.println("\n");
		System.out.println("The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM),");
		System.out.println("separated by a white space.");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//checks and executes user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				LOGGER.log(Level.FINE, "Program terminating");
				System.exit(0);
				break;
			case "0":
				LOGGER.log(Level.FINE, "Screen changing to mainMenuScreen");
				mainMenuScreen();
				break;
			default:
				String[] arrayInput = input.split(" ");
				try {
					BookingSystem.addBookableRoom(arrayInput);
					LOGGER.log(Level.FINE, "Screen changing to bookableRoomAddedSuccessfully");
					bookableRoomAddedSuccessfully();
				}catch (IndexOutOfBoundsException ex){
					LOGGER.log(Level.WARNING, "Error: indexOutOfBoundsException, room does not exist", ex);
					LOGGER.log(Level.FINE, "Screen changing to bookableRoomAddedError");
					bookableRoomAddedError();
				}catch (NumberFormatException ex){
					LOGGER.log(Level.WARNING, "Error: NumberFormatException, first argument is not a number", ex);
					LOGGER.log(Level.FINE, "Screen changing to bookableRoomAddedError");
					bookableRoomRemovedError();
				}catch (ArithmeticException ex){
					LOGGER.log(Level.WARNING, "Error: ArithmeticException, wrong number of input arguments", ex);
					LOGGER.log(Level.FINE, "Screen changing to bookableRoomAddedError");
					bookableRoomAddedError();
				}
		}
	}
	
	/** @param prints the bookableRoomAddedSuccessfully screen and adds a bookable,
	room based on user input*/
	public static void bookableRoomAddedSuccessfully() {
		clearConsole();
		//print bookableRoomAddedSuccessfully screen
		System.out.println("Bookable Room added successfully:");
		ArrayList<BookableRoom> bookableRooms = BookingSystem.getBookableRooms();
		int value = bookableRooms.size() -1;
		BookableRoom bookableRoom = bookableRooms.get(value);
		bookableRoom.printBookableRoom();
		System.out.println("Please, enter one of the following:");
		System.out.println("\n");
		System.out.println("The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM),");
		System.out.println("separated by a white space.");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//checks and executes user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				String[] arrayInput = input.split(" ");
				try {
					BookingSystem.addBookableRoom(arrayInput);
					bookableRoomAddedSuccessfully();
				}catch (IndexOutOfBoundsException ex){
					bookableRoomAddedError();
				}catch (NumberFormatException ex){
					bookableRoomRemovedError();
				}catch (ArithmeticException ex){
					bookableRoomAddedError();
				}
		}
	}
			
	/** @param prints the bookableRoomAddedError screen and adds a bookable,
	room based on user input*/
	public static void bookableRoomAddedError() {
		clearConsole();
		//print bookableRoomAddedError screen
		System.out.println("Error! \n Invalid input \n Please enter a valid input");
		System.out.println("\n");
		System.out.println("Please, enter one of the following:");
		System.out.println("\n");
		System.out.println("The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM),");
		System.out.println("separated by a white space.");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//checks and executes user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				String[] arrayInput = input.split(" ");
				try {
					BookingSystem.addBookableRoom(arrayInput);
					bookableRoomAddedSuccessfully();
				}catch (IndexOutOfBoundsException ex){
					bookableRoomAddedError();
				}catch (NumberFormatException ex){
					bookableRoomRemovedError();
				}catch (ArithmeticException ex){
					bookableRoomAddedError();
				}
		}
	}
		
	/** @param prints the removeBookableRooms screen and removes a bookable,
	room based on user input*/
	public static void removeBookableRoomsScreen() {
		clearConsole();
		//<Get list of empty bookable rooms>
		//print removeBookableRooms screen
		System.out.println("University of Knowledge - COVID test");
		System.out.println("\n");
		BookingSystem.printEmptyBookableRooms();
		System.out.println("Removing bookable room");
		System.out.println("\n");
		System.out.println("Please, enter one of the following:");
		System.out.println("\n");
		System.out.println("The sequential ID to select the bookable room to be removed.");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//checks and executes user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				try {
					BookingSystem.removeBookableRoom(input);
					bookableRoomRemovedSuccessfully();
				}catch (IndexOutOfBoundsException ex){
					bookableRoomRemovedError();
				}catch (NumberFormatException ex){
					bookableRoomRemovedError();
				}
		}
	}
	
	/** @param prints the bookableRoomRemovedSuccessfully screen and removes a bookable,
	room based on user input*/
	public static void bookableRoomRemovedSuccessfully() {
		clearConsole();
		//print bookableRoomRemovedSuccessfully screen
		System.out.println("Bookable Room removed successfully:");
		BookingSystem.printLastBookableRoomDeleted();
		System.out.println("Please, enter one of the following:");
		System.out.println("\n");
		System.out.println("The sequential ID to select the bookable room to be removed.");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//checks and executes user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				try {
					BookingSystem.removeBookableRoom(input);
					bookableRoomRemovedSuccessfully();
				}catch (IndexOutOfBoundsException ex){
					bookableRoomRemovedError();
				}catch (NumberFormatException ex){
					bookableRoomRemovedError();
				}
		}
	}
			
	/** @param prints the bookableRoomRemovedError screen and removes a bookable,
	room based on user input*/
	public static void bookableRoomRemovedError() {
		clearConsole();
		//print bookableRoomRemovedError screen
		System.out.println("Error! \n Invalid input \n Please enter a valid input");
		System.out.println("\n");
		System.out.println("Please, enter one of the following:");
		System.out.println("\n");
		System.out.println("The sequential ID to select the bookable room to be removed.");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//checks and executes user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				try {
					BookingSystem.removeBookableRoom(input);
					bookableRoomRemovedSuccessfully();
				}catch (IndexOutOfBoundsException ex){
					bookableRoomRemovedError();
				}catch (NumberFormatException ex){
					bookableRoomRemovedError();
				}
		}
	}
		
	/** @param prints the listAssistantOnShift screen and lists all assistants on shift*/
	public static void listAssistantOnShiftScreen() {
		clearConsole();
		//<Get list of assistants on shift>
		//print listAssistantOnShift screen
		System.out.println("University of Knowledge - COVID test");
		System.out.println("\n");
		BookingSystem.printAssistantsOnShift();
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//check user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				System.out.println("Error! \n Invalid input \n Please enter a valid input");
				listAssistantOnShiftScreen();
				break;
		}
	}
		
	/** @param prints the addAssistantOnShift screen and adds,
	an assistant on shift based on user input*/
	public static void addAssistantOnShiftScreen() {
		clearConsole();
		//<Get list of assistants on shift>
		//print addAssistantOnShift screen
		System.out.println("University of Knowledge - COVID test");
		System.out.println("\n");
		System.out.println("Adding assistant on shift");
		System.out.println("\n");
		UniversityResources.printAssistantList();
		System.out.println("Please, enter one of the following:");
		System.out.println("\n");
		System.out.println("The sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space.");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//checks and executes user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				String[] arrayInput = input.split(" ");
				try {
					BookingSystem.addAssistantOnShift(arrayInput);
					assistantOnShiftAddedSuccessfully();
				}catch (IndexOutOfBoundsException ex){
					assistantOnShiftAddedError();
				}catch (NumberFormatException ex){
					bookableRoomRemovedError();
				}catch (ArithmeticException ex){
					assistantOnShiftAddedError();
				}
		}
	}
	
	/** @param prints the assistantOnShiftAddedSuccessfully screen and adds,
	an assistant on shift based on user input*/
	public static void assistantOnShiftAddedSuccessfully() {
		clearConsole();
		//print assistantOnShiftAddedSuccessfully screen
		System.out.println("Assistant on Shift added successfully:");
		ArrayList<AssistantOnShift> assistantsOnShift = BookingSystem.getAssistantsOnShift();
		int value = assistantsOnShift.size() -1;
		AssistantOnShift assistantOnShift = assistantsOnShift.get(value);
		assistantOnShift.printAssistantOnShift();
		System.out.println("Please, enter one of the following:");
		System.out.println("\n");
		System.out.println("The sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space.");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//checks and executes user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				String[] arrayInput = input.split(" ");
				try {
					BookingSystem.addAssistantOnShift(arrayInput);
					assistantOnShiftAddedSuccessfully();;
				}catch (IndexOutOfBoundsException ex){
					assistantOnShiftAddedError();
				}catch (NumberFormatException ex){
					bookableRoomRemovedError();
				}catch (ArithmeticException ex){
					assistantOnShiftAddedError();
				}
		}
	}
			
	/** @param prints the assistantOnShiftAddedError screen and adds,
	an assistant on shift based on user input*/
	public static void assistantOnShiftAddedError() {
		clearConsole();
		//print assistantOnShiftAddedError screen
		System.out.println("Error! \n Invalid input \n Please enter a valid input");
		System.out.println("\n");
		System.out.println("Please, enter one of the following:");
		System.out.println("\n");
		System.out.println("The sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space.");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//checks and executes user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				String[] arrayInput = input.split(" ");
				try {
					BookingSystem.addAssistantOnShift(arrayInput);
					assistantOnShiftAddedSuccessfully();
				}catch (IndexOutOfBoundsException ex){
					assistantOnShiftAddedError();
				}catch (NumberFormatException ex){
					bookableRoomRemovedError();
				}catch (ArithmeticException ex){
					assistantOnShiftAddedError();
				}
		}
	}
		
	/** @param prints the removeAssistantOnShift screen and removes,
	an assistant on shift based on user input*/
	public static void removeAssistantOnShiftScreen() {
		clearConsole();
		//<Get list of free assistants on shift>
		//print removeAssistantOnShift screen
		System.out.println("University of Knowledge - COVID test");
		System.out.println("\n");
		BookingSystem.printFreeAssistantsOnShift();
		System.out.println("Removing assistant on shift");
		System.out.println("\n");
		System.out.println("Please, enter one of the following:");
		System.out.println("\n");
		System.out.println("The sequential ID to select the assistant on shift to be removed.");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//checks and executes user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				try {
					BookingSystem.removeAssistantOnShift(input);
					assistantOnShiftRemovedSuccessfully();
				}catch (IndexOutOfBoundsException ex){
					assistantOnShiftRemovedError();
				}catch (NumberFormatException ex){
					assistantOnShiftRemovedError();
				}
		}
	}
	
	/** @param prints the assistantOnShiftRemovedSuccessfully screen and removes,
	and assistant on shift based on user input*/
	public static void assistantOnShiftRemovedSuccessfully() {
		clearConsole();
		//print assistantOnShiftRemovedSuccessfully screen
		System.out.println("Assistant on Shift added successfully:");
		BookingSystem.printLastAssistantOnShiftDeleted();
		System.out.println("Please, enter one of the following:");
		System.out.println("\n");
		System.out.println("The sequential ID to select the assistant on shift to be removed.");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//checks and executes user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				try {
					BookingSystem.removeAssistantOnShift(input);
					assistantOnShiftRemovedSuccessfully();
				}catch (IndexOutOfBoundsException ex){
					assistantOnShiftRemovedError();
				}catch (NumberFormatException ex){
					assistantOnShiftRemovedError();
				}
		}
	}
		
	/** @param prints the assistantOnShiftAddedError screen and removes,
	an assistant on shift based on user input*/
	public static void assistantOnShiftRemovedError() {
		clearConsole();
		//print assistantOnShiftAddedError screen
		System.out.println("Error! \n Invalid input \n Please enter a valid input");
		System.out.println("\n");
		System.out.println("Please, enter one of the following:");
		System.out.println("\n");
		System.out.println("The sequential ID to select the assistant on shift to be removed.");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//checks and executes user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				try {
					BookingSystem.removeAssistantOnShift(input);
					assistantOnShiftRemovedSuccessfully();
				}catch (IndexOutOfBoundsException ex){
					assistantOnShiftRemovedError();
				}catch (NumberFormatException ex){
					assistantOnShiftRemovedError();
				}
		}
	}
		
	/** @param prints the listBookings screen and lists bookings based on user input*/
	public static void listBookingsScreen() {
		clearConsole();
		//print listBookings screen
		System.out.println("University of Knowledge - COVID test");
		System.out.println("\n");
		System.out.println("Select which booking to list:");
		System.out.println("1. All");
		System.out.println("2. Only bookings status:SCHEDULED");
		System.out.println("3. Only bookings status:COMPLETED");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//check user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			case "1":
				listAllBookings();
				break;
			case "2":
				listScheduledBookings();
				break;
			case "3":
				listCompletedBookings();
				break;
			default:
				System.out.println("Error! \n Invalid input \n All bookings shown by default \n");
				listAllBookings();
				break;
		}
	}
	
	/** @param prints the listAllBookings screen and lists all bookings*/
	public static void listAllBookings() {
		clearConsole();
		//prints listAllBookings screen
		//<Get list of all bookings>
		BookingSystem.printBookings();
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				System.out.println("Error! \n Invalid input \n Please enter a valid input");
				listAllBookings();
				break;
		}
	}
		
	/** @param prints the listScheduledBookings screen and lists all scheduled bookings*/
	public static void listScheduledBookings() {
		clearConsole();
		//prints listScheduledBookings screen
		BookingSystem.printScheduledBookings();
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				System.out.println("Error! \n Invalid input \n Please enter a valid input");
				listScheduledBookings();
				break;
		}
	}

	/** @param prints the listCompletedBookings screen and lists all completed bookings*/
	public static void listCompletedBookings() {
		clearConsole();
		//prints listScheduledBookings screen
		//<Get list of all completed bookings>
		BookingSystem.printCompletedBookings();
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				System.out.println("Error! \n Invalid input \n Please enter a valid input");
				listCompletedBookings();
				break;
		}
	}
	
	/** @param prints the addBooking screen and adds,
	a booking based on user input*/
	public static void addBookingScreen() {
		clearConsole();
		//<Get list of available time slots>
		//print addBooking screen
		System.out.println("University of Knowledge - COVID test");
		System.out.println("\n");
		System.out.println("Adding booking (appointment for a COVID test) to the system");
		System.out.println("\n");
		System.out.println("List of available time-slots:");
		BookingSystem.printAvailableTimeSlots();
		System.out.println("\n");
		System.out.println("Please, enter one of the following:");
		System.out.println("\n");
		System.out.println("The sequential ID of an available time-slot and the student email, separated by a white space.");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//checks and executes user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				String[] arrayInput = input.split(" ");
				try {
					BookingSystem.addBooking(arrayInput);
					bookingAddedSuccessfully();
				}catch (IndexOutOfBoundsException ex){
					bookingAddedError();
				}catch (NumberFormatException ex){
					bookingAddedError();
				}catch (ArithmeticException ex){
					bookingAddedError();
				}
		}
	}
	
	/** @param prints the bookingAddedSuccessfully screen and adds,
	a booking based on user input*/
	public static void bookingAddedSuccessfully() {
		clearConsole();
		//<Get list of available time slots>
		//print bookingAddedSuccessfully screen
		System.out.println("Booking added successfully:");
		ArrayList<Booking> bookings = BookingSystem.getBookings();
		int value = bookings.size() -1;
		Booking booking = bookings.get(value);
		System.out.println(booking.getPrintTemplate());
		System.out.println("\n");
		System.out.println("List of available time-slots:");
		BookingSystem.printAvailableTimeSlots();
		System.out.println("\n");
		System.out.println("Please, enter one of the following:");
		System.out.println("\n");
		System.out.println("The sequential ID of an available time-slot and the student email, separated by a white space.");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//checks and executes user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				String[] arrayInput = input.split(" ");
				try {
					BookingSystem.addBooking(arrayInput);
					bookingAddedSuccessfully();
				}catch (IndexOutOfBoundsException ex){
					bookingAddedError();
				}catch (NumberFormatException ex){
					bookingAddedError();
				}catch (ArithmeticException ex){
					bookingAddedError();
				}
		}
	}
		
	/** @param prints the bookingAddedError screen and adds,
	a booking based on user input*/
	public static void bookingAddedError() {
		clearConsole();
		//print bookingAddedError screen
		System.out.println("Error! \n Invalid input \n Please enter a valid input");
		System.out.println("\n");
		System.out.println("Please, enter one of the following:");
		System.out.println("\n");
		System.out.println("The sequential ID of an available time-slot and the student email, separated by a white space.");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//checks and executes user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				String[] arrayInput = input.split(" ");
				try {
					BookingSystem.addBooking(arrayInput);
					bookingAddedSuccessfully();
				}catch (IndexOutOfBoundsException ex){
					bookingAddedError();
				}catch (NumberFormatException ex){
					bookingAddedError();
				}catch (ArithmeticException ex){
					bookingAddedError();
				}
		}
	}

	/** @param prints the removeBooking screen and removes,
	a booking based on user input*/
	public static void removeBookingScreen() {
		clearConsole();
		//<Get list of scheduled bookings>
		//print removeBooking screen
		System.out.println("University of Knowledge - COVID test");
		System.out.println("\n");
		BookingSystem.printScheduledBookings();
		System.out.println("Removing booking from the system");
		System.out.println("\n");
		System.out.println("Please, enter one of the following:");
		System.out.println("\n");
		System.out.println("The sequential ID to select the booking to be removed from the listed bookings above.");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//checks and executes user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				try {
					BookingSystem.removeBooking(input);
					bookingRemovedSuccessfully();
				}catch (IndexOutOfBoundsException ex){
					bookingRemovedError();
				}catch (NumberFormatException ex){
					bookingRemovedError();
				}
		}
	}
	
	/** @param prints the bookingRemovedSuccessfully screen and removes,
	a booking based on user input*/
	public static void bookingRemovedSuccessfully() {
		clearConsole();
		//print bookingRemovedSuccessfully screen
		System.out.println("Booking removed successfully:");
		BookingSystem.printLastBookingDeleted();
		System.out.println("Please, enter one of the following:");
		System.out.println("\n");
		System.out.println("The sequential ID to select the booking to be removed from the listed bookings above.");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//checks and executes user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				try {
					BookingSystem.removeBooking(input);
					bookingRemovedSuccessfully();
				}catch (IndexOutOfBoundsException ex){
					bookingRemovedError();
				}catch (NumberFormatException ex){
					bookingRemovedError();
				}
		}
	}
		
	/** @param prints the bookingRemovedError screen and removes,
	a booking based on user input*/
	public static void bookingRemovedError() {
		clearConsole();
		//print bookingRemovedErrorscreen
		System.out.println("Error! \n Invalid input \n Please enter a valid input");
		System.out.println("Please, enter one of the following:");
		System.out.println("\n");
		System.out.println("The sequential ID to select the booking to be removed from the listed bookings above.");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//checks and executes user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				try {
					BookingSystem.removeBooking(input);
					bookingRemovedSuccessfully();
				}catch (IndexOutOfBoundsException ex){
					bookingRemovedError();
				}catch (NumberFormatException ex){
					bookingRemovedError();
				}
		}
	}
	
	/** @param prints the concludeBooking screen and concludes,
	a booking based on user input*/
	public static void concludeBookingScreen() {
		clearConsole();
		//<Get list of scheduled bookings>
		//print concludeBooking screen
		System.out.println("University of Knowledge - COVID test");
		System.out.println("\n");
		BookingSystem.printScheduledBookings();
		System.out.println("Conclude booking");
		System.out.println("\n");
		System.out.println("Please, enter one of the following:");
		System.out.println("\n");
		System.out.println("The sequential ID to select the booking to be completed.");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//checks and executes user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				try {
					BookingSystem.concludeBooking(input);
					bookingCompletedSuccessfully();
				}catch (IndexOutOfBoundsException ex){
					bookingCompletedError();
				}catch (NumberFormatException ex){
					bookingCompletedError();
				}
		}
	}
	
	/** @param prints the bookingCompletedSuccessfully screen and concludes,
	a booking based on user input*/
	public static void bookingCompletedSuccessfully() {
		clearConsole();
		//print bookingCompletedSuccessfully screen
		System.out.println("Booking completed successfully:");
		System.out.println("<print booking>");
		System.out.println("Please, enter one of the following:");
		System.out.println("\n");
		System.out.println("The sequential ID to select the booking to be completed.");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//checks and executes user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				try {
					BookingSystem.concludeBooking(input);
					bookingCompletedSuccessfully();
				}catch (IndexOutOfBoundsException ex){
					bookingCompletedError();
				}catch (NumberFormatException ex){
					bookingCompletedError();
				}
		}
	}
				
	/** @param prints the bookingCompletedError screen and removes,
	a booking based on user input*/
	public static void bookingCompletedError() {
		clearConsole();
		//print bookingCompletedError
		System.out.println("Error! \n Invalid input \n Please enter a valid input");
		System.out.println("Please, enter one of the following:");
		System.out.println("\n");
		System.out.println("The sequential ID to select the booking to be completed.");
		System.out.println("0. Back to main menu.");
		System.out.println("-1. Quit application.");
		System.out.println("\n");
		//checks and executes user input
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "-1":
				System.exit(0);
				break;
			case "0":
				mainMenuScreen();
				break;
			default:
				try {
					BookingSystem.concludeBooking(input);
					bookingCompletedSuccessfully();
				}catch (IndexOutOfBoundsException ex){
					bookingCompletedError();
				}catch (NumberFormatException ex){
					bookingCompletedError();
				}
		}
	}
	
	public static void clearConsole(){
		//try{
			//new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			//System.out.print("\033[H\033[2J");  
			//System.out.flush();
			//Runtime.getRuntime().exec("cls");
		//}catch (IOException e){
		//}catch (InterruptedException e){
		//}
	}
}
		
		
		
		
	
