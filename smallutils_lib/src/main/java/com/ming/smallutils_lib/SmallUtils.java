package com.ming.smallutils_lib;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.TypedValue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * app常用工具类
 * <p>
 * Author MingRuQi
 * E-mail mingruqi@sina.cn
 * DateTime 2018/12/12 11:53
 */
public class SmallUtils {

    /**
     * 尺寸单位转换
     * **********************************************************************************************************************
     */
    /**
     * dp转px
     */
    public static int dp2px(Context context, float dpValues) {
        dpValues = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValues, context.getResources().getDisplayMetrics());
        return (int) (dpValues + 0.5f);
    }

    /**
     * sp转px
     */
    public static int sp2px(Context context, float dpValues) {
        dpValues = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, dpValues, context.getResources().getDisplayMetrics());
        return (int) (dpValues + 0.5f);
    }

    /**
     * in转px
     */
    public static int in2px(Context context, float dpValues) {
        dpValues = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_IN, dpValues, context.getResources().getDisplayMetrics());
        return (int) (dpValues + 0.5f);
    }

    /**
     * px转dp
     *
     * @param context
     * @param px
     * @return
     */
    public static int px2dp(Context context, int px) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (px / density + 0.5);//四舍五入
    }
    /**
     * ******************************************************************************************************
     */


    /**
     * 判断手机号是否正确
     *
     * @param mobile 手机号
     * @return true：正确  false：错误
     */
    public static boolean isMobile(String mobile) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,6,7,8,9][0-9]{9}$"); // 验证手机号
        m = p.matcher(mobile);
        b = m.matches();
        return b;
    }

    /**
     * 获取APP版本号
     *
     * @param ctx
     * @return
     */
    public static int getVersionCode(Context ctx) {
        // 获取packagemanager的实例
        int version = 0;
        try {
            PackageManager packageManager = ctx.getPackageManager();
            PackageInfo packInfo = packageManager.getPackageInfo(ctx.getPackageName(), 0);
            version = packInfo.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return version;
    }

    /**
     * 获取APP版名称
     *
     * @param ctx
     * @return
     */
    public static String getVersionName(Context ctx) {
        // 获取packagemanager的实例
        String versionName = "";
        try {
            PackageManager packageManager = ctx.getPackageManager();
            PackageInfo packInfo = packageManager.getPackageInfo(ctx.getPackageName(), 0);
            versionName = packInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionName;
    }

    /**
     * 获取当前时间
     *
     * @param format 时间格式   2018-12-12 15:16  /  2018年12月12日 15:16
     * @return
     */
    public String getCurrentDate(String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = new Date();
        return formatter.format(date);
    }


    /**
     * 获取时间戳
     */
    public long getTimestamp() {
        long timestamp = System.currentTimeMillis();
        return timestamp;
    }


    /**
     * 时间戳转为日期
     *
     * @param timestamp 时间戳
     * @param format    时间格式   2018-12-12 15:16  /  2018年12月12日 15:16
     * @return
     */
    public String timestampToDate(long timestamp, String format) {
        Date date = new Date(timestamp);
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    /**
     * 日期转时间戳
     */
    public long dateToTimestamp(String date) {
        long timeStamp = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d;
        try {
            d = sdf.parse(date);
            timeStamp = d.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeStamp;
    }


}
