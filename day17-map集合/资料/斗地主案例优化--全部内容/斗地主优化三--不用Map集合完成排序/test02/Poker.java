package test02;

public class Poker {
    private int index;//给每张扑克进行编号
    private String content;//扑克的内容,比如"♥3","♠3","♣3","♦3"

    @Override
    public String toString() {
        return "Poker{" +
                "index=" + index +
                ", content='" + content + '\'' +
                '}';
    }

    public Poker() {
    }

    public Poker(int index, String content) {
        this.index = index;
        this.content = content;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
