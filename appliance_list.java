import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * Created by mOh on 11-Apr-17.
 */
public class appliance_list {
    private int max_count = 100;
    private int n = 0;
    public ArrayList<String> Appliance_Table = new ArrayList<>(max_count);
    public ArrayList<Integer> Appliance_Count = new ArrayList<>(max_count);
    public ArrayList<Integer> accountSummary = new ArrayList<>(max_count);
    public int TotalCost = 0;

    public void addFix(appliance app, String FixName) {
        TotalCost += app.FixCostList.get(app.FixList.indexOf(FixName));
        Appliance_Table.add(n, FixName);
        accountSummary.add(n, app.FixCostList.get(app.FixList.indexOf(FixName)));
        n++;
    }

    public boolean lowItem(appliance app, String ThresholdName) {
        if (app.threshold.get(app.thresholdName.indexOf(ThresholdName)) < Appliance_Count.get(app.thresholdName.indexOf(ThresholdName))) {
            addFix(app, ThresholdName);
            return true;
        } else return false;
    }

    public void checkout() throws IOException {
        int j = 0;
        BufferedWriter bw = null;
        FileWriter fw = null;
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the checkout output destination : \n");
        String FILENAME = reader.nextLine();
        fw = new FileWriter(FILENAME);
        bw = new BufferedWriter(fw);
        while (j < max_count) {
            try {
                bw.write(Appliance_Table.get(j));
                bw.write(Appliance_Count.get(j));
                j++;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bw != null)
                        bw.close();
                    if (fw != null)
                        fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }
}
