package handler.url;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by wcshi on 2017/4/30.
 */
public class URLHandler {

    public static final String[] months = {"01","02","03","04","05","06","07","08","09","10","11","12"};
    public static String[] yearsChoice() {
        Calendar nowDate = Calendar.getInstance();
        int year = nowDate.get(Calendar.YEAR);
        int year_minus_1 = year - 1;
        int year_minus_2 = year - 2;
        int month = nowDate.get(Calendar.MONTH ) + 1;
        int day = nowDate.get(Calendar.DAY_OF_MONTH);
        //包含完整的年份 或者 年份后两位
        String fullYear = year + "";
        String fullYear_minus_1 = year_minus_1 + "";
        String fullYear_minus_2 = year_minus_2 + "";

        String partYear = fullYear.substring(2);
        String partYear_minus_1 = fullYear_minus_1.substring(2);
        String partYear_minus_2 = fullYear_minus_2.substring(2);

        String[] years = {fullYear,fullYear_minus_1,fullYear_minus_2,partYear,partYear_minus_1,partYear_minus_2};
        return years;
    }

    public static void parseElements(String urlStr) {
        try {
            URL url = new URL(urlStr);
            System.out.println("getProtocol： " + url.getProtocol());
            System.out.println("getHost： " + url.getHost());
            System.out.println("getPath： " + url.getPath());

            String path = url.getPath();
            String[] parts = path.split("/");
            String lastPart = parts[parts.length - 1];
            System.out.println(lastPart);
            System.out.println(transformLastPart(lastPart));
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
    //将URL最后一个部分转化为纯数字
    public static String transformLastPart(String url) {
        char[] items = url.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char c: items) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    //将URL切分开后，获取只有纯数字的片段
    public static ArrayList<String> getDateIndicator(String[] parts) {
        ArrayList<String> list = new ArrayList<>();
        for (String str: parts) {
            if (containsDigitalAndNotLetter(str)) {
                list.add(str);
            }
        }
        return list;
    }

    //将纯数字的片段联合起来
    public static String concatDateIndicators(ArrayList<String> indicators) {
        StringBuffer sb = new StringBuffer();
        for (String s: indicators) {
            sb.append(s);
        }

        return sb.toString().replace("-","");
    }

    public static boolean containsDigitalAndNotLetter(String str) {
        boolean containsDigital = false;
        boolean containsLetter = false;
        char[] chars = str.toCharArray();
        for (char item: chars) {
            if (Character.isDigit(item)) {
                containsDigital = true;
                continue;
            }
            if (Character.isLetter(item)) {
                containsLetter = true;
            }
        }
        return (containsDigital && !containsLetter);
    }

    //判断字符串是否含有日期 s已经确定是纯数字
    public static boolean containsDate(String s) {
        Calendar nowDate = Calendar.getInstance();
        int year = nowDate.get(Calendar.YEAR);
        int month = nowDate.get(Calendar.MONTH ) + 1;
        int day = nowDate.get(Calendar.DAY_OF_MONTH);
        //包含完整的年份 或者 年份后两位
        String fullYear = year + "";
        String partYear = fullYear.substring(2);
        System.out.println(year + " " + partYear);
        System.out.println(month);
        System.out.println(day);
        return true;
    }

    public static boolean containsYearAndMonth(String str) {
        HashMap<String,Boolean> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        boolean containsYearAndMonth = false;
        //年+月份组合
        for (String year : yearsChoice()) {
            for (String month: months) {
                String date = year + month;
                list.add(date);
            }
        }

        for (String item: list) {
            if (str.indexOf(item) > -1) {
                containsYearAndMonth = true;
                break;
            }
        }
        return containsYearAndMonth;
    }

}
