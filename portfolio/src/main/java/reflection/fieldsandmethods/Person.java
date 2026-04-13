package reflection.fieldsandmethods;

public class Person {
    private String name;
    private int age;
    private String password = "XYZ-42";


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String greet() {
        return "Hello, my name is " + name;
    }

    private String getPassword() {
        return password;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

