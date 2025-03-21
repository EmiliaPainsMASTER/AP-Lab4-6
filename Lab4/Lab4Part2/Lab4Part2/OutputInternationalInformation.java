package Lab4Part2;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class OutputInternationalInformation {
    public static void main(String[] args) {
        Locale britishLocale = new Locale("en","UK");
        Locale americanLocale = new Locale("en","US");
        Locale germanLocale = new Locale("de");
        Locale frenchLocale = new Locale("fr", "FR");
        displayLocalizedInformation(britishLocale);
        displayLocalizedInformation(americanLocale);
        displayLocalizedInformation(germanLocale);
        displayLocalizedInformation(frenchLocale);
    }
    public static void printDivider(){
        for(int count = 0; count<40; count++){
            System.out.print("-");
        }
        System.out.println();
    }
    public static void displayLocalizedInformation(Locale locale){
        printDivider();
        System.out.println("Displaying Locale: " +locale.getDisplayName());
        printDivider();
        //print days of the week
        DateFormatSymbols localizedCalendar = new DateFormatSymbols(locale);
        String[] localWeekdays = localizedCalendar.getWeekdays();
        System.out.println("Days of the week in: " +locale.getDisplayName());
        printDivider();
        for(int increment = 0; increment < localWeekdays.length; increment++){
            System.out.println(localWeekdays[increment]);
        }
        printDivider();
        //print months of the year
        String []localMonths = localizedCalendar.getMonths();
        System.out.println("Months of the year in: " +locale.getDisplayName());
        printDivider();
        for(int increment = 0; increment < localMonths.length; increment++){
            System.out.println(localMonths[increment]);
        }
        //print localized number format
        NumberFormat localizedCurrencyFormat = NumberFormat.getCurrencyInstance(locale);
        double n = 10000.50;
        printDivider();
        System.out.println("Localized Currency: " + localizedCurrencyFormat.format(n));
        printDivider();
        //short date
        DateFormat shortDate = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        Date today = new Date();
        System.out.println("Today is: " + shortDate.format(today));
        printDivider();

        // user selection
        Calendar firstWeekday = Calendar.getInstance(locale);
        int localizedFirstDay = firstWeekday.getFirstDayOfWeek();
        System.out.println("First day of the week in: " + locale.getDisplayName());
        System.out.println(localWeekdays[localizedFirstDay]);
        printDivider();
    }
}