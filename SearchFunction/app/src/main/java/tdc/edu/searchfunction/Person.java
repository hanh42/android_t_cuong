package tdc.edu.searchfunction;

public class Person {
    private String name;
    private String address;
    private int img;

    public Person(String name, String address, int img) {
        this.name = name;
        this.address = address;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
