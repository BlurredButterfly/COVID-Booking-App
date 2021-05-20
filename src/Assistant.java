public class Assistant {
	//Attributes
	private String name;
	private String email;

	public Assistant (String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void printAssistant(){
		System.out.println("| " + this.name + " | " + this.email + " |");
	}
	
	public String getPrintTemplate(){
		String printTemplate = "| " + this.name + " | " + this.email + " |";
		return printTemplate;
	}
}