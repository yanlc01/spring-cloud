package com.cloud.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 时间处理
 */
public class DateTools {
    // 常用日期输出格式
    public final static String YYYYMMDD = "yyyyMMdd";
    public final static String YYYYMM = "yyyyMM";
    public final static String YYYY_MM_DD = "yyyy-MM-dd";
    public final static String YYYY_M_D = "yyyy-M-d";
    public final static String YYYYMMDDHHMM = "yyyyMMddHHmm";
    public final static String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public final static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public final static String HHMMSS = "HHmmss";
    public final static String HH_MM_SS = "HH:mm:ss";
    public final static String MM_SS = "MM月dd日";
    public final static String YYYY_MM_DD_EE = "yyyy-MM-dd EE";
    public final static String YYYY_MM_DD_EEEE = "yyyy-MM-dd EEEE";
    public final static String DATE_FORMAT_STR_CHINESE = "yyyy年MM月dd日";
    public final static String YYYY_MM_DD_COMMA = "yyyy.MM.dd";
    public final static String YYYY_MM_DD_HH_MM_SS_COMMA = "yyyy.MM.dd HH:mm:ss";
    /** 00:00:00*/
    public final static String CURR_TIME_MORNING = " 00:00:00";
    /** 23:59:59*/
    public final static String CURR_TIME_NIGHT = " 23:59:59";

