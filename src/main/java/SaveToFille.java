import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class SaveToFille {
    public void writeToFile (Data data) {
        String strData = data.convertToString(data);
        String fileName = data.getLastName().toLowerCase() + ".txt";
        try(FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(strData + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
