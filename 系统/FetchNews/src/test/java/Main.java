import database.DBUtils;
import handler.url.URLHandler;
import model.News;
import parse.ParseNews;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by wflytoc on 2017/4/28.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        //fetchInputSource();
        //URLHandler.parseElements("http://www.gov.cn/premier/2017-04/28/content_5189695.htm");
        //getDateDictator();
        URLHandler.containsDate("20170123");
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
}
