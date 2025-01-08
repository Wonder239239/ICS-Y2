import java.util.Scanner;



public class Harmonicnumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = Integer.parseInt(input);
        double sum=0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        System.out.println(sum);
}
}