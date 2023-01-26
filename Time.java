import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Time {
	
	// return the current time in a string
	private String getTime()
	{
		 DateTimeFormatter t = DateTimeFormatter.ofPattern("HH:mm");  
		 LocalDateTime now = LocalDateTime.now();  
		 return t.format(now);  
	}
	
	// set the arrival time for a vehicle
	public void markArrivalTime(Vehicle vehicle){
		vehicle.setArrivalTime(getTime());
	}
	
	public void markDepurtureTime(Vehicle vehicle){
		vehicle.setDepartureTime(getTime());
	}
}
