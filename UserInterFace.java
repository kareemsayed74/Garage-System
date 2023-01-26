import java.util.Scanner;

// a user interface
public class UserInterFace {
 
	public void displaySlots()
	{
		Garage garage=new Garage();
		for(Slot s : garage.getGarageSlots())
		{
			// if free print it
			if(s.State()){
				System.out.println("The slot ID: "+s.getId()+"\nThe slot width: "+s.getSlotWidth()+"\nThe slot depth: "+s.getSlotDepth());
				System.out.println();
			}
		}
	}
	void StartParkingIn(){
		ParkingSystem ps=new ParkingSystem();
		ps.parkIn();
	}
	void StartParkingOut(){
		ParkingSystem ps=new ParkingSystem();
		// take the id to park out
		@SuppressWarnings("resource")
		Scanner inp=new Scanner(System.in);
		System.out.println("The Vehicle ID: ");
		ps.parkOut(inp.nextInt());
	}
	//function that takes a vehicle as a parameter and fill this vehicle information from the user
	public void inputVehicle(Vehicle vehicle)
	{
		System.out.println("Please enter the information of the vehicle.");
		@SuppressWarnings("resource")
		Scanner inp=new Scanner(System.in);
		System.out.println("Model name: ");
		vehicle.setModelName(inp.nextLine());
		System.out.println("Model year: ");
		vehicle.setModelYear(inp.nextLine());
		System.out.println("ID: ");
		vehicle.setIdNum(inp.nextInt());
		System.out.println("The vehicle width: ");
		vehicle.setWidth(inp.nextInt());
		System.out.println("The vehicle depth: ");
		vehicle.setDepth(inp.nextInt());
		System.out.println("Thank You.");
	}
	public void changeConfiguration()
	{
		System.out.print("choose configuration 1 or 2 (1-first come first served 2-best fit): ");
		// first take the new configuration from user
		@SuppressWarnings("resource")
		Scanner inp=new Scanner(System.in);
		Configuration configuration=new Configuration();
		int conf=inp.nextInt();
		configuration.setConfiguration(conf);
		
		// we need to modify the searchType in the system (using method current)
		ParkingSystem park=new ParkingSystem();
		park.setSearchType(configuration.getCurrentConfiguration());
		operationIsDone();
	}
	public void startGarageSetUp()
	{
		@SuppressWarnings("resource")
		Scanner inp=new Scanner(System.in);
		System.out.print("Enter the number of slots: ");
		int size=inp.nextInt();
		Garage garage=new Garage();
		for(int i=0;i<size;i++){
			System.out.println("Enter the info of slot "+(i+1));
			garage.getGarageSlots().add( inputSlot());
		}
		changeConfiguration();
	}
	
	private Slot inputSlot(){
		Slot slot=new Slot();
		@SuppressWarnings("resource")
		Scanner inp=new Scanner(System.in);
		System.out.print("Enter the slot width: ");
		slot.setSlotWidth(inp.nextInt());
		System.out.print("Enter the slot depth: ");
		slot.setSlotDepth(inp.nextInt());
		return slot; 
	}
	void printTotalIncome(){
		Calculate calculate=new Calculate();
		System.out.println("Total income = "+calculate.getTotalIncome());
	}
	void printTotalNoOfVehicles(){
		Calculate calculate=new Calculate();
		System.out.println("Total number of vehicles = "+calculate.getNoOfVehicles());
	}
	void printArrivalTime(String time){
		System.out.println("The Arrival time: "+time);
	}
	void printDepartureTime(String time){
		System.out.println("The departure time: "+time);
	}
	void printSelectedSlot(int id){
		System.out.println("The selected slot ID = "+id);
	}
	public void noAvailableSlots()
	{
		System.out.println("Sorry! there is no available slots right now with such dimensions.");
	}
	public void noSuchDimensions()
	{
		System.out.println("Sorry! there is no avalibale slot with such dimensions.");
	}
	public void operationIsDone(){
		System.out.println("The operation is done.");
	}
	
	public void idNotFound(){
		System.out.println("Sorry! there is no vehicle with such ID.");
	}
	public void printFees(int fees,int id){
		System.out.println("The vehicle with ID "+id+" fees = "+fees +" pounds");
	}
}
