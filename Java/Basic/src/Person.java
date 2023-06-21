public class Person extends Human{

    private String name = "Chen";

    public String school;

    // inheritance from Human class
    Person(String name, int age, double weight) {
        super(name, age, weight);
    }

    public String getName() {
        return  name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getSchool() {
        return school;
    }
}
