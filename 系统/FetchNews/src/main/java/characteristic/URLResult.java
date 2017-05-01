package characteristic;

/**
 * Created by wcshi on 2017/5/1.
 */
public class URLResult {
    //是否包含新闻属性的关键字，如news、xinwen等
    private boolean containsKeywordOfNews;
    //是否包含排除新闻的关键字，如blog等
    private boolean containsKeywordOfNotNews;
    //是否包含日期指示器，如2017-12-2
    private boolean containsDateIndicator;
    //URL的最后一个片段转化为纯数字，其长度是否够长：以4比较
    private boolean lastPartEnoughLong;

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

    public boolean isContainsDateIndicator() {
        return containsDateIndicator;
    }

    public void setContainsDateIndicator(boolean containsDateIndicator) {
        this.containsDateIndicator = containsDateIndicator;
    }

    public boolean isLastPartEnoughLong() {
        return lastPartEnoughLong;
    }

    public void setLastPartEnoughLong(boolean lastPartEnoughLong) {
        this.lastPartEnoughLong = lastPartEnoughLong;
    }

    @Override
    public String toString() {
        String result = "containsKeywordOfNews = " + containsKeywordOfNews + " containsKeywordOfNotNews = " + containsKeywordOfNotNews + " lastPartEnoughLong = " + lastPartEnoughLong + " containsDateIndicator = " + containsDateIndicator;
        return result;
    }
}
