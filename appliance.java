import java.io.*;
import java.util.*;
import java.lang.*;

public class appliance
{
    private int max_count=100;
    private String name;
    private int code;
    private ArrayList<String> FixList=new ArrayList<>(max_count);
    private int[] FixCostList=new int[max_count];
    private int[] threshold=new int[max_count];
    appliance()
    {
        String FILENAME;
        Scanner reader=new Scanner(System.in);
        System.out.println("Enter the appliance configuration file directory : \n");
        FILENAME=reader.nextLine();
        configureFromFile(FILENAME);
    }

    public appliance configureFromFile(String FILENAME)
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
            FixCostList[n]=result;
            n++;
            temp=reader.nextLine();
        }
        temp=reader.nextLine();
        n=0;
        while(temp!="endItemThreshold")
        {
            result = Integer.parseInt(temp);
            System.out.println(result);
            threshold[n]=result;
            n++;
            temp=reader.nextLine();
            
        }
        return this;
    }

}
