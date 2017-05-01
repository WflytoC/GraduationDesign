package characteristic;

/**
 * Created by wcshi on 2017/5/1.
 */
public class StructureResult {
    //是否包含H1标签
    private boolean containsH1;
    //H1标签是否包含其它子元素
    private boolean H1ContainsElements;
    //是否包含H2标签
    private boolean containsH2;
    //H12标签是否包含其它子元素
    private boolean H2ContainsElements;
    //是否满足新闻网页的结构模式：<div><p></p>...</div>
    private boolean webPattern;

    public boolean isContainsH1() {
        return containsH1;
    }

    public void setContainsH1(boolean containsH1) {
        this.containsH1 = containsH1;
    }

    public boolean isContainsH2() {
        return containsH2;
    }

    public void setContainsH2(boolean containsH2) {
        this.containsH2 = containsH2;
    }

    public boolean isWebPattern() {
        return webPattern;
    }

    public void setWebPattern(boolean webPattern) {
        this.webPattern = webPattern;
    }

    public boolean isH1ContainsElements() {
        return H1ContainsElements;
    }

    public void setH1ContainsElements(boolean h1ContainsElements) {
        H1ContainsElements = h1ContainsElements;
    }

    public boolean isH2ContainsElements() {
        return H2ContainsElements;
    }

    public void setH2ContainsElements(boolean h2ContainsElements) {
        H2ContainsElements = h2ContainsElements;
    }

    @Override
    public String toString() {
        String result = "containsH1 = " + containsH1 +  " H1ContainsElements = " + H1ContainsElements + " containsH2 = " + containsH2 + " H2ContainsElements = " + H2ContainsElements + " webPattern = " + webPattern;
        return result;
    }

}
