import java.util.Random;
import java.util.Scanner;

public class MasterMind {
    private int[] computer=new int[4];
    private int[] guess=new int[4];
    public int round;
    public int a;
    public int b;


    public MasterMind(int computer1,int computer2,int computer3,int computer4){
        computer[0]=computer1;
        computer[1]=computer2;
        computer[2]=computer3;
        computer[3]=computer4;
        round=1;
        this.a=0;
        this.b=0;

    }

    public void extractNumbers(String input) {
        String[] parts = input.split(" ");
        
        for (int i = 0; i < parts.length; i++) {
            guess[i] = Integer.parseInt(parts[i]);
        }
    }


    public boolean validateInput(String input) {
        String[] parts = input.split(" ");
        if (parts.length != 4) {
            return false;
        }
        for (String part : parts) {
            if (part.length() != 1 || part.charAt(0) < '1' || part.charAt(0) > '6') {
                return false;
            }
        }
        return true;
    }

    public void run(Scanner scanner) {
        String input;
        while (true) {
            System.out.println("Round " + round);
            System.out.print("Enter guess: ");
            input = scanner.nextLine();
            if (validateInput(input)) {
                break;
            } else {
                System.out.println("Input format error. Please enter four digits (1-6) separated by a space.");
            }
        }
        extractNumbers(input);
        check();
    }
    
    public void check() {
        a = 0;
        b = 0;
        boolean[] computerMatched = new boolean[4];
        boolean[] guessMatched = new boolean[4];

       
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == computer[i]) {
                a += 1;
                computerMatched[i] = true;
                guessMatched[i] = true;
            }
        }

        
        for (int i = 0; i < guess.length; i++) {
            if (!guessMatched[i]) {
                for (int j = 0; j < computer.length; j++) {
                    if (!computerMatched[j] && guess[i] == computer[j]) {
                        b += 1;
                        computerMatched[j] = true;
                        break;
                    }
                }
            }
        }

        System.out.print("Clues: ");
        for(int i=0;i<a;i++){
            System.out.print("O ");
        }
        for(int i=0;i<b;i++){
            System.out.print("# ");
        }
        System.out.println();
        System.out.println(" ===========================================================");
        round+=1;
        if(a==4) System.out.println(" Congrutulations! You win in "+round+" steps!");

    }
    public static void main(String[] arguments) {
        System.out.println("MasterMind");
        // initialize random number generator
        Random random = new Random(System.currentTimeMillis());
        // pick random values between 1 and 6
        int computer1 = random.nextInt(6) + 1;
        int computer2 = random.nextInt(6) + 1;
        int computer3 = random.nextInt(6) + 1;
        int computer4 = random.nextInt(6) + 1;
        // rest of program

        Scanner scanner = new Scanner(System.in);

        MasterMind myMasterMind=new MasterMind(computer1, computer2, computer3, computer4);
        System.out.println(" Enter four digits (1-6) separated by a space");
        System.out.println(" ============================================================");

        while(true){
            myMasterMind.run(scanner);
            if(myMasterMind.a==4) break;


        }
        scanner.close();

    

    }
}