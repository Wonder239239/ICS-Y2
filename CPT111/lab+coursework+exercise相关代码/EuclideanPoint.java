/*
 * CW1 Week #6
 */
class DistanceToException extends RuntimeException {
	
    public DistanceToException(String message) {
        super(message);
    }
	
}
public class EuclideanPoint {
    private double x;
    private double y;
    
    public EuclideanPoint(double x, double y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Negative input detected");
        }
        this.x = x;
        this.y = y;
    }
    
    public EuclideanPoint() {
        this(0.0, 0.0);
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }

    // CW1 #6.1 SET COORDINATES
    public void setCoordinates(double x, double y) {
		this.x=x;
        this.y=y;
    }

    // CW1 #6.2 DISTANCE TO
    public double distanceTo(EuclideanPoint otherPoint) {
        double distance=Math.sqrt(Math.pow(this.x-otherPoint.x, 2)+Math.pow(this.y-otherPoint.y, 2));
        if(distance==0){
            throw new DistanceToException("Zero distance detected");
        }
		return distance;
    }

    public static void main(String[] args) {
        // Creating two instances of EuclideanPoint
        EuclideanPoint point1 = new EuclideanPoint(3.5, 5.2);
        EuclideanPoint point2 = new EuclideanPoint();

        // Setting coordinates of point 2 via instance method
        System.out.println(point2.getX());
        System.out.println(point2.getY());
        point2.setCoordinates(7.0, 8.5);
        System.out.println(point2.getX());
        System.out.println(point2.getY());

        // Calculating and displaying the distance between the points
        double distance = point1.distanceTo(point2);
        System.out.println("Distance between Point 1 and Point 2: " + distance);
    }

}
