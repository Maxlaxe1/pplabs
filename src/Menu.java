import droid.BigDroid;
import droid.Droid;
import droid.NinjaDroid;
import droid.SuperDroid;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private List<Droid> droidList = new ArrayList<>();

    public List<Droid> getDroidList() {
        return droidList;
    }

    public void setDroidList(List<Droid> droidList) {
        this.droidList = droidList;
    }

    public void consoleMenu() throws InterruptedException {
        System.out.println("\n0. Exit\n" +
                           "1. Create new droid\n" +
                           "2. Show the list of droids\n" +
                           "3. Start battle 1vs1\n" +
                           "4. Start battle 2vs2\n" +
                           "5. Start battle 3vs3\n" +
                           "6. Play record of last battle\n");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while(true){
            if (choice == 0){
                break;
            }
            switch(choice){
                case 1: createDroid(); break;
                case 2: showCreatedDroids(); break;
                case 3:
                    System.out.println("Choose 2 droids for battle: \n");
                    showCreatedDroids();
                    System.out.println("Choose first droid: ");
                    int droid1Num = scanner.nextInt();
                    System.out.println("Choose second droid:");
                    int droid2Num = scanner.nextInt();
                    Droid droid1 = getDroidList().get(--droid1Num);
                    Droid droid2 = getDroidList().get(--droid2Num);
                    new DroidBattle().battle(droid1, droid2);
                    break;
                case 4:
                    System.out.println("Choose 4 droids for battle: \n");
                    showCreatedDroids();
                    ArrayList<Droid> team1 = new ArrayList<>();
                    ArrayList<Droid> team2 = new ArrayList<>();
                    int[] team1Indx = new int[2];
                    int[] team2Indx = new int[2];
                    for (int i = 0; i < 4; i++){
                        if (i < 2){
                            System.out.println("Choose " + (i+1) + " droid: ");
                            team1Indx[i] = scanner.nextInt();
                            team1.add(getDroidList().get(--team1Indx[i]));
                        } else {
                            System.out.println("Choose " + (i+1) + " droid: ");
                            team2Indx[i-2] = scanner.nextInt();
                            team2.add(getDroidList().get(--team2Indx[i-2]));
                        }
                    }
                    new DroidBattle().battleXvsX(team1, team2);
                    break;
                case 5:
                    System.out.println("Choose 6 droids for battle: \n");
                    showCreatedDroids();
                    ArrayList<Droid> team11 = new ArrayList<>();
                    ArrayList<Droid> team22 = new ArrayList<>();
                    int[] team11Indx = new int[3];
                    int[] team22Indx = new int[3];
                    for (int i = 0; i < 6; i++){
                        if (i < 3){
                            System.out.println("Choose " + (i+1) + " droid: ");
                            team11Indx[i] = scanner.nextInt();
                            team11.add(getDroidList().get(--team11Indx[i]));
                        } else {
                            System.out.println("Choose " + (i+1) + " droid: ");
                            team22Indx[i-3] = scanner.nextInt();
                            team22.add(getDroidList().get(--team22Indx[i-3]));
                        }
                    }
                    new DroidBattle().battleXvsX(team11, team22);
                    break;
                case 6:
                    try {
                        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Max\\Desktop\\BattleRecord.txt"));
                        String line = in.readLine();
                        while(line != null)
                        {
                            System.out.println(line);
                            line = in.readLine();
                        }
                        in.close();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                default: consoleMenu();
            }
            consoleMenu();
        }

    }

    public Droid createDroid(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of droid:");
        String name = scanner.next();
        System.out.println("Choose the type of droid:");
        Droid droid = showTypesOfDroid(name);
        droidList.add(droid);

        return droid;
    }

    public Droid showTypesOfDroid (String name) {
        System.out.println("1. Base Droid");
        System.out.println("2. Super Droid");
        System.out.println("3. Ninja Droid");
        System.out.println("4. Big Droid");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1: return new Droid(name);
            case 2: return new SuperDroid(name);
            case 3: return new NinjaDroid(name);
            case 4: return new BigDroid(name);
            default:
                System.out.println("Something went wrong, Base Droid was created");
                return new Droid(name);
        }
    }
    public void showCreatedDroids (){
        int i = 1;
        for (Droid droid : getDroidList()) {
            System.out.println(i + " " + droid);
            i++;
        }
    }


}
