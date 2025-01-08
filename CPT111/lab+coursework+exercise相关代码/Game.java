import java.util.Scanner;

public class Game {
    private int round;
    private String[] num1;
    private String[] num2;
    private int m1, c1, m2, c2;

    // 初始化
    public Game() {
        initializeGame();
    }

    // 初始化游戏状态
    private void initializeGame() {
        this.m1 = 3;
        this.c1 = 3;
        this.m2 = 0;
        this.c2 = 0;
        this.round = 1;
        this.num1 = new String[6];
        this.num2 = new String[6];

        for (int i = 0; i < m1; i++) {
            num1[i] = "M";
        }
        for (int i = m1; i < m1 + c1; i++) {
            num1[i] = "C";
        }

        for (int i = 0; i < 6; i++) {
            num2[i] = " ";
        }
    }

    public void begin() {
        System.out.println("Crossing the river");
        System.out.println("==================================================");
        System.out.println("Round " + round);

        System.out.println("Left" + "         Right");
        for (int i = 0; i < 6; i++) {
            System.out.print(num1[i]);
        }
        for (int i = 0; i < 7; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < 6; i++) {
            System.out.print(num2[i]);
        }
        System.out.println();
        if (round % 2 == 1) System.out.println("Boat->");
        if (round % 2 == 0) System.out.println("             <-Boat");

    }

    private boolean movePassenger(String input) {
        if (input.equals("c")) {
            if (round % 2 == 1) {
                if (c1 > 0) {
                    c1 -= 1;
                    c2 += 1;
                    updateArrays();
                    return true;
                } else {
                    System.out.println("Illegal input!");
                    return false;
                }
            } else {
                if (c2 > 0) {
                    c2 -= 1;
                    c1 += 1;
                    updateArrays();
                    return true;
                } else {
                    System.out.println("Illegal input!");
                    return false;
                }
            }
        }

        if (input.equals("m")) {
            if (round % 2 == 1) {
                if (m1 > 0) {
                    m1 -= 1;
                    m2 += 1;
                    updateArrays();
                    return true;
                } else {
                    System.out.println("Illegal input!");
                    return false;
                }
            } else {
                if (m2 > 0) {
                    m2 -= 1;
                    m1 += 1;
                    updateArrays();
                    return true;
                } else {
                    System.out.println("Illegal input!");
                    return false;
                }
            }
        }

        System.out.println("Illegal input!");
        return false;
    }

    private void updateArrays() {
        for (int i = 0; i < m1; i++) num1[i] = "M";
        for (int i = m1; i < m1 + c1; i++) num1[i] = "C";
        for (int i = m1 + c1; i < 6; i++) num1[i] = " ";
        for (int i = 0; i < m2; i++) num2[i] = "M";
        for (int i = m2; i < m2 + c2; i++) num2[i] = "C";
        for (int i = m2 + c2; i < 6; i++) num2[i] = " ";
    }

    private void first(Scanner scanner) {
        boolean validInput = false;
        while (!validInput) {
            System.out.print("First passenger ('c' for cannibal, 'm' for missionary): ");
            String input = scanner.nextLine();
            validInput = movePassenger(input);
        }
    }

    private void second(Scanner scanner) {
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Second passenger ('c' for cannibal, 'm' for missionary, 'n' for none): ");
            String input = scanner.nextLine();
            if (input.equals("n")) {
                validInput = true;
            } else {
                validInput = movePassenger(input);
            }
        }
        this.round += 1;
        System.out.println("==================================================");
    }

    private void success() {
        if ((c1 > m1 && m1 > 0) || (c2 > m2 && m2 > 0)) {
            System.out.println(" !! !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! !!");
            System.out.println(" !! Missionaries eaten by cannibals! You lose! !!");
            System.out.println(" !! !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! !!");
            initializeGame();
            return;
        }
        if (c2 == 3 && m2 == 3) {
            System.out.println("** Congratulations! You win the game in " + round + " rounds!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Game mygame = new Game();
        while (true) {
            mygame.begin();
            mygame.first(scanner);
            mygame.second(scanner);
            mygame.success();
            if (mygame.c2 == 3 && mygame.m2 == 3) break;
        }

        scanner.close();
    }
}

