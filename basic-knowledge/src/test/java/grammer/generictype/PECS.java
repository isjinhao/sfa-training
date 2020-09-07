package grammer.generictype;

import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/6
 */
public class PECS {
    class Goods<T> {

        private T t;
        private int number;

        public void set(T t) {
        }

        public T get() {
            return null;
        }

        @Test
        public void test1() {
            /**
             * 我们分析一下，第38行代码中`? extends Fruit`替换了`T`，这个时候编译器知道`T`是`Fruit`或者其子类，但是它却不知道具体是哪一个，假如它编译器设置为了`Apple`，
             * 那么传入`Orange`对象在编译期是不会出错的，因为`Orange`是符合`? extends Fruit`的，但是我们知道`Apple`的引用根本无法引用`Orange`的对象，就会出错。
             * 所以编译器就拒绝传递它不确定的类型（null 除外，因为任何对象都能引用null）。
             * 第39行不会出错，因为返回的类型是`Fruit`或者其子类，这样我们在接收的时候使用`Fruit`接收就行了。
             *
             * 需要注意的是，我们不能站在上帝视角看待这个问题。因此不能简单的以为，编译器会将T看做 Fruit。实际上，编译器只会将T看做传入的 ? extends Fruit。
             * 所以要能保证 ? extends Fruit 确定的类型集合里的每一个类型都能引用 set(T t) 传入的对象才不会引发错误。很显然除了 null，没有对象可以做到。
             *
             * 但是对于 T get()，返回的对象的类型是 ? extends Fruit 确定的类型集合的一种。这个类型集合里的每个元素都可以使用 Fruit 引用，所以此方法返回的对象可以用 Fruit 接收
             */
            Goods<? extends Fruit> fruitGoods = new Goods<>();
//            fruitGoods.set(new Orange());    // 这段代码会出错
            Fruit fruit = fruitGoods.get();
        }

        @Test
        public void test2() {
            /**
             * 如果使用了下界通配符，我们就可以传入`Orange`对象，因为`T`会被实例化为`Fruit`或其父类，而无论是`Fruit`还是其父类都能接收`Orange`对象，但是不能接受`Fruit`的父类。
             *
             * 而在返回的时候只能用`Object`接收，因为在`? super Fruit`定义的类型集合内只有`Object`可以接收所有的类型。
             */
            Goods<? super Fruit> fruitGoods = new Goods<>();
            fruitGoods.set(new Orange());
            Object fruit = fruitGoods.get();
        }

        /**
         * 泛型的PECS（Produce Extends Consumer Super）就是以泛型类的视角看待问题时，当向泛型类里取泛型数据时，需要使用 Extends，因为此时泛型类是一个生产者。
         * 当向泛型类里放数据时，需要使用 Super，因为此时泛型类是一个消费者。
         */

        /** Collections.copy()
         *     public static <T> void copy(List<? super T> dest, List<? extends T> src) {
         *         int srcSize = src.size();
         *         if (srcSize > dest.size())
         *             throw new IndexOutOfBoundsException("Source does not fit in dest");
         *
         *         if (srcSize < COPY_THRESHOLD ||
         *             (src instanceof RandomAccess && dest instanceof RandomAccess)) {
         *             for (int i=0; i<srcSize; i++)
         *                 dest.set(i, src.get(i));
         *         } else {
         *             // 向泛型类放数据，此时泛型类是消费者（C），需要使用 Super（S）
         *             ListIterator<? super T> di=dest.listIterator();
         *             // 从泛型类取数据，此时泛型类是生产者（P），需要使用 Extends（E）
         *             ListIterator<? extends T> si=src.listIterator();
         *             for (int i=0; i<srcSize; i++) {
         *                 di.next();
         *                 di.set(si.next());
         *             }
         *         }
         *     }
         */
    }
}