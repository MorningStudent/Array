import java.util.Scanner;

public class WeeklyTempsApp {
    public static void main(String[] args) {
        
        int[] weeklyTemps = { 0, 0, 0, 0, 0, 0, 0 };


        Scanner in = new Scanner(System.in);

        for (int i = 0; i < weeklyTemps.length; i++) {
            System.out.println("Insert a temperature for " + ( i + 1 ) + " day of the week:");
            weeklyTemps[i] = in.nextInt();
        }

        System.out.println("Recorded: " + weeklyTemps.length + " temperatures");

        for (int i = 0; i < ( weeklyTemps.length - 2 ); i++) {
            System.out.println(weeklyTemps[i]);
        }
    }
}