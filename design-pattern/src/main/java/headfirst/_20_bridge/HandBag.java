package headfirst._20_bridge;

// 扩展抽象化角色：挎包
class HandBag extends Bag {

    public String getStyle() {
        return color.getColor() + "HandBag";
    }

}