package handler.content;

import constants.NewSources;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by wcshi on 2017/5/1.
 */
//利用正则表达式对文本进行处理
public class ContentsHandler {

    public static String[] keyWords = {"新闻","报道","采访","记者"};
    public static String[] patterns = {"\\d{1,2}月\\d{1,2}日","-[]-"};

    public static void handleContent(String url) throws IOException {
        Document doc = Jsoup.connect(url).userAgent("Mozilla").get();
        System.out.println(doc.text());
    }
    public static void containsKeywords() {

    }
}

























