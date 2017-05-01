package handler.structure;

import characteristic.StructureResult;
import characteristic.URLResult;
import constants.NewSources;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by wcshi on 2017/5/1.
 */
public class StructureHandler {

    public static void HandlePageStructure(String url) throws IOException {
        Document doc = Jsoup.connect(url).userAgent("Mozilla").get();

        //处理title标签
        Elements elements = doc.select("title");
        System.out.println(elements.first().text());
        //处理H2标签
        Elements h1s = doc.select("H1");
        if (h1s != null) {
            if (h1s.first() != null) {
                System.out.println(h1s.first().text());
            }
        }

        //处理展示新闻内容的p标签
        Elements ps = doc.select("div > p");

        for (Element element: ps) {
            //需要排除干扰项
            Element div = element.parent();
            Elements children = div.children();
            if (children.size() > 3) {
                System.out.println(element.text());
            }
        }
    }

    public static StructureResult getStructureTrait(String webURL) throws Exception {
        Document doc = Jsoup.connect(webURL).userAgent("Mozilla").get();
        StructureResult result = new StructureResult();

        Elements h1s = doc.select("H1");
        if (h1s.first() != null) {
            result.setContainsH1(true);
            Elements sub = h1s.first().children();
            if (sub.size() > 0) {
                result.setH1ContainsElements(true);
            }
        }

        Elements h2s = doc.select("H2");
        if (h1s.first() != null) {
            result.setContainsH2(true);
            Elements sub = h2s.first().children();
            if (sub.size() > 0) {
                result.setH2ContainsElements(true);
            }
        }

        //处理展示新闻内容的p标签
        Elements ps = doc.select("div > p");

        for (Element element: ps) {
            //需要排除干扰项
            Element div = element.parent();
            Elements children = div.children();
            if (children.size() > 3) {
                result.setWebPattern(true);
            }
        }
        return result;
    }
}
