package parse;

import constants.NewSources;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by wflytoc on 2017/4/28.
 */
public class ParseNews {
    public static void parseBaiduNews(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document doc = Jsoup.connect(NewSources.news_index_baidu).userAgent("Mozilla").get();
                    Elements items1 = doc.select("div[id=pane-news] a");
                    for (Element element: items1) {
                        System.out.println(element.attr("href") + " " + element.text());
                    }
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
                    Document doc = Jsoup.connect(NewSources.news_index_sina).userAgent("Mozilla").get();
                    Elements items1 = doc.select("div[id=pane-news] a");
                    for (Element element: items1) {
                        System.out.println(element.attr("href") + " " + element.text());
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
