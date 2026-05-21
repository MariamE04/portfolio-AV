package designpatterns.composite;

public class Main {
    public static void main(String[] args) {
        Enemy enemy1 = new Enemy("Goblin");
        Enemy enemy2 = new Enemy("Orc");
        Enemy enemy3 = new Enemy("Troll");

        EnemyGroup subGroup = new EnemyGroup("subGroup");
        subGroup.add(enemy1);
        subGroup.add(enemy2);

        EnemyGroup mainGroup = new EnemyGroup("mainGroup");
        mainGroup.add(subGroup);
        mainGroup.add(enemy3);

        mainGroup.update();
    }
}

// Der blev lavet en fjendestruktur med to niveauer, hvor `mainGroup` indeholder en anden gruppe (`subGroup`).

//Da `update()` blev kaldt på `mainGroup`, blev alle grupper og enemies opdateret i rækkefølge.
// Først blev `mainGroup` opdateret, derefter `subGroup`, og til sidst alle enemies i grupperne.

//Det minder om traversal af et træ, fordi programmet gennemgår alle noder i strukturen én efter én.
// En gruppe kan indeholde både enemies og andre grupper.