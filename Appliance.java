package home_smart_appliances;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Appliance
{
    private int max_count=100;
    public String name;
    public int code;
    public ArrayList<String> FixList=new ArrayList<>(max_count);
    public ArrayList<Integer> FixCostList=new ArrayList<>(max_count);
   
    public ArrayList<Item> items;
    
    private File configFile;
    
    public Appliance(String filename )
    {
        configFile = new File(filename);
        
        
        configureFromFile(filename);
    }

    public Appliance configureFromFile(String FILENAME)
    {
    	
        Scanner reader=new Scanner(FILENAME);
        String temp;
        temp=reader.nextLine();
        this.name=temp;
        temp=reader.nextLine();
        int result = Integer.parseInt(temp);
        System.out.println(result);
        this.code=result;
        temp=reader.nextLine();
        int n=0;
        while(temp!="endFixName") 
        {
            this.FixList.add(n,temp);
            n++;
            temp=reader.nextLine();
        }
        temp=reader.nextLine();
        n=0;
        while(temp!="endFixCost")
        {

            result = Integer.parseInt(temp);
            System.out.println(result);
            FixCostList.add(n,result);
            n++;
            temp=reader.nextLine();
        }
        temp=reader.nextLine();
        n=0;
        while(temp!="endNameThreshold")
        {
            this.thresholdName.add(n,temp);
            n++;
            temp=reader.nextLine();
        }
        temp=reader.nextLine();
        n=0;
        while(temp!="endItemThreshold")
        {
            result = Integer.parseInt(temp);
            System.out.println(result);
            threshold.add(n,result);
            n++;
            temp=reader.nextLine();
            
            
            
        }
        return this;
    }
    
    public void readItems() throws FileNotFoundException {
    	items = new ArrayList<Item>();
    	Scanner fileIn= new Scanner(configFile);
    	while(fileIn.hasNextLine()){
    		String input=fileIn.nextLine();
    		String[] inputArr = input.split(" "); 
    	    Item itemObj = new Item(inputArr[0], Integer.parseInt(inputArr[1]), Integer.parseInt(inputArr[2]));
    	    items.add(itemObj);
    	    
    	
    	}
    
    }
    
    public boolean lessThanThreshold(Item item) {
    	if(item.threshold <= item.amntRem)
    		return false;
    	return true;
    }
    

}
