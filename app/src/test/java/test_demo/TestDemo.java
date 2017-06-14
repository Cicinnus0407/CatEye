package test_demo;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Cicinnus on 2017/6/13.
 */

public class TestDemo {
    @Test
    public void time() {
//        System.out.println(TimeUtils.dateToMillions("2017-06-13 02:54"));
//        System.out.println(TimeUtils.daysAgo(TimeUtils.dateToMillions("2017-06-13 02:54")));
        Calendar cd = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d yyyy HH:mm:ss 'GMT'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT")); // 设置时区为GMT
        String str = sdf.format(cd.getTime());
        System.out.println(str);
    }
}
