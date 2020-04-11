package com.yhmpc.movie.crawler;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author yhm
 * @Date 4/11/2020 19:08
 */
public class DateUtil {

    public static Date string2Date(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        try {
            Date date = sdf.parse(dateString);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
