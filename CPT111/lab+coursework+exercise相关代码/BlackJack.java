import java.util.Scanner;

public class BlackJack {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        if(a<=21&&b<=21){
            System.out.println((a>b?a:b));
        }
        if(a>21&&b>21){
            System.out.println("-1");
        }
        if(a<=21&&b>21||a>21&&b<=21){
            System.out.println((a>b?b:a));
        }

    }
}