import java.util.Scanner;

public class DateToDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int y = Integer.parseInt(input);
        input = scanner.nextLine();
        int m = Integer.parseInt(input);
        input = scanner.nextLine();
        int d = Integer.parseInt(input);
        int a = y - (14- m) / 12;
        int b = a + a/4- a/100 + a/400;
        int c = m + 12 * ((14- m) / 12) - 2;
        int day = (d + b + 31 * c / 12) % 7;
        System.out.println("It's day " + day + " !");
    }   
}
