import database.DBUtils;
import handler.content.ContentsHandler;
import handler.url.URLHandler;
import model.News;
import parse.ParseNews;

import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by wflytoc on 2017/4/28.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        //fetchInputSource();
        //URLHandler.parseElements("http://www.gov.cn/premier/2017-04/28/content_5189695.htm");
        //getDateDictator();
        //URLHandler.containsDate("20170123");
        //StructureHandler.HandlePageStructure("http://news.baidu.com/");
        ContentsHandler.handleContent("http://www.cankaoxiaoxi.com/roll10/bd/20170501/1947112.shtml");
        testPattern();
    }


    //爬取新闻网页作为训练模块的输入源
    public static void fetchInputSource() {
        ParseNews.parseNewsAndStore();
    }

    //打印出所有新闻网页URL中的日期指示器
    public static void getDateDictator() throws Exception {
        ArrayList<News> list = DBUtils.getNews(0);
        for (News news: list) {
            String href = news.getHref();
            if (href.equals("")) {
                continue;
            }
            System.out.println(href);
            URL url = new URL(href);
            String path = url.getPath();
            String[] parts = path.split("/");
            ArrayList<String> dictators = URLHandler.getDateIndicator(parts);
            String str = URLHandler.concatDateIndicators(dictators);
            System.out.println(str);
        }
    }

    public static void testPattern() {
        String content = "2017-3-4";
        String pattern1 = "\\d{1,2}月\\d{1,2}日";
        boolean isMatch1 = Pattern.matches(pattern1,content);
        System.out.println("月 日 " + isMatch1);
        String pattern2 = "\\d{2,4}-\\d{1,2}-\\d{1,2}";
        boolean isMatch2 = Pattern.matches(pattern2,content);
        System.out.println("- - " + isMatch2);
    }
}
