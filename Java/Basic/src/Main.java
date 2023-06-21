import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Human human1 = new Human("Ning", 12, 55.55);
        Human human2 = new Human("Chen", 21, 66.66);

//        human1.eat();
//        human2.drink();

//        Person person1 = new Person();
//        System.out.println(person1.getName());
//        person1.setName("Ning");
//        System.out.println(person1.getName());

//        Scanner myScanner = new Scanner(System.in);
//        System.out.println("ENTER username: ");

//        String userName = myScanner.nextLine();
//        System.out.println("username is: " + userName);

        Person person1 = new Person("Wow", 20, 80.00);

//        System.out.println(person1.getSchool());
//        System.out.println(human1.school);
//        person1.makeSound();
//        person1.sleep();

//        Dog myDog = new Dog();
//        myDog.animalSound();
//        myDog.run();

        // Enums
        Level myLevel = Level.HIGH;

        // Date
        LocalDateTime myTime = LocalDateTime.now();
//        System.out.println(myTime);

//        DateTimeFormatter myFormatTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        String res = myFormatTime.format(myTime);
//        System.out.println(res);

        // ArrayList
//        ArrayList<String> cars = new ArrayList<String>();
//        cars.add("BMW");
//        cars.add("Benz");
//        cars.add("Ford");
//        cars.add("Audi");
//        System.out.println(cars);
//
//        Collections.sort(cars);
//        System.out.println(cars);

        // LinkedList
//        LinkedList<String> linkedList = new LinkedList<String>();
//
//        linkedList.offer("A");
//        linkedList.offer("B");
//        linkedList.offer("C");
//        linkedList.offer("D");
//        linkedList.offer("F");
//
//        linkedList.add(4, "E");
//
//        System.out.println(linkedList);

        // HashMap
        HashMap<String, String> capitalCities = new HashMap<String, String>();
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("France", "Paris");

//        for (String i : capitalCities.keySet()
//             ) {
//            System.out.println(i);
//        }
//
        // Try...Catch
//        try {
//            int[] myNumbers = {1,2,3};
//            System.out.println(myNumbers[10]);
//        } catch (Exception e) {
//            System.out.println("Error");
//        } finally {
//            System.out.println("Executed");
//        }

        // Throw
        checkAge(13);

//        myMethod("Chen", 10);
//        String msg = returnString("Ning", 10);
//        System.out.println(msg);

//        int randomNum = (int)(Math.random() * 101);
//        System.out.println(randomNum);
//        System.out.println("Hello World");

//        int age = 20;
//        int votingAge = 18;

//        if (age > votingAge) {
//            System.out.println("You are old enough to vote");
//        } else if (age < votingAge) {
//            System.out.println("You are not qualified to vote");
//        } else {
//            System.out.println("Whatever");
//        }

//        String canVote = (age > votingAge) ? "You are old enough to vote" : "You are not qualified to vote";
//        System.out.println(canVote);

//        do/while loop
//        int num = 0;
//        do {
//            System.out.println(num);
//            num ++;
//        }
//        while ( num < 5);

//        String[] cars = {"BMW", "Audi", "Ford", "Toyota"};
//        for (String item :cars) {
//            System.out.println(item);
//        }

//        int[] []  myNumbers = {{1,2,3,4}, {5,6,7}};
//        System.out.println(myNumbers[1][2]);
    }

    static void myMethod(String name, int age) {
        System.out.println("Hello " + name + " You are " + age + " old");
    }

    static String returnString(String name, int age) {
        return "Hello " + name + " You are " + age + " old";
    }

    static void checkAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("Access Denied");
        }
        else {
            System.out.println("Access Granted");
        }

    }
}
