import java.util.Scanner;

public class PandemicSpread {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int a = Integer.parseInt(input);
        input = scanner.nextLine();
        int b = Integer.parseInt(input);
        input = scanner.nextLine();
        int c = Integer.parseInt(input);
            
        int n=1;
        
        while(a<c){
            n+=1;
            a+=a*b;
        }

        System.out.println(n);
    }
}
