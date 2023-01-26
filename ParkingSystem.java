import java.util.*; 
public class ParkingSystem {
	static SearchType search;
	static ArrayList<Vehicle>vehicles=new ArrayList<Vehicle>(); // the parked vehicles
	
	void setSearchType(SearchType searchType){
		search=searchType;
	}
	
	// the parking in function 
	public void parkIn()
	{
		Vehicle newVehicle=new Vehicle();
		
		UserInterFace ui=new UserInterFace();
		ui.inputVehicle(newVehicle); // input the new vehicle info 
		
		Garage garage=new Garage();
		
		// the function search will look for an ID and set that id to the vehicle 
		if( search.SearchForSlot(newVehicle,garage.getGarageSlots())== false){
			ui. noAvailableSlots(); return;
		}
		
		// print the selected slot
		ui.printSelectedSlot(newVehicle.getSlotId());
		
		// marking the arrival time for the vehicle
		Time time=new Time();
		time.markArrivalTime(newVehicle);
		
		// add the vehicle to the parked vehicles
		vehicles.add(newVehicle);
		
		Calculate calculate=new Calculate();
		calculate.incrementNoOfVehicles();
	}
	
	private Vehicle searchForVehicle(int id){
		for(Vehicle v:vehicles){
			if(v.getIdNum()==id){
				return v;
			}
		}
		return null;
	}
	
	// the park out function which use an id to park out the car
	public void parkOut(int id){
		// first search for the vehicle using the id
		Vehicle vehicle=searchForVehicle(id);
		UserInterFace ui=new UserInterFace();
		if(vehicle==null){
			ui.idNotFound();
			return;
		}
		
		// free the slot
		Garage garage=new Garage();
		Free free =new Free();
		free.setSlotFree(vehicle,garage.getGarageSlots());
		
		// mark the departure time
		Time time=new Time();
		time.markDepurtureTime(vehicle);
		
		Calculate calculate=new Calculate();
		int fees=calculate.calculateFees(vehicle);
		calculate.modifyTotalIncome(fees); // modify the total income with the new fees
		
		// print the fees
		ui.printArrivalTime(vehicle.getArrivalTime());
		ui.printDepartureTime(vehicle.getDepartureTime());
		ui.printFees(fees,vehicle.getIdNum());
		ui.operationIsDone();
		
		//remove the vehicle from parked vehicles
		vehicles.remove(vehicle);
	}
	
}
