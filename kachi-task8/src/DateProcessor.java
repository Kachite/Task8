import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;

public class DateProcessor {
    private int[] daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public ArrayList<ArrayList<String>> GetCalendar(int month, int year) {
        ArrayList<ArrayList<String>> calender = new ArrayList<ArrayList<String>>();
        YearMonth ym = YearMonth.of(year, month);

        int dayValue = LocalDate.of(year, month, 1).getDayOfWeek().getValue();
        var week = new ArrayList<String>();
        int counter = FillPreviousMonthDays(dayValue, week, month);

        var lengthOfMonth = ym.getMonth().length(CheckIfLeapYear(year));
        for (int i = 1; i <= lengthOfMonth; i++, counter++) {
            var day = "" + i;
            week.add(day);

            // Break the line if the value of the counter is multiple of 7
            if (counter % 7 == 0) {
                calender.add(week);
                week = new ArrayList<String>();  // reset the week
            }
        }

        var lastWeekLength = week.size();
        FillNextMonthDays(lastWeekLength, week);

        calender.add(week); // add last week

        return calender;
    }

    private boolean CheckIfLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    private int FillPreviousMonthDays(int dayValue, ArrayList<String> week, int month) {
        int counter = 1;
        int previousMonth = month - 1;
        int lengthOfPreviousMonth = this.daysOfMonth[previousMonth];

        if (dayValue != 7) {
            for (int i = dayValue - 1; i > 0; i--, counter++) {
                week.add("" + (lengthOfPreviousMonth - i + 1));
            }
        }

        return counter;
    }

    private void FillNextMonthDays(int weekLength, ArrayList<String> week) {
        int newDays = 0;
        if (weekLength != 7) {
            for (int i = weekLength; i < 7; i++) {
                week.add("" + ++newDays);
            }
        }
    }
}
