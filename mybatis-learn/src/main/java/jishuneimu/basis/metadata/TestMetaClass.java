package jishuneimu.basis.metadata;

import java.util.List;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaClass;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/9/7
 */
public class TestMetaClass {

    public static void main(String[] args) {

        MetaClass metaClass = MetaClass.forClass(Customer.class, new DefaultReflectorFactory());

        System.out.println(metaClass.findProperty("order.name"));
        System.out.println(metaClass.findProperty("order.price"));
        System.out.println(metaClass.findProperty("order.age"));
        System.out.println(metaClass.getSetterType("order.name"));
        System.out.println(metaClass.getSetterType("order.price"));
        System.out.println(metaClass.getGetterType("addressList[].name"));


    }


    class Customer {
        private Order order;
        private List<Address> addressList;
        public Order getOrder() {
            return order;
        }
        public void setOrder(Order order) {
            this.order = order;
        }
        public List<Address> getAddressList() {
            return addressList;
        }
        public void setAddressList(List<Address> addressList) {
            this.addressList = addressList;
        }
    }

    class Order {
        String name;
        Double price;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Double getPrice() {
            return price;
        }
        public void setPrice(Double price) {
            this.price = price;
        }
    }

    class Address {
        String name;
        String Postcode;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getPostcode() {
            return Postcode;
        }
        public void setPostcode(String postcode) {
            Postcode = postcode;
        }
    }

}
