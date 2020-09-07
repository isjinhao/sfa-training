package grammer.generictype;

/**
 * 泛型类和泛型方法都是定义了一个类或者方法的模板。能构造不同类型的属性或不同参数类型的方法。我们假设：
 */
abstract class Fruit {
    abstract int getPrice();
    abstract int getNumber();
}
class Apple extends Fruit {
    @Override
    int getPrice() {
        return 1;
    }
    @Override
    int getNumber() {
        return 10;
    }
}
class Orange extends Fruit {
    @Override
    int getPrice() {
        return 2;
    }
    @Override
    int getNumber() {
        return 20;
    }
}
class Goods<T> {
    private T t;
}
public class GenericWildcards{
//    void payMoney(Goods<Fruit> fruitGoods){ }
    void payMoney(Goods<?> fruitGoods){ }
    public static void main(String[] args) {
        GenericWildcards shopping = new GenericWildcards();
        /**
         * 第35行代码会出错。本来我们的想法是计算应该付多少钱，所以使用了抽象类Fruit。但是虽然Apple是Fruit的子类，但是Goods<Apple>却不是Goods<Fruit>的子类，
         * 所以这里会报错。怎么解决呢？便是使用通配符?，将此行代码替换为void payMoney(Goods<?> fruitGoods){ }便不会报错。
         *
         * 通配符是一种类型，一种可以代表多种类型的类型。它和T不一样，T是为了声明此类有一个类型参数需要去实例化，而?是一种实例化T的类型。
         * 也就是说，Goods<?> 可以表示 所有 Goods<T> 实例化之后的类型
         */
        shopping.payMoney(new Goods<Apple>());
    }
}