package pl.tomasik.holidayhouse.utils;

import java.time.LocalDate;

/**
 * Class used for comparing dates
 */
public class CompareDateUtils {

    public static boolean isDateBetweenRange(LocalDate startDateFromParam, LocalDate startDate, LocalDate endDate) {
        return isDateGreaterThenOrEqual(startDateFromParam, startDate) && isDateLessThanOrEqual(startDateFromParam, endDate);
    }

    public static boolean isDateLessThanOrEqual(LocalDate firstDate, LocalDate secondDate) {
        return firstDate.compareTo(secondDate) <= 0;
    }

    public static boolean isDateGreaterThenOrEqual(LocalDate firstDate, LocalDate secondDate) {
        return firstDate.compareTo(secondDate) >= 0;
    }
}
