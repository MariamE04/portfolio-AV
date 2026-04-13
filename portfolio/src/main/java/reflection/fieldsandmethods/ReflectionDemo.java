package reflection.fieldsandmethods;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {

    public static void printInfo(Person p) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        System.out.println("ToString: " + p);

        // --- Find og udskriv alle felter
        Class<Person> clazz = (Class<Person>) p.getClass();
        for (Field f : clazz.getDeclaredFields()) {
            f.setAccessible(true);
            System.out.println(f.getName() + " = " + f.get(p));
        }

        // --- Kald en private metode (uden parametre)
        Method secretMethod = clazz.getDeclaredMethod("getPassword");
        secretMethod.setAccessible(true);
        String code = (String) secretMethod.invoke(p);
        System.out.println("Metodekald til getPassword(): " + code);

    }

    public static Person createPerson(String name, int age) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("reflection.fieldsandmethods.Person");
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class);
        Object o = constructor.newInstance(name, age);
        return (Person) o;
    }

    public static void chooseMethod(Person p, int age) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = p.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            Class<?>[] paramTypes = method.getParameterTypes();
            if (paramTypes.length == 1 && paramTypes[0] == int.class) {
                method.invoke(p, age);
                break;
            }

        }
    }
}
