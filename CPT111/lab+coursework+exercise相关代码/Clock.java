/*
 * Exercise Week #6
 */

public class Clock {
    private int hours;
    private int minutes;

    public int getHours(){
        return hours;
    }

    public int getMinutes(){
        return minutes; 
    }

    // Exercise #6.1
    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        int sum = h*60+m;
        this.hours=sum/60;
        this.minutes=sum%60;
        if(this.hours>24) this.hours%=24;
    }

    // Exercise #6.2
    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        hours = Integer.parseInt(s.substring(0, 2)); 
        minutes = Integer.parseInt(s.substring(3, 5)); 
    }

    // Exercise #6.3
    // Returns a string representation of this clock, using the format HH:MM.

    public String toString() {
        String a = "";
        String b = "";
        if(this.hours<10) a+="0"+this.hours;
        else a+=this.hours;
        if(this.minutes<10) b+="0"+ this.minutes;
        else b+=this.minutes;
        String c=a+":"+b;
        return  c;
    }

    // Exercise #6.4
    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if(this.minutes+this.hours*60<that.minutes+that.hours*60){
            return true;
        }
        return false;
      
    }

    // Exercise #6.5
    // Adds 1 minute to the time on this clock.
    public void tick() {
        int sum = 1+this.hours*60+this.minutes;
        this.hours=sum/60;
        this.minutes=sum%60;
        if(this.hours>=24) this.hours%=24;
    }

    // Exercise #6.6
    // Adds delta minutes to the time on this clock.
    public void tock(int delta) {
        int sum = delta+this.hours*60+this.minutes;
        this.hours=sum/60;
        this.minutes=sum%60;
        if(this.hours>=24) this.hours%=24;
 
    }

    // Test client
    public static void main(String[] args) {
        Clock clock1 = new Clock(1, 0);
        Clock clock2 = new Clock("02:30");
		
        System.out.println(clock1);
        System.out.println(clock2);
		
        System.out.println(clock1.isEarlierThan(clock2));
		
        clock1.tick();
        clock2.tock(100);
		
        System.out.println(clock1);
        System.out.println(clock2);
		
    }
}
