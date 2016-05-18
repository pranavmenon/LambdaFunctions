
public class Person {
  String name;
  int age;
  
  public Person (String name, int age){
    this.name = name;
    this.age = age;
  }
  
  public static int compareByAge(Person a, Person b) {
    return a.age - b.age;
  }
  
  @Override
  public String toString() {
    return name + ' ' + age;
  }
}
