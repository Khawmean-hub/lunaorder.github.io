package com.kosign.luna.util;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

@Component
public class DateTimeUtils {

    public Timestamp getCurrentTime(){
        return new Timestamp(System.currentTimeMillis());
    }
    public String getDateOnly(){
        SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy/MM/dd");
        String datNow = oldFormat.format(getCurrentTime());
        return datNow;
    }
    public String tConvert(String time) {
        int hh = Integer.parseInt(time.split(":")[0]);
        String mm = time.split(":")[1];
        int hhh=hh;
        String am =" AM";

        if(hh>12){
            am=" PM";
            hhh = hh-12;
        }else if(hh==0){
            hhh=12;
        }
        DecimalFormat df = new DecimalFormat("00");
        String hour = df.format(hhh);

        return hour+":"+mm+am;
    }
}
