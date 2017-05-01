package characteristic;

/**
 * Created by wcshi on 2017/5/1.
 */
public class ContentResult {
    //文本中是否包含新闻属性的关键字，如新闻等
    private boolean containsKeywordOfNews;
    //文本是否包含排除新闻的关键字，如博客等
    private boolean containsKeywordOfNotNews;
    //文本是否包含指定模式，如
    private int containsNewsPatternCount;

    public boolean isContainsKeywordOfNews() {
        return containsKeywordOfNews;
    }

    public void setContainsKeywordOfNews(boolean containsKeywordOfNews) {
        this.containsKeywordOfNews = containsKeywordOfNews;
    }

    public boolean isContainsKeywordOfNotNews() {
        return containsKeywordOfNotNews;
    }

    public void setContainsKeywordOfNotNews(boolean containsKeywordOfNotNews) {
        this.containsKeywordOfNotNews = containsKeywordOfNotNews;
    }

    public int getContainsNewsPatternCount() {
        return containsNewsPatternCount;
    }

    public void setContainsNewsPatternCount(int containsNewsPatternCount) {
        this.containsNewsPatternCount = containsNewsPatternCount;
    }

    @Override
    public String toString() {
        String result = "containsKeywordOfNews = " + containsKeywordOfNews + " containsKeywordOfNotNews = " + containsKeywordOfNotNews + " containsNewsPatternCount = " + containsNewsPatternCount;
        return result;
    }
}
