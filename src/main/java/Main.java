import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws PhoneException, GenderException, DateException, FioException {
       GetData getData = new GetData();
       Data data = getData.data(getData.getData());
       System.out.println(data.convertToString(data));

       SaveToFille save = new SaveToFille();
       save.writeToFile(data);


    }


}
