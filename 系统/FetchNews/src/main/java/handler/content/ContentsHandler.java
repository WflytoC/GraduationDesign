package handler.content;

import characteristic.ContentResult;
import characteristic.URLResult;
import constants.NewSources;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by wcshi on 2017/5/1.
 */
//利用正则表达式对文本进行处理
public class ContentsHandler {

    public static String[] keyWords = {"新闻","报道","采访","记者"};
    public static String[] excludeWords = {"博客"};
    public static String[] patterns = {".+\\d{1,2}月\\d{1,2}日.+",".+\\d{2,4}-\\d{1,2}-\\d{1,2}.+"};
    public static void handleContent(String url) throws IOException {
        Document doc = Jsoup.connect(url).userAgent("Mozilla").get();
        System.out.println(doc.text());
    }
    public static ContentResult getContentTrait(String webURL) throws Exception {
        ContentResult result = new ContentResult();
        Document doc = Jsoup.connect(webURL).userAgent("Mozilla").get();
        String text = doc.text();
        for (String keyWord: keyWords) {
            if (text.indexOf(keyWord) > -1) {
                result.setContainsKeywordOfNews(true);
            }
        }
        for (String excludeWord: excludeWords) {
            if (text.indexOf(excludeWord) > -1) {
                result.setContainsKeywordOfNotNews(true);
            }
        }

        int count = 0;
        for (String pattern: patterns) {
            boolean isMatch = Pattern.matches(pattern,text);
            if (isMatch) {
                count += 1;
            }
        }
        result.setContainsNewsPatternCount(count);
        return result;
    }
}

























