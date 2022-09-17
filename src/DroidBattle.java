import battle.BattleArena;
import battle.BattleArenaTeam;
import droid.Droid;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class DroidBattle {
    public void battle(Droid droid1, Droid droid2) throws InterruptedException {

        BattleArena arena = new BattleArena(droid1, droid2);
        Droid winner = arena.startFight();

        StringBuilder battleRecord = BattleArena.battleRecord;

        String temp = "--------------";
        System.out.println(temp);
        battleRecord.append(temp).append("\n");
        temp = "The winner is " + winner.getName();
        battleRecord.append(temp).append("\n");
        System.out.println(temp);

        try {
            PrintStream ps = new PrintStream(new File("C:\\Users\\Max\\Desktop\\BattleRecord.txt"));
            PrintStream standard = System.out;
            System.setOut(ps);
            ps.print(battleRecord.toString());
            System.setOut(standard);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        droid1.setHealthAgain();
        droid2.setHealthAgain();
    }

    public void battleXvsX(ArrayList<Droid> team1, ArrayList<Droid> team2) throws InterruptedException {

        StringBuilder battleRecord = BattleArenaTeam.battleRecord;

        BattleArenaTeam arena = new BattleArenaTeam(team1, team2);
        ArrayList<Droid> winner = arena.startFight();
        String temp = "--------------";
        System.out.println(temp);
        battleRecord.append(temp).append("\n");
        temp = "The winners are " + winner;
        battleRecord.append(temp).append("\n");
        System.out.println(temp);

        try {
            PrintStream ps = new PrintStream(new File("C:\\Users\\Max\\Desktop\\BattleRecord.txt"));
            PrintStream standard = System.out;
            System.setOut(ps);
            ps.print(battleRecord.toString());
            System.setOut(standard);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (Droid droid: team1) {
            droid.setHealthAgain();
        }
        for (Droid droid: team2) {
            droid.setHealthAgain();
        }
    }

}
