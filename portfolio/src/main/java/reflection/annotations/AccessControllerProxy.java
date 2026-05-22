package reflection.annotations;

import java.lang.reflect.Method;

public class AccessControllerProxy implements Service {

    private SecureService secureService;
    private User user;

    public AccessControllerProxy(User user) {
        this.secureService = new SecureService();
        this.user = user;
    }

    @Override
    public void deleteAllUsers() {
        invokeIfAuthorized("deleteAllUsers");
    }

    @Override
    public void viewProfile() {
        invokeIfAuthorized("viewProfile");
    }

    @Override
    public void help() {
        invokeIfAuthorized("help");
    }

    private void invokeIfAuthorized(String methodName) {

        try {

            Method method =
                    secureService.getClass().getMethod(methodName);

            Role roleAnnotation =
                    method.getAnnotation(Role.class);

            // Ingen rolle kræves
            if (roleAnnotation == null) {
                method.invoke(secureService);
                return;
            }

            String requiredRole = roleAnnotation.value();

            if (user.getRole().equals(requiredRole)) {

                System.out.println("Adgang givet til "
                        + methodName);

                method.invoke(secureService);

            } else {

                System.out.println("Adgang nægtet til "
                        + methodName);
            }

        } catch (Exception e) {
            System.out.println("Fejl: " + e.getMessage());
        }
    }
}