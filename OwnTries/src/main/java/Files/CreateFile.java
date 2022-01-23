package Files;

import java.io.File;
import java.io.IOException;

import com.opencsv.CSVReader;

public class CreateFile {
    public static void main(String[] args) {
        File file = new File("userInfo.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
