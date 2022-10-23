//Swann Thantsin
//CISC 3140
//Professor Katherine Chuang
//Due 9/28/2022
package git.lab1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task4
{
    public static void main (String[] args)
    {
        ZoneId EST = ZoneId.of("US/Eastern");
        ZonedDateTime current = ZonedDateTime.now(EST);
        LocalDate now = current.toLocalDate();
        LocalDate dateVal = current.toLocalDate();
        LocalDate compVal = current.toLocalDate();

        //Assigning Lab due Dates as LocalDate(YYYY-MM-DD) using string parses
        LocalDate lab1 = LocalDate.parse("2022-09-28");
        LocalDate lab2 = LocalDate.parse("2022-10-26");
        LocalDate lab3 = LocalDate.parse("2022-11-23");
        LocalDate lab4 = LocalDate.parse("2022-12-07");

        //Assigning Quiz Dates as LocalDate(YYYY-MM-DD)  using string parses
        LocalDate quiz1 = LocalDate.parse("2022-09-14");
        LocalDate quiz2 = LocalDate.parse("2022-09-28");
        LocalDate quiz3 = LocalDate.parse("2022-10-26");
        LocalDate quiz4 = LocalDate.parse("2022-11-16");
        LocalDate quiz5 = LocalDate.parse("2022-12-07");
        
        //Assigning Finals Date as LocalDate(YYYY-MM-DD)  using string parses
        LocalDate finals = LocalDate.parse("2022-12-19");

        //Initializing Custom Date variable as current time(YYYY-MM-DD) , which can be edited later.
        LocalDate custom = now;

        //Regex formats
        String format1 = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";         //MM/DD/YYYY format
        String format2 = "^(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$";                  //MM-DD format

        //Requests user input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter date(format: MM/DD/YYYY or MM-DD or leave empty for current date): ");
        String datetext = input.nextLine();

        //Regex to check inputs with formats for MM/DD/YYYY and MM-DD respectively
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        //Proper date flag
        boolean isDate = false;
        
        while(!isDate){          
            if(datetext.matches(format1)) {
                dateVal = LocalDate.parse(datetext, formatter1);
                isDate = true;
            } 
            else if(datetext.matches(format2)){
                String toconcat = "-" + DateTimeFormatter.ofPattern("yyyy").format(now);
                String newformat2 = datetext + toconcat;
                dateVal = LocalDate.parse(newformat2, formatter2);
                isDate = true;
            }
            else if(datetext.isEmpty()){
                isDate = true;
            }
            else{          
                System.out.println("Please enter a valid date format (MM/DD/YYYY or MM-DD or leave empty for current date): ");
                datetext = input.nextLine();
            }
        }

        if(isDate) {      
            boolean properChoice = false;
            System.out.println("Please choose a date to compare to: ");
            while (!properChoice)  
            {
                System.out.println("1. Assignment Due Dates.");
                System.out.println("2. Quiz Dates.");
                System.out.println("3. Finals Date.");
                System.out.println("4. Custom Date.");
                while (!input.hasNextInt()) {
                    System.out.println("Please enter a valid option");
                    System.out.println("1. Assignment Due Dates.");
                    System.out.println("2. Quiz Dates.");
                    System.out.println("3. Finals Date.");
                    System.out.println("4. Custom Date.");
                    input.next();
                }
                int choiceinput = input.nextInt();
    
                switch(choiceinput){
                    case 1:  
                        boolean properDateChoice = false;
                        while(!properDateChoice){
                            System.out.println("Please choose an Assignment Due Date");
                            System.out.println("1. Lab1 " + DateTimeFormatter.ofPattern("MM/dd/yyyy").format(lab1));
                            System.out.println("2. Lab2 " + DateTimeFormatter.ofPattern("MM/dd/yyyy").format(lab2));
                            System.out.println("3. Lab3 " + DateTimeFormatter.ofPattern("MM/dd/yyyy").format(lab3));
                            System.out.println("4. Lab4 " + DateTimeFormatter.ofPattern("MM/dd/yyyy").format(lab4));                
                            while (!input.hasNextInt()) {
                                System.out.println("Please enter a valid option");
                                System.out.println("1. Assignment Due Dates.");
                                System.out.println("2. Quiz Dates.");
                                System.out.println("3. Finals Date.");
                                System.out.println("4. Custom Date.");
                                input.next();
                            }
                            int dateChoice = input.nextInt();
                            switch(dateChoice){
                                case 1:
                                    compVal = lab1;
                                    properDateChoice = true;
                                    break;
                                case 2:
                                    compVal = lab2;
                                    properDateChoice = true;
                                    break;
                                case 3:
                                    compVal = lab3;
                                    properDateChoice = true;
                                    break;
                                case 4:
                                    compVal = lab4;
                                    properDateChoice = true;
                                    break;
                                default:
                                    System.out.println(dateChoice + " is not a valid option.");
                            }
                        }
                        properChoice = true;
                        break;
                    case 2:
                        boolean properDateChoice2 = false;
                        while(!properDateChoice2){
                            System.out.println("Please choose a Quiz Date");
                            System.out.println("1. Quiz1 " + DateTimeFormatter.ofPattern("MM/dd/yyyy").format(quiz1));
                            System.out.println("2. Quiz2 " + DateTimeFormatter.ofPattern("MM/dd/yyyy").format(quiz2));
                            System.out.println("3. Quiz3 " + DateTimeFormatter.ofPattern("MM/dd/yyyy").format(quiz3));
                            System.out.println("4. Quiz4 " + DateTimeFormatter.ofPattern("MM/dd/yyyy").format(quiz4));  
                            System.out.println("5. Quiz5 " + DateTimeFormatter.ofPattern("MM/dd/yyyy").format(quiz5));                
                            while (!input.hasNextInt()) {
                                System.out.println("Please enter a valid option");
                                System.out.println("1. Assignment Due Dates.");
                                System.out.println("2. Quiz Dates.");
                                System.out.println("3. Finals Date.");
                                System.out.println("4. Custom Date.");
                                input.next();
                            }
                            int dateChoice = input.nextInt();
                            switch(dateChoice){
                                case 1:
                                    compVal = quiz1;
                                    properDateChoice2 = true;
                                    break;
                                case 2:
                                    compVal = quiz2;
                                    properDateChoice2 = true;
                                    break;
                                case 3:
                                    compVal = quiz3;
                                    properDateChoice2 = true;
                                    break;
                                case 4:
                                    compVal = quiz4;
                                    properDateChoice2 = true;
                                    break;
                                case 5:
                                    compVal = quiz5;
                                    properDateChoice2 = true;
                                    break;
                                default:
                                    System.out.println(dateChoice + " is not a valid option.");
                            }
                        }
                        properChoice = true;
                        break;
                    case 3:
                        compVal = finals;
                        properChoice = true;
                        break;
                    case 4:
                        Scanner inputcustom = new Scanner(System.in);

                        System.out.print("Please enter a date to compare to(MM/DD/YYYY or MM-DD or leave empty for current date): ");
                        String customdatetext = inputcustom.nextLine();
                    
                        boolean isCustomDate = false;
                        while(!isCustomDate){          
                            if(customdatetext.matches(format1)) {
                                custom = LocalDate.parse(customdatetext, formatter1);
                                isCustomDate = true;
                            } 
                            else if(customdatetext.matches(format2)){
                                String toconcatcustom = "-" + DateTimeFormatter.ofPattern("yyyy").format(now);
                                String customtestformat = customdatetext + toconcatcustom;
                                LocalDate customtestdate = LocalDate.parse(customtestformat, formatter2);
                                boolean isBefore = customtestdate.isBefore(now);
                                if (isBefore) {
                                    customtestdate = customtestdate.plusYears(1);
                                }
                                custom = customtestdate;
                                isCustomDate = true;
                            }
                            else{          
                                System.out.print("Please enter a valid date format (MM/DD/YYYY or MM-DD or leave empty for current date): ");
                                customdatetext = inputcustom.nextLine();
                            }
                        }
                        compVal = custom;
                        properChoice = true;
                        break;
                    default:
                        System.out.println(choiceinput + " is not a valid option.");
                }
            }
        }
        System.out.println("Current Date: " + DateTimeFormatter.ofPattern("MM/dd/yyyy").format(dateVal));
        System.out.println("Date to Compare: " + DateTimeFormatter.ofPattern("MM/dd/yyyy").format(compVal));
    }
}