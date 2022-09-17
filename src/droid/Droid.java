package droid;

import java.util.Random;

public class Droid {
    private String name;
    private int health;

    private int healthSaver;
    private int damage;

    public Droid(String name) {
        this.name = name;
        this.health = 100;
        this.damage = 50;
        healthSaver = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {

        this.health = health;
    }

    public void setHealthAgain(){this.health = healthSaver;}

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHit(int damage) {
        Random random = new Random();

        int actualDamage = random.nextInt(damage);
        this.health -= actualDamage;

        if (health < 0) {
            health = 0;
        }

        return actualDamage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return name + " health = " + health + " damage = " + damage;
    }


}
