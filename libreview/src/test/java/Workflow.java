import java.io.IOException;

public class Workflow extends Initiate_Driver {

	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		//start firefox browser
		Initiate_Driver d = new Initiate_Driver();
		d.setDriver();
		d.getdriver();   
		
			
		//Select country and language
		Country_Language_Selection c = new Country_Language_Selection();
		c.select_Country_Language();
		
		
	}

}
