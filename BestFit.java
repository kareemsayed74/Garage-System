import java.util.*; 
public class BestFit implements SearchType{
	
	public Boolean SearchForSlot(Vehicle vehicle,ArrayList<Slot>garageSlots)
	{
		Slot slot=null; // look for best dimensions using the variable
		for(Slot s:garageSlots){
			// if the slot fits and slot has null -> just modify it  
			if(s.getSlotDepth()>=vehicle.getDepth() && s.getSlotWidth()>=vehicle.getWidth() && slot==null &&s.State()){
				slot=s;
			}
			// if slot don't has null modify it if the slot is smaller 
			else if(s.getSlotDepth()>=vehicle.getDepth() && s.getSlotWidth()>=vehicle.getWidth() && s.getSlotDepth()<slot.getSlotDepth() && s.getSlotWidth()<slot.getSlotWidth()&&s.State()){
				slot=s;
			}
		}
		if(slot==null)return false; // not found
		
		slot.setOff(); // set the slot off
		vehicle.setSlotid(slot.getId());
		return true;
	}
}
