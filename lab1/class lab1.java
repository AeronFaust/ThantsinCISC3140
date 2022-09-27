package git.lab1;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

class lab1 
{
    public static void main (String[] args)
    {
        ZoneId EST = ZoneId.of("US/Eastern");
        ZonedDateTime current = ZonedDateTime.now(EST);

        System.out.println(DateTimeFormatter.ofPattern("MM/dd/yyyy - hh:mm").format(current));
    }
}