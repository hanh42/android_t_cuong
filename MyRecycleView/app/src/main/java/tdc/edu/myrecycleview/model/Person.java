package tdc.edu.myrecycleview.model;

public class Person {
    private String name;
    private String hobbies;

    public Person(String name, String hobbies) {
        this.name = name;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", hobbies='" + hobbies + '\'' +
                '}';
    }
}
