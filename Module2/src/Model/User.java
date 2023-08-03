package Model;

public class User {
    private String userCode;
    private String userName;
    private int userAge;
    private String userPhoneNumber;
    private String address;

    public User() {
    }

    public User(String userCode, String userName, int userAge, String userPhoneNumber, String address) {
        this.userCode = userCode;
        this.userName = userName;
        this.userAge = userAge;
        this.userPhoneNumber = userPhoneNumber;
        this.address = address;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
