
public class Slot {
	private int id;
	private boolean free; // if free == true then this slot is free else this slot isn't free
	private static int idMaker=0;
	private Dimension slotDimensions=new Dimension();

	Slot()
	{
		id=++idMaker;
		free=true;
	}
	public void setSlotWidth(int _slotWidth)
	{
		this.slotDimensions.setWidth(_slotWidth);
	}
	public void setSlotDepth(int _slotDepth)
	{
		this.slotDimensions.setDepth(_slotDepth);
	}
	public void setId(int id)
	{
		this.id=id;
	}
	
	public int getId()
	{
		return this.id;
	}
	public int getSlotWidth()
	{
		return this.slotDimensions.getWidth();
	}
	public int getSlotDepth()
	{
		return this.slotDimensions.getDepth();
	}
	
	// if the garage is free return true other wise return false;
	public boolean State() 
	{
		return this.free;
	}
	public Slot setOn()
	{
		this.free=true;
		
		//the point of returning the main object in the off,on functions is because we will need this in parkInApproach() 
		return this;
	}
	public Slot setOff()
	{
		this.free=false;
		return this;
	}
}
