package tdc.edu.searchlancuoi;

public class UserModel {
    private String firsrName;
    private String lastName;
    private String phone;

    public String getFirsrName() {
        return firsrName;
    }

    public void setFirsrName(String firsrName) {
        this.firsrName = firsrName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserModel(String firsrName, String lastName, String phone) {
        this.firsrName = firsrName;
        this.lastName = lastName;
        this.phone = phone;
    }
}
