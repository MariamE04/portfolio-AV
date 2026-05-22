package reflection.annotations;

public class SecureService implements Service {

    @Override
    @Role("admin")
    public void deleteAllUsers() {
        System.out.println("Alle brugere er slettet.");
    }

    @Override
    @Role("user")
    public void viewProfile() {
        System.out.println("Profil vist.");
    }

    @Override
    public void help() {
        System.out.println("Hjælp åbnet.");
    }
}