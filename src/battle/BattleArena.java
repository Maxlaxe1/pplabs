package battle;

import droid.Droid;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class BattleArena {
    private final Droid firstDroid;
    private final Droid secondDroid;
    private Droid attacker;
    private Droid defender;
    public static StringBuilder battleRecord = new StringBuilder();
    private int currentRound = 0;

    public BattleArena(Droid firstDroid, Droid secondDroid) {
        this.firstDroid = firstDroid;
        this.secondDroid = secondDroid;
    }

    public Droid startFight() throws InterruptedException {
        do {
            prepareRound();
            int actualDamage = doFight();
            printRoundInfo(actualDamage);

            TimeUnit.SECONDS.sleep(1);
        } while (defender.isAlive());
        return attacker;
    }

    private void prepareRound() {
        initFighters();
        currentRound++;
        String temp = "-------------------------------------";
        battleRecord.append(temp).append("\n");
        System.out.println(temp);
        temp = "Round " + currentRound;
        battleRecord.append(temp).append("\n");
        System.out.println(temp);
    }

    private int doFight() {
        return defender.getHit(attacker.getDamage());
    }

    private void printRoundInfo(int actualDamage) {
        String temp = defender.getName() + " get hit with " + actualDamage + " damage";
        battleRecord.append(temp).append("\n");;
        System.out.println(temp);

        temp = "Defender " + defender;
        battleRecord.append(temp).append("\n");

        System.out.println(temp);
        temp = "Attacker " + attacker;
        battleRecord.append(temp).append("\n");

        System.out.println(temp);
    }

    private void initFighters() {
        Random random = new Random();
        if (random.nextBoolean()) {
            attacker = firstDroid;
            defender = secondDroid;
        } else {
            attacker = secondDroid;
            defender = firstDroid;
        }
    }
}
