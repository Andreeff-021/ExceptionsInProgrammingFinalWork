import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GetData {

    public String[] getData() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Введите данные: ");
            String data = scanner.nextLine();
            String[] arrayData = data.split(" ");
            if (arrayData.length == 6) {
                scanner.close();
                return arrayData;
            } else System.out.println("Данных не хватает, либо лишние!");
        }
    }

    public Data data(String[] strings) throws GenderException, DateException, PhoneException, FioException {
        String[] strData = new String[6];
        for (String item : strings) {
            if(isValidGender(item))
                strData[3] = item;
            else if(isValidDate(item))
                strData[4] = item;
            else if (isValidNumber(item))
                strData[5] = item;
            else if(isValidFio(item)){
                if(strData[0] == null) strData[0] = item;
                else if(strData[1] == null) strData[1] = item;
                else strData[2] = item;
            }
        }

        if (strData[2] == null)
            throw new FioException();
        if (strData[3] == null)
            throw new GenderException();
        if (strData[4] == null)
            throw new DateException();
        if (strData[5] == null)
            throw new PhoneException();

        Data data = new Data(strData[0], strData[1], strData[2], strData[3], strData[4], strData[5]);

        return data;
    }


    private static boolean isValidFio (String inFio){
        return inFio.chars().allMatch(Character::isLetter);
    }

    private static boolean isValidGender (String inGender) {
        return inGender.length() == 1 && (inGender.equals("m") || inGender.equals("f"));
    }

    private static boolean isValidDate (String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    private static boolean isValidNumber (String inNumber) {
        if (inNumber.length() < 5 || inNumber.length() > 11)
            return false;
        return inNumber.chars().allMatch(Character::isDigit);
    }
}
