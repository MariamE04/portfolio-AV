package reflection.annotations;

public class Main {

    public static void main(String[] args) {

        User admin = new User("Alice", "admin");
        User normal = new User("Bob", "user");

        Service adminService =
                new AccessControllerProxy(admin);

        Service userService =
                new AccessControllerProxy(normal);

        adminService.deleteAllUsers();


        userService.deleteAllUsers();

        userService.viewProfile();

        userService.help();
    }
}