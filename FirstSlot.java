import java.util.*; 
public class FirstSlot implements SearchType{
	
	public Boolean SearchForSlot(Vehicle vehicle,ArrayList<Slot>garageSlots)
	{	
		int i=0;
		for(Slot s : garageSlots)
		{
			if(vehicle.getDepth() <= s.getSlotDepth() && vehicle.getWidth()<=s.getSlotWidth() && s.State()) 
			{
				// set the garage that we have chosen off 
				garageSlots.set(i, garageSlots.get(i) .setOff());
				
				// save the slot id into the vehicle information
				vehicle.setSlotid( garageSlots.get(i).getId() );

				return true;
			}
			i++;
		}
		
		// no such dimensions
		return false;
	}
}
