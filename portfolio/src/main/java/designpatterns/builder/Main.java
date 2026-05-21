package designpatterns.builder;

public class Main {
    public static void main(String[] args) {
       User user = new User.Builder("Hans", "hans@gmail.com")
               .address("Firskovvej 18")
               .phone("2346678")
               .country("DK")
               .newsletter(true)
               .build();

       User user1 = new User.Builder("Lumiere", "lumin@gmail.com")
               .build();

       System.out.println(user);
       System.out.println("-------");
       System.out.println(user1);
    }
}


// I main-metoden blev der oprettet to User-objekter ved hjælp af Builder pattern.

//Den første bruger fik alle felter sat:
//* name
//* email
//* address
//* phone
//* country
//* newsletter

//Den anden bruger fik kun de obligatoriske felter:
//* name
//* email

//Outputtet viser, at de felter der ikke bliver sat, får deres defaultværdier fra Builder-klassen.

//Defaultværdien for country er "DK".