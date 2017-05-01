package component;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;

/**
 * Created by wcshi on 2017/5/1.
 */
public class ExtractComponent {
   public static HashMap<String,String> getNews(String webURL) throws Exception {
       HashMap<String,String> news = new HashMap<>();
       Document doc = Jsoup.connect(webURL).userAgent("Mozilla").get();

       Elements title = doc.select("title");
       news.put("title",title.first().text());

       //处理展示新闻内容的p标签
       Elements ps = doc.select("div > p");

       for (Element element: ps) {
           //需要排除干扰项
           Element div = element.parent();
           Elements children = div.children();
           if (children.size() > 3) {
               System.out.println(element.text());

               news.put("content",div.text());
               break;
           }
       }
       return news;
   }
}
