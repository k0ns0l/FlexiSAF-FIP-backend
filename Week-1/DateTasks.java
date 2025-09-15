import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;

public class DateTasks {

    // length of each month for a given year
    public static void monthLengths(int year) {
        System.out.println("Month lengths for year " + year);
        for (Month month : Month.values()) {
            YearMonth ym = YearMonth.of(year, month);
            System.out.println("| " + month + ": " + ym.lengthOfMonth() + " days");
        }
        System.out.println();
    }

    // list all Mondays in a given month of current year
    public static void listMondays(Month month) {
        int year = Year.now().getValue();
        YearMonth ym = YearMonth.of(year, month);
        System.out.println("Mondays in " + month + " " + year + ":");
        for (int day = 1; day <= ym.lengthOfMonth(); day++) {
            LocalDate date = ym.atDay(day);
            if (date.getDayOfWeek() == DayOfWeek.MONDAY) {
                System.out.println("| " + date);
            }
        }
        System.out.println();
    }

    // Task 3: Test if a given date occurs on Friday the 13th
    public static void isFriday13(LocalDate date) {
        boolean result = date.getDayOfWeek() == DayOfWeek.FRIDAY && date.getDayOfMonth() == 13;
        System.out.println(date + " is Friday the 13th? \t" + result);
    }

    public static void main(String[] args) {
        // date #1 - days in each month
        monthLengths(2025);

        // date #2 - all Mondays in September
        listMondays(Month.SEPTEMBER);

        // date #3 - check for Friday the 13th correspondence
        isFriday13(LocalDate.of(2024, 9, 13)); // true
        isFriday13(LocalDate.of(2025, 10, 13)); // false
    }
}

