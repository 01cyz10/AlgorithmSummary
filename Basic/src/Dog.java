public class Dog implements Animal{
    @Override
    public void animalSound() {
        System.out.println("wolf wolf");
    }

    @Override
    public void run() {
        System.out.println("Rush Dog");
    }
}
