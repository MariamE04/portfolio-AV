package reflection.fieldsandmethods;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        Person p = new Person("Alice", 42);
        ReflectionDemo.printInfo(p);

        Person p2 = ReflectionDemo.createPerson("Sally", 8);
        System.out.println(p2);

        ReflectionDemo.chooseMethod(p, 43);
        System.out.println(p);

    }
}
