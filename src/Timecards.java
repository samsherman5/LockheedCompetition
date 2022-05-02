import java.util.Scanner;

public class Timecards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int iterations = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < iterations; i++) {
            String[] line = scan.nextLine().split(",");
            String name = line[0];
            //Take time in HH:MM format
            String time = line[1];
            int hours = Integer.parseInt(time.substring(0, 2));
            int minutes = Integer.parseInt(time.substring(3, 5));
            int totalMinutes = hours * 60 + minutes;
            //Take time in HH:MM format
            String time2 = line[2];
            int hours2 = Integer.parseInt(time2.substring(0, 2));
            int minutes2 = Integer.parseInt(time2.substring(3, 5));
            int totalMinutes2 = hours2 * 60 + minutes2;
            String time3 = line[3];
            int hours3 = Integer.parseInt(time3.substring(0, 2));
            int minutes3 = Integer.parseInt(time3.substring(3, 5));
            int totalMinutes3 = hours3 * 60 + minutes3;
            String time4 = line[4];
            int hours4 = Integer.parseInt(time4.substring(0, 2));
            int minutes4 = Integer.parseInt(time4.substring(3, 5));
            int totalMinutes4 = hours4 * 60 + minutes4;
            String time5 = line[5];
            int hours5 = Integer.parseInt(time5.substring(0, 2));
            int minutes5 = Integer.parseInt(time5.substring(3, 5));
            int totalMinutes5 = hours5 * 60 + minutes5;
            int totalMinutesTotal = totalMinutes + totalMinutes2 + totalMinutes3 + totalMinutes4 + totalMinutes5;
            int hoursTotal = totalMinutesTotal / 60;
            int minutesTotal = totalMinutesTotal % 60;
            boolean hourplural = false;
            boolean minuteplural = false;
            boolean omitminutes = false;
            if (hoursTotal > 1) {
                hourplural = true;
            }
            if (minutesTotal > 1) {
                minuteplural = true;
            }
            if(minutesTotal == 0){
                omitminutes = true;
            }
            if(omitminutes){
                //print hours
                System.out.println(name + "=" + hoursTotal + " hour" + (hourplural ? "s" : ""));
            } else
                System.out.println(name + "=" + hoursTotal + " hour" + (hourplural ? "s" : "") + " " + minutesTotal + " minute" + (minuteplural ? "s" : "") );
        }
    }
}
