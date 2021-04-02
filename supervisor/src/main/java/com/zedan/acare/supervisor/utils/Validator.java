package com.zedan.acare.supervisor.utils;

import android.text.TextUtils;
import android.util.Patterns;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

public final class Validator {
    
    public static boolean isEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    
    public static boolean isName(String name, int length) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        return new Regex("^[a-z ,.'-]+$").matches(name) || name.length() > length;
    }

    public static boolean isPhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            return false;
        }
        return new Regex("^0[1][0125]\\d{8}$").matches(phone);
    }
    
    public static boolean isLargeThan(String text, int length) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        return text.length() > length;
    }

    public static boolean isStatus(String status) {
        if(status == null || status.isEmpty())
            return false;
        return status.equalsIgnoreCase("F") ||
                status.equalsIgnoreCase("E") ||
                status.equalsIgnoreCase("L") ||
                status.equalsIgnoreCase("M");
    }

    public static boolean isAge(String age) {
        if (age == null || age.isEmpty())
            return false;
        
        return TextUtils.isDigitsOnly(age) &&  age.length() <= 3;
    }

    public static boolean isDate(String date) {
        return date != null && !date.isEmpty();
    }

    public static boolean isHour(String hour) {
        return hour != null && !hour.isEmpty();
    }
}
