import java.util.Scanner;
public class baseballClient {
    public static void processInput(String input, Player player){
        if (input.equals("sim AB")){
            player.atBat();
        }
        else if (input.equals("sim attempt")){
            player.simAttempt();
        }
        else if (input.equals("sim game")){
            player.simGame();
        }
        else if (input.equals("sim season")){
            player.simSeason();
        }
        else if (input.equals("check stats")){
            System.out.println(player.checkStats());
        }
    }
    public static void tests() {
        Player testPlayer = new Player(100, 10, 5, 5, 10, 5, 100);
        testPlayer.update();
        System.out.println(testPlayer.checkStats()); // .300 AVG, .750 SLG, 10 single, 5 double, 5 triple, 10 homers, 5 errors, 100 attempts, .950 fielding
        testPlayer.atBat();
        testPlayer.simAttempt();
        testPlayer.update();
        System.out.println(testPlayer.checkStats()); //ABs should be 101, attempts should be 101
        testPlayer.simGame();
        testPlayer.update();
        System.out.println(testPlayer.checkStats()); // ABs should be 105, attempts should be 107
        testPlayer.simSeason();
        testPlayer.update();
        System.out.println(testPlayer.checkStats()); // ABs should be 753, attempts should be 1079

    }
        public static void main(String[] args) {
 //       tests();
        Scanner scan = new Scanner(System.in);
        System.out.println("Input the following stats");
        System.out.println("at bats:");
        int atBats = scan.nextInt();
        System.out.println("singles:");
        int singles = scan.nextInt();
        System.out.println("doubles:");
        int doubles = scan.nextInt();
        System.out.println("triples:");
        int triples = scan.nextInt();
        System.out.println("homers:");
        int homers = scan.nextInt();
        System.out.println("errors:");
        int errors = scan.nextInt();
        System.out.println("attempts:");
        int att = scan.nextInt();
        Player player = new Player(atBats,singles,doubles,triples,homers,errors,att);
        player.update();
        String input=scan.nextLine();
        while (!(input.equals("retire"))) {
            player.update();
            System.out.println("What do you want to do next? (sim AB/sim attempt/sim game/sim season/check stats/retire)");
            input=scan.nextLine();
            processInput(input,player);
        }
    }
}
