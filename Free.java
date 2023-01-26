import java.util.*; 
public class Free {
	public void setSlotFree(Vehicle vehicle,ArrayList<Slot>garageSlots)
	{
		for(Slot s:garageSlots){
			if(s.getId()==vehicle.getSlotId())
			{
				s.setOn();//open the slot 
				return;
			}
		}
	}
}
