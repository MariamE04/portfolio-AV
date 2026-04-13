package reflection.fieldsandmethods;


import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;

public class MysteryInspectorSolution{

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Brug: java MysteryInspector <fully.qualified.ClassName>");
            return;
        }

        String className = args[0];
        Class<?> clazz = Class.forName(className);


        Object box = clazz.getDeclaredConstructor().newInstance();

        System.out.println("Klasse: " + clazz.getName());

        System.out.println("\nMetoder:");
        for (Method m : clazz.getDeclaredMethods()) {
            String access = java.lang.reflect.Modifier.toString(m.getModifiers());
            String returnType = m.getReturnType().getSimpleName();
            String name = m.getName();

            // Saml parameterliste
            StringBuilder params = new StringBuilder();
            Parameter[] parameters = m.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                String type = parameters[i].getType().getSimpleName();
                String paramName = parameters[i].getName(); // Navnet er kun korrekt hvis kompileret med -parameters
                params.append(type).append(" ").append(paramName);
                if (i < parameters.length - 1) {
                    params.append(", ");
                }
            }

            System.out.println("- " + access + " " + returnType + " " + name + "(" + params + ")");
        }


        // --- Kald public metode reveal()
        Method reveal = clazz.getDeclaredMethod("reveal");
        String result = (String) reveal.invoke(box);
        System.out.println("\nKald reveal(): " + result);

        // --- Kald privat metode getSecret()
        Method secret = clazz.getDeclaredMethod("getSecret");
        secret.setAccessible(true);
        String code = (String) secret.invoke(box);
        System.out.println("Kald getSecret(): " + code);

        // --- Kald privat metode add(int, int)
        Method add = clazz.getDeclaredMethod("add", int.class, int.class);
        add.setAccessible(true);
        int sum = (int) add.invoke(box, 7, 13);
        System.out.println("Kald add(7, 13): " + sum);

        // --- BONUS: Udskriv privat felt
        Field secretField = clazz.getDeclaredField("secret");
        secretField.setAccessible(true);
        String secretValue = (String) secretField.get(box);
        System.out.println("\nVærdi af 'secret' feltet: " + secretValue);
    }
}
