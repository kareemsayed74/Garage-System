
public class Configuration {
	static private int configuration=1;
	
	public void setConfiguration(int conf){
		configuration=conf;
	}
	
	//a method that returns a searchType according to the configuration value
	public SearchType getCurrentConfiguration(){
		if(configuration==1){
			return new FirstSlot();
		}
		else return new BestFit();
	}
}
