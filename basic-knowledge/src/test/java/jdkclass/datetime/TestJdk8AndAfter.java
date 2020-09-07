package jdkclass.datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.time.temporal.ChronoField;
import java.util.Date;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/5
 */
public class TestJdk8AndAfter {

    @Test
    public void test1() {

        /**
         * 当前日期
         */
        System.out.println(LocalDate.now());

        /**
         * epoch_day + n
         */
        System.out.println(LocalDate.ofEpochDay(1));

        /**
         * 指定日期
         */
        System.out.println(LocalDate.of(1990, 2, 4));

        /**
         * 指定日期，Month.
         */
        System.out.println(LocalDate.of(1990, Month.FEBRUARY, 4));

        /**
         * 一年的第几天
         */
        System.out.println(LocalDate.ofYearDay(1990, 100));

        /**
         * 根据时区确定日期
         */
        System.out.println(LocalDate.now(ZoneId.of("America/Los_Angeles")));

        /**
         * 格式：yyyy-MM-dd
         */
        System.out.println(LocalDate.parse("1000-10-10"));

    }

    @Test
    public void test2() {

        /**
         * 当前时间
         */
        System.out.println(LocalTime.now());


        /**
         * 没有纳秒时不输出纳秒
         */
        System.out.println(LocalTime.of(1, 1));
        System.out.println(LocalTime.of(1, 1, 1));
        System.out.println(LocalTime.ofSecondOfDay(100));


        /**
         * 存在纳秒时输出纳秒
         */
        System.out.println(LocalTime.of(1, 1, 1, 1));
        System.out.println(LocalTime.ofNanoOfDay(1000000000));


        /**
         * 格式 HH:mm:ss.nnnnnnnnn，hh:mm 必须存在
         */
        System.out.println(LocalTime.parse("10:11:11.196"));


        /**
         * 根据时区确定日期
         */
        System.out.println(LocalTime.now(ZoneId.of("Africa/Cairo")));

    }

    @Test
    public void test3() {

        /**
         * 当前时间
         */
        System.out.println(LocalDateTime.now());

        /**
         * 根据 LocalDate 和 LocalTime 确定时间
         */
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.parse("10:11:11.196")));

        /**
         * yyyy-MM-ddTHH:mm:ss.nnnnnnnnn
         */
        LocalDateTime parse = LocalDateTime.parse("2019-01-01T10:10:10");
        System.out.println(parse);

        /**
         * 指定日期时间
         */
        System.out.println(LocalDateTime.of(1, 2, 3, 1, 1, 1, 100));

        /**
         * 到 epoch time 的偏移量确定。UTC 是格林威治时间，中国所在的是东八区
         */
        System.out.println(LocalDateTime.ofEpochSecond(1, 100, ZoneOffset.UTC));

    }

    @Test
    public void test4() {

        Instant instant = Instant.now();
        System.out.println(instant);

        long epochMilli = instant.toEpochMilli();
        System.out.println(epochMilli);

    }

    @Test
    public void test5() {

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        System.out.println(now.getYear());
        System.out.println(now.getMonth());
        System.out.println(now.getDayOfYear());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        System.out.println(now.getNano());

        System.out.println(now.get(ChronoField.MICRO_OF_SECOND));
        System.out.println(now.get(ChronoField.MILLI_OF_SECOND));

    }

    @Test
    public void test6() {

        /**
         * dateTimeFormatter 和 dateTimeFormatter1 是相同的格式
         */
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dateTimeFormatter);
        DateTimeFormatter dateTimeFormatter1 = new DateTimeFormatterBuilder()
            .appendValue(ChronoField.YEAR_OF_ERA, 4, 10, SignStyle.EXCEEDS_PAD)
            .appendLiteral("/")
            .appendValue(ChronoField.MONTH_OF_YEAR, 2)
            .appendLiteral("/")
            .appendValue(ChronoField.DAY_OF_MONTH, 2)
            .appendLiteral(" ")
            .appendValue(ChronoField.HOUR_OF_DAY, 2)
            .appendLiteral(":")
            .appendValue(ChronoField.MINUTE_OF_HOUR, 2)
            .appendLiteral(":")
            .appendValue(ChronoField.SECOND_OF_MINUTE, 2).toFormatter();
        System.out.println(dateTimeFormatter1);

        /**
         * 日期转为字符串
         */
        String format = LocalDateTime.now().format(dateTimeFormatter);
        System.out.println(format);
        System.out.println(LocalDateTime.now().format(dateTimeFormatter1));

        /**
         * 字符串转为日期
         */
        System.out.println(dateTimeFormatter.parse(format));

    }

    @Test
    public void test7() {

        /**
         * Date转为 java8 日期的表示
         */
        /**
         * UTC代表格林威治时间
         */
        Date date = new Date();
        LocalDateTime localDateTime = date.toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime();
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(localDateTime1);

        /**
         * LocalDateTime 转为 Date
         */
        Date localDateTimeDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(localDateTimeDate);

        /**
         * LocalDate 转为 Date
         */
        LocalDate localDate = LocalDate.now();
        Date localDateDate = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(localDateDate);

        LocalTime localTime = LocalTime.now();
        // 必须给 LocalTime 传入一个 LocalDate
        Instant instant = localTime.atDate(localDate).atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(Date.from(instant));

    }


}
