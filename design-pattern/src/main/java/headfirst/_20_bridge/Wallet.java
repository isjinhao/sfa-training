package headfirst._20_bridge;

// 扩展抽象化角色：钱包
class Wallet extends Bag {

    public String getStyle() {
        return color.getColor() + "Wallet";
    }

}