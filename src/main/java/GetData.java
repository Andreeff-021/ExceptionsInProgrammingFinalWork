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
                return arrayData;
            } else System.out.println("Данных не хватает, либо лишние!");
        }
    }

    public Data data(String[] strings) throws GenderException, DateException, PhoneException, FioException {
        List<String> fio = new ArrayList<>();
        HashMap dataMap = new HashMap();
        for (String item : strings) {
            if(isValidGender(item))
                dataMap.put("gender", item);
            else if(isValidDate(item))
                dataMap.put("date", item);
            else if (isValidNumber(item))
                dataMap.put("phone", item);
            else if(isValidFio(item))
                fio.add(item);
        }

        if (!dataMap.containsKey("gender"))
            throw new GenderException();
        if (!dataMap.containsKey("date"))
            throw new DateException();
        if (!dataMap.containsKey("phone"))
            throw new PhoneException();
        if (fio.size() != 3)
            throw new FioException();

        Data data = new Data(fio.get(0),
                fio.get(1), fio.get(2),
                (String) dataMap.get("gender"),
                (String) dataMap.get("date"),
                (String) dataMap.get("phone"));

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
