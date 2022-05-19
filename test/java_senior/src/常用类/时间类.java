package 常用类;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

public class 时间类 {

    //1.System.currentTimeMillis()
    @Test
    public void test1() {
        long time = System.currentTimeMillis();//时间戳
        System.out.println(time);
    }


    /*
    2.Date类
    (1)java.util.Date
    (2)java.sql.Date 数据库用
     */

    @Test
    public void test2() {
        //java.util.Date对应现在时间的构造器
        Date date1 = new Date();
        System.out.println(date1);
        System.out.println(date1.getTime());//= System.currentTimeMillis()

        //创建指定时间
        Date date2 = new Date(1652861243300L);
        System.out.println(date2);

        //java.sql.Date 数据库用
        java.sql.Date date = new java.sql.Date(1652861426456L);
        System.out.println(date);

        //util.date和sql.date转化
        Date date3 = new Date();
        java.sql.Date date4 = new java.sql.Date(date3.getTime());
        System.out.println(date4);

        Date date5 = new java.sql.Date(4654987L);
        System.out.println(date5);
    }

    //3.SimpleDateFormat
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //默认构造器
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        System.out.println(date);

        //格式化：日期-->字符串
        String format = sdf.format(date);//可能有异常
        System.out.println(format);

        //解析
        String str = "2022/5/19 下午2:29";
        date = sdf.parse(str);
        System.out.println(date);

        //***********************按照制定格式格式化*********************
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = sdf1.format(date);
        System.out.println(format1);

        Date date2 = sdf1.parse("2022-05-06 13:32:47");
        System.out.println(date2);
    }

    //4.Calendar抽象类
    @Test
    public void testCalendar() {
        Calendar cal = Calendar.getInstance();
        int days = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(days);

        //Date 与 Calendar转化
        Date date = cal.getTime();
        System.out.println(date);

        Date date1 = new Date();
        cal.setTime(date1);
    }

    //5.jdk8的Time api
    @Test
    public void testTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        //指定时间
        LocalDateTime localdatetime1 = localDateTime.of(2002, 12, 5, 8, 21);
        System.out.println(localdatetime1);

        //get
        System.out.println(localDateTime.getDayOfMonth());

        //with改（不可变性）
        LocalDateTime localDateTime2 = localdatetime1.withDayOfMonth(6);
        System.out.println(localDateTime2);

        //加减
        LocalDateTime localDateTime3 = localDateTime2.plusDays(1);
        System.out.println(localDateTime3);
    }

    //6.Instant 类似Date
    @Test
    public void testInstant() {
        //now()获取子午线时间
        Instant now = Instant.now();
        System.out.println(now);

        //时区调整
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取1970对应的ms
        long ms = now.toEpochMilli();
        System.out.println(ms);

        //用ms获取instant
        Instant instant = Instant.ofEpochMilli(1652952468232L);
        System.out.println(instant);
    }

    //7.DateTimeFormatter 类似simpledateformatter
    @Test
    public void testDateTimeFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime now = LocalDateTime.now();
        //格式化
        String str = formatter.format(now);
        System.out.println(now+ "   "+str);

        //解析
        TemporalAccessor parse = formatter.parse("2022-05-19T17:35:16.882848207");
        System.out.println(parse);


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);//选择格式
        String format = dateTimeFormatter.format(now);
        System.out.println(format);

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format1 = dateTimeFormatter1.format(LocalDateTime.now());
        System.out.println(format1);
    }

}
