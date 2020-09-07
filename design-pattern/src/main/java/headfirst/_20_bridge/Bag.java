package headfirst._20_bridge;

// 抽象化角色：包
abstract class Bag {

    protected Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract String getStyle();

}