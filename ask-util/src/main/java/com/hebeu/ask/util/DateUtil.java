package com.hebeu.ask.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : chenDeHua
 * Time   : 2018/5/8 下午5:20
 * Desc   :
 **/
public class DateUtil {

    public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";

    public static final String yyyy_MM_dd = "yyyy-MM-dd";

    /**
     * 将时间date类型转换为String类型
     *
     * @param pattern 时间格式
     * @param date    日期类型
     * @return 返回字符串类型时间
     */
    public static String dateToString(String pattern, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
}
