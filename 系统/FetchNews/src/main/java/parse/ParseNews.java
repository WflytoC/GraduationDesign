package parse;

import constants.NewSources;
import database.DBUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by wflytoc on 2017/4/28.
 */
public class ParseNews {

    public static void parseNewsAndStore() {
        System.out.println("初始新闻数量为 " + DBUtils.getNewsCount() );
        System.out.println("解析新闻开始.................");
        parseBaiduNews();
        parseSinaNews();
        parseTencentNews();
        parseNeteaseNews();
        parseSohuNews();
    }

    public static void parseBaiduNews(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("解析百度新闻开始.............");
                    Document doc = Jsoup.connect(NewSources.news_index_baidu).userAgent("Mozilla").get();
                    Elements items = doc.select("div[id=pane-news] a");
                    DBUtils.insert(items);
                    System.out.println("解析百度新闻结束.............");
                }catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

    public static void parseSinaNews() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("解析百度新浪开始.............");
                    Document doc = Jsoup.connect(NewSources.news_index_sina).userAgent("Mozilla").get();
                    Elements items = doc.select("ul[data-sudaclick] a");
                    DBUtils.insert(items);
                    System.out.println("解析新浪新闻结束.............");
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void parseSohuNews() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("解析搜狐新闻开始.............");
                    Document doc = Jsoup.connect(NewSources.news_index_sohu).userAgent("Mozilla").get();
                    Elements items1 = doc.select("div[class=pic-group] a");
                    Elements items2 = doc.select("div[class=v-list] a");
                    Elements items3 = doc.select("div[class=sn-list] a");
                    Elements items4 = doc.select("div[class=news] a");
                    DBUtils.insert(items1);
                    DBUtils.insert(items2);
                    DBUtils.insert(items3);
                    DBUtils.insert(items4);
                    System.out.println("解析搜狐新闻结束.............");
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void parseNeteaseNews() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("解析网易新闻开始.............");
                    Document doc = Jsoup.connect(NewSources.news_index_netease).userAgent("Mozilla").get();
                    Elements items1 = doc.select("ul[class=top_news_ul] a");
                    Elements items2 = doc.select("div[class=mod_important_news] a");
                    Elements items3 = doc.select("div[class=mod_netes_origina] a");
                    Elements items4 = doc.select("div[class=mod_news_special] a");
                    DBUtils.insert(items1);
                    DBUtils.insert(items2);
                    DBUtils.insert(items3);
                    DBUtils.insert(items4);
                    System.out.println("解析网易新闻结束.............");
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void parseTencentNews() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("解析腾讯新闻开始.............");
                    Document doc = Jsoup.connect(NewSources.news_index_tencent).userAgent("Mozilla").get();
                    Elements items = doc.select("div[class=Q-tpWrap] a");
                    Elements result = items.not("a[href=javascript:void(0)]");
                    System.out.println("解析腾讯新闻结束.............");
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
