package battle;

import droid.Droid;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BattleArenaTeam {
    private Droid attacker;
    private Droid defender;


    private ArrayList<Droid> team1;
    private ArrayList<Droid> team2;
    public static StringBuilder battleRecord = new StringBuilder();
    private int currentRound = 0;


    public BattleArenaTeam(ArrayList<Droid> team1, ArrayList<Droid> team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public ArrayList<Droid> getTeam1() {
        return team1;
    }

    public void setTeam1(ArrayList<Droid> team1) {
        this.team1 = team1;
    }

    public ArrayList<Droid> getTeam2() {
        return team2;
    }

    public void setTeam2(ArrayList<Droid> team2) {
        this.team2 = team2;
    }

    public static boolean hasAlivePlayer(ArrayList<Droid> team){
        for (int i = 0; i < team.size(); i++){
            if(team.get(i).isAlive()){
                return true;
            }
        }
        return false;
    }
    public ArrayList<Droid> startFight() throws InterruptedException {
        do {
            prepareRound();
            int actualDamage = doFight();
            printRoundInfo(actualDamage);

            TimeUnit.SECONDS.sleep(1);
        } while (hasAlivePlayer(team1) && hasAlivePlayer(team2));

        if(hasAlivePlayer(team1)) {return team1;} else {
            return team2;
        }
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
        int min = 0;
        int numberOfPlayers = getTeam1().size() - 1;

        Random random = new Random();

        if (random.nextBoolean()) {
            while (true){
                int playerNum1 = random_player(numberOfPlayers, min);
                if(team1.get(playerNum1).isAlive()){attacker = team1.get(playerNum1); break;}
                System.out.println(attacker);
            }
            while (true){
                int playerNum2 = random_player(numberOfPlayers, min);
                if(team2.get(playerNum2).isAlive()){defender = team2.get(playerNum2); break;}
            }
        } else {
            while (true){
                int playerNum1 = random_player(numberOfPlayers, min);
                if(team1.get(playerNum1).isAlive()){defender = team1.get(playerNum1); break;}
            }
            while (true){
                int playerNum2 = random_player(numberOfPlayers, min);
                if(team2.get(playerNum2).isAlive()){attacker = team2.get(playerNum2); break;}
            }
        }
    }

    public int random_player(int numberOfPlayers, int min) {
        return (int)Math.floor(Math.random()*(numberOfPlayers-min+1)+min);
    }
}
