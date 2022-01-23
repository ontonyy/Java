package CSVread;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.Arrays;

public class readCSV {
    public static void main(String[] args) {
        CSVReader reader = null;
        try
        {
            reader = new CSVReader(new FileReader("C:\\JavaRushTasks\\OwnTries\\src\\main\\java\\CSVread\\test.csv"));
            String [] nextLine;
            while ((nextLine = reader.readNext()) != null)
            {
                System.out.println(Arrays.toString(nextLine));
                System.out.print("\n");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
