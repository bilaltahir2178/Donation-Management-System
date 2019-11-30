package people;

public class Person {

    public String mName;
    public String mCnic;
    public String mPhone;
    public String mAddress;
    public String mDateOfBirth;

    public Person(String name, String cnic, String address, String phone, String dateOfBirth) {
        this.mName = name;
        this.mCnic = cnic;
        this.mAddress = address;
        this.mPhone = phone;
        this.mDateOfBirth = dateOfBirth;
    }
}
