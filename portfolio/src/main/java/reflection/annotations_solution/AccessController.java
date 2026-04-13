package reflection.annotations_solution;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class AccessController {

        public static void invokeIfAuthorized(Object service, User user, String methodName) {
            try {
                Method method = service.getClass().getMethod(methodName);
                Role roleAnnotation = method.getAnnotation(Role.class);
                Log logAnnotation = method.getAnnotation(Log.class);

                boolean accessGranted = false;

                if (roleAnnotation == null || user.getRole().equals(roleAnnotation.value())) {
                    accessGranted = true;
                }

                if (logAnnotation != null) {
                    logAction(logAnnotation.fileName(), methodName, user.getName(),accessGranted);
                }
                if (accessGranted) {
                    System.out.println("Metode '" + methodName + "' kaldes af " + user.getName());
                    method.invoke(service);
                } else {
                    System.out.println("Adgang nægtet til '" + methodName + "' for bruger '" + user.getName() + "'");
                }

            } catch (NoSuchMethodException e) {
                System.out.println("Metoden '" + methodName + "' findes ikke.");
            } catch (Exception e) {
                System.out.println("Fejl under metodekald: " + e.getMessage());
            }
        }

        private static void logAction(String fileName, String methodName, String userName, boolean succes) {
            try (FileWriter writer = new FileWriter(fileName, true)) {
                String entry = LocalDateTime.now() + " | " + userName + " kaldte " + methodName;
                if(succes) entry += ". Adgang blev givet.\n";
                else entry += ". Adgang blev nægtet.\n";
                writer.write(entry);
            } catch (IOException e) {
                System.out.println("Fejl under logning: " + e.getMessage());
            }
        }
}
