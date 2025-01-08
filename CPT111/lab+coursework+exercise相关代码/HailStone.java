import java.util.Scanner;

public class HailStone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int i = Integer.parseInt(input);
        int num=1;
        while(i!=1){
            if(i%2==0){
                i=i/2;
                num++;
            }
            else{
                i=3*i+1;
                num++;
            }
        }
        System.out.println(num);
    }   
}

