package people;

public class Person {

    public int mId;
    public String mName;
    public String mCnic;
    public String mPhone;
    public String mAddress;
    public String mDateOfBirth;

    public Person(int id, String name, String cnic, String address, String phone, String dateOfBirth) {
        this.mId=id;
        this.mName = name;
        this.mCnic = cnic;
        this.mAddress = address;
        this.mPhone = phone;
        this.mDateOfBirth = dateOfBirth;
    }
}
