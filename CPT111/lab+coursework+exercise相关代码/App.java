class Car{
    int speed;
    String name;

    public Car(int speed, String name) {
        this.speed = speed;
        this.name = name;
    }

    
    public int nowspeed(){
        return this.speed;
    }

    public void addspeed(){
        this.speed+=20;
    }

}
public class App {   
    public static void main(String[] args) throws Exception {
        Car car1 = new Car(222, "cqq");
        car1.addspeed();
        System.err.println(car1.speed);
        System.out.println("Hello, World!");
        
    }
}
