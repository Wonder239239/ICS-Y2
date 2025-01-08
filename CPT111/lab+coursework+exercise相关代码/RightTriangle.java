import java.util.Scanner;

public class RightTriangle {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        
        if(a<=0||b<=0||c<=0){
            System.out.println("false");
        }
        else{
            if(a*a+b*b==c*c||a*a+c*c==b*b||b*b+c*c==a*a){
                System.out.println("true");
            }
            else{
                System.out.println("false");
            }
        }
    }
}