    public static final SimpleDateFormat DATE_FORMAT_DEFAULT = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
    public static final SimpleDateFormat DATE_FORMAT_YYYY_MM_DD_HH_MM = new SimpleDateFormat(YYYY_MM_DD_HH_MM);
    public static final SimpleDateFormat DATE_FORMAT_DATE_YYYY_MM_DD = new SimpleDateFormat(YYYY_MM_DD);
    public static final SimpleDateFormat DATE_FORMAT_DATE_YYYYMMDD = new SimpleDateFormat(YYYYMMDD);
    public static final SimpleDateFormat DATE_FORMAT_YYYY_MM = new SimpleDateFormat(YYYYMM);
    public static final SimpleDateFormat DATE_FORMAT_MM_SS_ = new SimpleDateFormat(MM_SS, Locale.getDefault());
    public static final SimpleDateFormat DATE_FORMAT_YYYY_M_D = new SimpleDateFormat(YYYY_M_D, Locale.getDefault());
    public static final SimpleDateFormat DATE_FORMAT_YYYY_MM_DD_EE = new SimpleDateFormat(YYYY_MM_DD_EE,
            Locale.getDefault());
    public static final SimpleDateFormat DATE_FORMAT_YYYY_MM_DD_EEEE = new SimpleDateFormat(YYYY_MM_DD_EEEE,
            Locale.getDefault());
    public static final SimpleDateFormat DATE_FORMAT_YYYY_MM_DD_COMMA = new SimpleDateFormat(YYYY_MM_DD_COMMA);
    public static final SimpleDateFormat DATE_FORMAT_YYYY_MM_DD_HH_MM_SS_COMMA = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS_COMMA);
    
    /**
     * 获取相差时间 字符串描述 xx小时xx分
     * @param cal1
     * @param cal2
     * @return
     */
    public static String getHoursMinute2String(Calendar cal1, Calendar cal2) {
        long gap = (cal2.getTimeInMillis() - cal1.getTimeInMillis()) / (1000 * 60);// 间隔分钟
        if (gap < 0) {
            gap = gap + 1000 * 60 * 60 * 24;
        }
        String tip = "";

        if (gap >= 60) {
            long l2 = gap / 60;
            long l3 = gap % 60;
            if (l3 > 0) {
                tip = l3 + "分钟";
            }

            tip = l2 + "小时" + tip;

        } else if (gap > 0) {
            tip = gap + "分钟";
        }

        return tip;
    }

    public static String timestamp2Date(SimpleDateFormat format, long timestamp) {
        TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8");
        TimeZone.setDefault(tz);
        format.setTimeZone(tz);
        String date = format.format(timestamp);
        return date;
    }

    /**
     * 输入一个时间，获取该时间的时间戳
     * @param dateString
     * @return
     * @throws ParseException
     */
    public static long string2Timestamp(String dateString) throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString);
        long temp = date1.getTime();// JAVA的时间戳长度是13位
        return temp;
    }

    /**
     * 毫秒转换成yyyy.MM.dd HH:mm:ss格式
     */
    public static String timestamp2Date(long timestamp) {
        TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8");
        TimeZone.setDefault(tz);
        DATE_FORMAT_DEFAULT.setTimeZone(tz);
        String date = DATE_FORMAT_DEFAULT.format(timestamp);
        return date;
    }

    /**
     * 获取yyyy.MM.dd HH:mm:ss格式的当前时间
     */
    public static String getNowDate() {
        Calendar c = Calendar.getInstance();
        String date = DATE_FORMAT_DEFAULT.format(c.getTime());
        return date;
    }

    /**
     * yyyy-MM-dd HH:mm:ss 中获取 yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String formatDate(String date) {
        Date d = new Date();
        SimpleDateFormat ymdDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            d = DATE_FORMAT_DEFAULT.parse(date);
        } catch (ParseException e) {
            return date;
        }

        return ymdDate.format(d);
    }

    /**
     * 获取日期 时分秒为0
     *
     * @return
     */
    public static Calendar getCalendar() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        format.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar c = Calendar.getInstance();
        String dateString = format.format(c.getTime());
        try {
            c.setTime(format.parse(dateString));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public static Calendar getCalendar(Calendar calendar) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = (Calendar) calendar.clone();
        String dateString = format.format(c.getTime());
        try {
            c.setTime(format.parse(dateString));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    
    public static String formatTime(String strTime) {
        SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = f1.parse(strTime);
            f1 = new SimpleDateFormat("HH:mm");
            strTime = f1.format(date);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        return strTime;
    }

    /**
     * 获取相差天数
     *
     * @param cal1
     * @param cal2
     * @return
     */
    public static int getBetween(Calendar cal1, Calendar cal2) {
        long gap = (cal2.getTimeInMillis() - cal1.getTimeInMillis()) / (1000 * 3600 * 24);// 从间隔毫秒变成间隔天数
        return (int) gap;
    }
    
    /**
     * 获取相差天数
     *
     * @param start
     * @param end
     * @return
     */
    public static int getBetween(Date start, Date end) {
    	long gap = (end.getTime() - start.getTime()) / (1000 * 3600 * 24);// 从间隔毫秒变成间隔天数
    	return (int) gap;
    }

    /**
     * 获取相差天数 去除后面的时分秒 获取相差天数
     *
     * @param cal1
     * @param cal2
     * @return
     */
    public static int getBetween2(Calendar cal1, Calendar cal2) {
        long gap = (getCalendar((Calendar) cal2.clone()).getTimeInMillis() - getCalendar(cal1).getTimeInMillis())
                / (1000 * 3600 * 24);// 从间隔毫秒变成间隔天数
        return (int) gap;
    }

    public static boolean isToday(Calendar cal) {
        boolean ret = false;
        Calendar tmp = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s1 = format.format(cal.getTime());
        String s2 = format.format(tmp.getTime());
        if (s1.equals(s2)) {
            ret = true;
        }
        return ret;
    }

    public static boolean isExpired(String searchStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        boolean ret = false;
        Calendar cur = DateTools.getCalendar();
        Calendar search = DateTools.getCalendar();
        try {
            search.setTime(format.parse(searchStr));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (search.before(cur)) {
            ret = true;
        }
        return ret;
    }

    /**
     * yyyy-MM-dd HH:mm:ss 字符串格式的两个时间的减法
     *
     * @param str1 减数
     * @param str2 被减数
     * @return 返回毫秒级别的时间单位
     */
    public static long getTimeTwoString(String str1, String str2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = df.parse(str1);
            d2 = df.parse(str2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = d1.getTime() - d2.getTime();
        return time;
    }

    /**
     * 把毫秒基本的时间格式转化为 hh:mm:ss 格式的时间
     *
     * @param diff
     * @return
     */
    public static String twoDate(long diff) {
        long days = diff / (1000 * 60 * 60 * 24);
        long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
        long miao = (diff - days * (100 * 60 * 60 * 24) - hours * (1000 * 60 * 60) - minutes * (1000 * 60)) / 1000;
        String str;
        if (String.valueOf(hours).length() == 1) {
            str = "0" + hours + ":";
        } else {
            str = hours + ":";
        }
        if (String.valueOf(minutes).length() == 1) {
            str = str + "0" + minutes + ":";
        } else {
            str = str + minutes + ":";
        }
        if (String.valueOf(miao).length() == 1) {
            str = str + "0" + miao;
        } else {
            str = str + miao;
        }
        return str;
    }

    public static String getYYYYMMDD(Date date){
    	SimpleDateFormat DATE_FORMAT_YYYYMMDD = new SimpleDateFormat(YYYYMMDD);
    	return DATE_FORMAT_YYYYMMDD.format(date);
    }

 // 获得当天0点时间  
    public static Date getTimesmorning() {  
        Calendar cal = Calendar.getInstance();  
        cal.set(Calendar.HOUR_OF_DAY, 0);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.MILLISECOND, 0);  
        return cal.getTime();  
  
  
    }  
    // 获得昨天0点时间  
    public static Date getYesterdaymorning() {  
        Calendar cal = Calendar.getInstance();  
        cal.setTimeInMillis(getTimesmorning().getTime()-3600*24*1000);  
        return cal.getTime();  
    }  
    // 获得当天近7天时间  
    public static Date getWeekFromNow() {  
        Calendar cal = Calendar.getInstance();  
        cal.setTimeInMillis( getTimesmorning().getTime()-3600*24*1000*7);  
        return cal.getTime();  
    }  
  
    // 获得当天24点时间 
    public static Date getTimesnight() {  
        Calendar cal = Calendar.getInstance();  
        cal.set(Calendar.HOUR_OF_DAY, 24);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.MILLISECOND, 0);  
        return cal.getTime();  
    }
  
    // 获得本周一0点时间  
    public static Date getTimesWeekmorning() {  
        Calendar cal = Calendar.getInstance();  
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);  
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);  
        return cal.getTime();  
    }  
    // 获得上周一0点时间  
    public static Date getLastTimesWeekmorning() {
    	Calendar cal = Calendar.getInstance();  
    	cal.setTime(getTimesWeekmorning());
    	cal.add(Calendar.DAY_OF_WEEK, -7);  
    	return cal.getTime();  
    }  
  
    // 获得本周日24点时间  
    public static Date getTimesWeeknight() {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(getTimesWeekmorning());  
        cal.add(Calendar.DAY_OF_WEEK, 7);  
        return cal.getTime();  
    }  
    
    // 获得本月第一天0点时间  
    public static Date getTimesMonthmorning() {  
        Calendar cal = Calendar.getInstance();  
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);  
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));  
        return cal.getTime();  
    }  
  
    // 获得本月最后一天24点时间  
    public static Date getTimesMonthnight() {  
        Calendar cal = Calendar.getInstance();  
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);  
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));  
        cal.set(Calendar.HOUR_OF_DAY, 24);  
        return cal.getTime();  
    }  
  
    public static Date getLastMonthStartMorning() {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(getTimesMonthmorning());  
        cal.add(Calendar.MONTH, -1);  
        return cal.getTime();  
    }
    
    public static Date getCurrentQuarterStartTime() {  
        Calendar c = Calendar.getInstance();  
        int currentMonth = c.get(Calendar.MONTH) + 1;  
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");  
        Date now = null;  
        try {  
            if (currentMonth >= 1 && currentMonth <= 3)  
                c.set(Calendar.MONTH, 0);  
            else if (currentMonth >= 4 && currentMonth <= 6)  
                c.set(Calendar.MONTH, 3);  
            else if (currentMonth >= 7 && currentMonth <= 9)  
                c.set(Calendar.MONTH, 4);  
            else if (currentMonth >= 10 && currentMonth <= 12)  
                c.set(Calendar.MONTH, 9);  
            c.set(Calendar.DATE, 1);  
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return now;  
    }  
  
    /** 
     * 当前季度的结束时间，即2012-03-31 23:59:59 
     * 
     * @return 
     */  
    public static Date getCurrentQuarterEndTime() {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(getCurrentQuarterStartTime());  
        cal.add(Calendar.MONTH, 3);  
        return cal.getTime();  
    }  
  
  
    public static Date getCurrentYearStartTime() {  
        Calendar cal = Calendar.getInstance();  
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);  
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.YEAR));  
        return cal.getTime();  
    }  
  
    public static Date getCurrentYearEndTime() {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(getCurrentYearStartTime());  
        cal.add(Calendar.YEAR, 1);  
        return cal.getTime();  
    }  
    
    //补充
    public static Date getCurYearStartTime() {  
    	Calendar cal = Calendar.getInstance();  
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.getActualMinimum(Calendar.DAY_OF_MONTH), 0, 0, 0);  
        cal.set(Calendar.MONTH, cal.getActualMinimum(Calendar.MONTH));  
        return cal.getTime();
    }  
    //补充
    public static Date getCurYearEndTime() {  
    	Calendar cal = Calendar.getInstance(); 
		cal.setTime(getCurYearStartTime());
		cal.add(Calendar.YEAR, 1);
        return cal.getTime();
    } 
  
    public static Date getLastYearStartTime() {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(getCurrentYearStartTime());  
        cal.add(Calendar.YEAR, -1);  
        return cal.getTime();  
    }
    
    /**
     * 获取下个周期的时间点
     * @param startTime	最初开始时间
     * @param cycle		周期(天)
     * @return
     */
    public static Date getNextCycleTime(Long startTime, Long cycle) {
    	Long cycleMillis = cycle * 24 * 3600 * 1000;
    	Calendar start = Calendar.getInstance();
    	start.setTimeInMillis(startTime);
    	start.set(start.get(Calendar.YEAR), start.get(Calendar.MONTH), start.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
    	
    	Calendar now = Calendar.getInstance();
    	
    	Long nCycle = (now.getTimeInMillis() - start.getTimeInMillis()) / cycleMillis;
    	Long flag = (now.getTimeInMillis() - start.getTimeInMillis()) % cycleMillis;
    	if (flag == 0) {
    		return now.getTime();
    	} else {
    		start.add(Calendar.DATE, (int) ((nCycle + 1) * cycle));
    		return start.getTime();
    	}
    }
    
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
        System.out.println("当天24点时间：" + getTimesnight().toLocaleString());  
        System.out.println("当前时间：" + new Date().toLocaleString());  
        System.out.println("当天0点时间：" + getTimesmorning().toLocaleString());  
        System.out.println("昨天0点时间：" + getYesterdaymorning().toLocaleString());  
        System.out.println("近7天时间：" + getWeekFromNow().toLocaleString());  
        System.out.println("本周周一0点时间：" + getTimesWeekmorning().toLocaleString());  
        System.out.println("本周周日24点时间：" + getTimesWeeknight().toLocaleString());  
        System.out.println("本月初0点时间：" + getTimesMonthmorning().toLocaleString());  
        System.out.println("本月未24点时间：" + getTimesMonthnight().toLocaleString());  
        System.out.println("上月初0点时间：" + getLastMonthStartMorning().toLocaleString());  
        System.out.println("本季度开始点时间：" + getCurrentQuarterStartTime().toLocaleString());  
        System.out.println("本季度结束点时间：" + getCurrentQuarterEndTime().toLocaleString());  
        System.out.println("本年开始点时间：" + getCurrentYearStartTime().toLocaleString());  
        System.out.println("本年结束点时间：" + getCurrentYearEndTime().toLocaleString());  
        System.out.println("上年开始点时间：" + getLastYearStartTime().toLocaleString());  
        System.out.println("上周一0点时间：" + getLastTimesWeekmorning().toLocaleString());  
        
        System.out.println(getNextCycleTime(1498612519550L, 4L));
    } 
}
