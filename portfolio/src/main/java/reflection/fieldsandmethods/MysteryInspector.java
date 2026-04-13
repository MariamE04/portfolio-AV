package reflection.fieldsandmethods;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.sql.SQLOutput;

public class MysteryInspector {

    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            System.out.println("Brug: java MysteryInspector <fully.qualified.ClassName>");
            return;
        }

        String className = args[0];  // fx "reflection.fieldsandmethods.SecretBox"
        Class<?> clazz = Class.forName(className);

        // 1. Lav et objekt


        // 2. Udskriv klassens navn


        // 3. Udskriv alle metoder inkl access modifier, returtype, navn og parameterliste
        // Obs: du kan kun udskrive navnet på parametrene fordi klassen er kompileret med -parameters. '
        // Dette sættes under File -> Settings -> Build, Execution, Deployment → Compiler → Java Compiler hvor man
        // ved "Additional command line parameters" skriver -parameters. Vælg herefter Apply og Ok
        // Derefter skal du rekompilere koden. Vælg Build -> Rebuild Project
        System.out.println("Metoder:");


        // 4. Kald metoder på dit objekt


        // 5. Udskriv alle felter inkl værdier
        System.out.println("Felter:");

    }
}
