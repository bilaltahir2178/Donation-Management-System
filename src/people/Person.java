package people;

public class Person {
    protected String mName;
    protected int mAge;
    protected String mCnic;
    protected String mAddress;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        this.mAge = age;
    }

    public String getCnic() {
        return mCnic;
    }

    public void setCnic(String cnic) {
        this.mCnic = cnic;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        this.mAddress = address;
    }
}
