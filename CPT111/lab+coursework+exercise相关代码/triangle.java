public class triangle {
    public static void coursework1(int i,int j, int k){
        if(Math.abs(i-j)<k &&Math.abs(i-k)<j&& Math.abs(k-j)<i){
            System.out.println("true");
        }
        else System.out.println("false");
    }


    public static void main(String[] args) {
        coursework1(3, 4, 5);
    }
}
