import java.util.*; 
public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Starting garage setup...");
		UserInterFace ui=new UserInterFace();
		ui.startGarageSetUp();
		while(true){
			int option;
			System.out.println(
					 "Menu:\n"
					+ "1- Park in.\n"
					+ "2- Park out.\n"
					+ "3- Change current configuration.\n"
					+ "4- Display available slots.\n"
					+ "5- Calculate total income.\n"
					+ "6- Calculate the total number of vehicles.\n"
					+ "7- Exit"
					);
			
			System.out.print("Choose an operation: ");
			Scanner inp=new Scanner(System.in);
			option=inp.nextInt();
			
			if(option==1){
				ui.StartParkingIn();
			}else if(option==2){
				ui.StartParkingOut();
			}else if(option==3){
				ui.changeConfiguration();
			}else if(option==4){
				ui.displaySlots();
			}else if(option==5){
				ui.printTotalIncome();
			}else if(option==6){
				ui.printTotalNoOfVehicles();
			}else if(option==7){
				return;
			}
			else {
				System.out.println("Invalid operation! please try again.");
			}
		}
	}
}
