import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
    private String lastName;
    private String firstName;
    private String middleName;
    private String gender;
    private String date;
    private  String phone;

    public Data(String lastName, String firstName, String middleName, String gender, String date, String phone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.gender = gender;
        this.date = date;
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getGender() {
        return gender;
    }

    public String getDate() {
        return date;
    }

    public String getPhone() {
        return phone;
    }

    public String convertToString(Data data) {
        List<String> list = new ArrayList<>(Arrays.asList(data.getLastName(),
                data.getFirstName(),
                data.getMiddleName(),
                data.getGender(),
                data.getDate(),
                data.getPhone()));
        return String.join(", ", list);
    }
}