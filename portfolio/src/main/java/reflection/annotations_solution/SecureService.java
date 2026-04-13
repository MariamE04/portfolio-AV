package reflection.annotations_solution;

public class SecureService {

    @Role("admin")
    @Log(fileName = "admin-actions.log")
    public void deleteAllUsers() {
        System.out.println("Alle brugere er slettet.");
    }

    @Role("user")
    public void viewProfile() {
        System.out.println("Profil vist.");
    }

    public void help() {
        System.out.println("Hjælp åbnet.");
    }
}
