package reflection.fieldsandmethods;


public class SecretBox {
    private String secret = "You will never find this field";

    public String reveal() {
        return "You found the box!";
    }

    private String getSecret() {
        return secret;
    }

    private int add(int a, int b) {
        return a + b;
    }

    public String toUpper(String input) {
        return input.toUpperCase();
    }
}
