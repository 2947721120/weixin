
package com.yihou.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Description: 时间工具类
 * author yupan@18551
 * date 2016-10-07 16:43
 */
public class DateUtil {

    /**
     * 日期天数加减
     *
     * @param time 基准时间
     * @param day  需要加减的天数
     * @return 加减后的日期
     */
    public static Date addDay(Date time, int day) {

        if (time == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();

    }

    public static void main(String[] args) {
        Date date = addDay(new Date(), -7);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simpleDateFormat.format(date));
    }

}
