package home_smart_appliances;

public class Item {
	
	public String key;
	public int threshold;
	public int amntRem; 
	
	public Item(String key, int threshold, int amntRem) {
		this.key = key;
		this.threshold = threshold; 
		this.amntRem = amntRem;
		
	}

}
