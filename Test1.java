import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Test1 {

  interface MathOperation {
    int operation(int a, int b);
  }
  
  interface GreetingService {
    void greet(String message);
  }
  
  static int operate(int a, int b, MathOperation op){
    return op.operation(a, b);
  }
  
  static void lambdaTest(){
    MathOperation add = (a,b) -> a + b;         //lambda function
    MathOperation subtract = (a,b) -> a - b;    //lambda function
    MathOperation multiply = (a,b) -> a * b;    //lambda function
    MathOperation divide = (a,b) -> a / b;      //lambda function
    GreetingService polite = message -> System.out.println("Hello " + message);   //lambda function
    GreetingService rude = message -> System.out.println("Get lost " + message);  //lambda function
    
    System.out.println(operate(10, 5, add));
    System.out.println(operate(10, 5, subtract));
    System.out.println(operate(10, 5, multiply));
    System.out.println(operate(10, 5, divide));
    polite.greet("John");
    rude.greet("David");
  }
  
  static void methodRefereceTest(){
    String[] stringArray = { "Barbara", "James", "Mary", "John","Patricia", "Robert", "Michael", "Linda" };
    Arrays.sort(stringArray, String::compareToIgnoreCase);  //method reference usage
    System.out.println(Arrays.toString(stringArray));
    
    Person p1 = new Person("John", 21);
    Person p2 = new Person("David", 30);
    Person p3 = new Person("Linda", 18);
    Person p4 = new Person("Rebecca", 27);
    Person p5 = new Person("Alan", 24);
    ArrayList<Person> list = new ArrayList<Person>();
    Collections.addAll(list, p1, p2, p3, p4, p5);
    System.out.println("\n" + list);
    Collections.sort(list, Person::compareByAge);           //method reference usage
    System.out.println(list);
  }
  
  
  static void aggregateTest(){
    Person p1 = new Person("John", 21);
    Person p2 = new Person("David", 30);
    Person p3 = new Person("Linda", 18);
    Person p4 = new Person("Rebecca", 27);
    Person p5 = new Person("Alan", 24);
    ArrayList<Person> list = new ArrayList<Person>();
    Collections.addAll(list, p1, p2, p3, p4, p5);
    System.out.println(list);
    
    list.                                   //aggregate operation
      stream().
      filter(p -> p.age < 25).
      forEach(p -> System.out.println(p));
  }
  
  public static void main (String args[]) {
    aggregateTest();
  }


}
