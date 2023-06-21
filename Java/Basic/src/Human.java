public class Human extends Creature{

    String name;
    int age;
    double weight;

    protected String school = "UOA";

    Human(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    void eat() {
        System.out.println(this.name + " is eating");
    }

    void drink() {
        System.out.println(this.name + " is drinking");
    }


    @Override
    public void makeSound() {
        System.out.println("Jie Jie Jie");
    }
}