//Swann Thantsin
//CISC 3140
//Professor Katherine Chuang
//Due 9/28/2022
package git.lab1;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class lab1 
{
    public static void main (String[] args)
    {
        ZoneId EST = ZoneId.of("US/Eastern");
        ZonedDateTime current = ZonedDateTime.now(EST);
        LocalDateTime now = current.toLocalDateTime();

        LocalDateTime lab1 = LocalDateTime.parse("2022-09-28T15:30:00");
        LocalDateTime lab2 = LocalDateTime.parse("2022-10-26T15:30:00");
        LocalDateTime lab3 = LocalDateTime.parse("2022-11-23T15:30:00");
        LocalDateTime lab4 = LocalDateTime.parse("2022-12-07T15:30:00");

        long diff1 = ChronoUnit.SECONDS.between(now, lab1);
        long diff2 = ChronoUnit.SECONDS.between(now, lab2);
        long diff3 = ChronoUnit.SECONDS.between(now, lab3);
        long diff4 = ChronoUnit.SECONDS.between(now, lab4);

        System.out.println("Current Time: " + DateTimeFormatter.ofPattern("MM/dd/yyyy - hh:mm").format(now));

        System.out.println("\nLab 1 Due Date: " + DateTimeFormatter.ofPattern("MM/dd/yyyy - hh:mm").format(lab1));
        System.out.print("Time Until Due Date for Lab 1: ");
        if (diff1 < 0)
            System.out.println("Passed.");
        else
            System.out.println((diff1/(24*60*60))/7 + " Week(s) " + (diff1/(24*60*60))%7 + " Day(s).");

        System.out.println("\nLab 2 Due Date: " + DateTimeFormatter.ofPattern("MM/dd/yyyy - hh:mm").format(lab2));
        System.out.print("Time Until Due Date for Lab 2: ");
        if (diff2 < 0)
            System.out.println("Passed.");
        else
            System.out.println((diff2/(24*60*60))/7 + " Week(s) " + (diff2/(24*60*60))%7 + " Day(s).");

        System.out.println("\nLab 3 Due Date: " + DateTimeFormatter.ofPattern("MM/dd/yyyy - hh:mm").format(lab3));
        System.out.print("Time Until Due Date for Lab 3: ");
        if (diff3 < 0)
            System.out.println("Passed.");
        else
            System.out.println((diff3/(24*60*60))/7 + " Week(s) " + (diff3/(24*60*60))%7 + " Day(s).");

        System.out.println("\nLab 4 Due Date: " + DateTimeFormatter.ofPattern("MM/dd/yyyy - hh:mm").format(lab4));
        System.out.print("Time Until Due Date for Lab 4: ");
        if (diff4 < 0)
            System.out.println("Passed.");
        else
            System.out.println((diff4/(24*60*60))/7 + " Week(s) " + (diff4/(24*60*60))%7 + " Day(s).");
    }
}