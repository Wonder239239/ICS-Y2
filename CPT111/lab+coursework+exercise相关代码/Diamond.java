public class Diamond {
    public static void diamond(int n){
        for(int i=0;i<n/2+1;i++){
            for(int j=0;j<(n-2*i-1)/2;j++){
                System.out.print(".");
            }
            for(int j=0;j<2*i+1;j++){
                System.out.print("*");
            }
            for(int j=0;j<(n-2*i-1)/2;j++){
                System.out.print(".");
            }
            System.out.println();
        }
        for (int i=n/2+1;i<n;i++){
            for(int j=0;j<i-n/2;j++){
                System.out.print(".");
            }
            for(int j=0;j<2*n-2*i-1;j++){
                System.out.print("*");
            }
            for(int j=0;j<i-n/2;j++){
                System.out.print(".");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        diamond(9);
        
    }
    
}
