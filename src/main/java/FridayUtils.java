import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class FridayUtils {

    /**
     * Find the date of the last Friday the 13th before the given parameter.
     * Go back one by one to find that.
     * If the given parameter is a 13th Friday, return it.
     *
     * @param aDate
     * @return
     */
    public static LocalDate findPreviousFriday13th(LocalDate aDate) {
        // TODO
        LocalDate date = LocalDate.now();
        return date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));

    }

    /**
     * Return the number of friday 13ths in a given year.
     * Simply count the friday 13ths starting from Jan 1st until Dec 31st in that given year.
     *
     * @param year
     * @return
     */
    public static int howManyFriday13ths(int year) {
        // TODO
        try{
            String dateString = "01/13/"+ year;
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date date = dateFormat.parse(dateString);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);

            int counter = 0;
            int months = 0;
            while(months++ <= 12){
                if(Calendar.FRIDAY == cal.get(Calendar.DAY_OF_WEEK)){
                    counter++;
                }
                cal.add(Calendar.MONTH, 1);
            }

            System.out.println("Number of Fridays on 13th = "+ counter);



        }
        catch(ParseException e){

        }

        return 0;


    }

}
