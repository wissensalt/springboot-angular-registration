package com.wissensalt.test.sar.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DateUtil {

    public static SimpleDateFormat BirthDateFormatter = new SimpleDateFormat("dd-MM-yyyy");

    public static Date addNYearToDate(int n, Date p_PrevDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(p_PrevDate);
        c.add(Calendar.YEAR, n);
        return c.getTime();
    }
}
