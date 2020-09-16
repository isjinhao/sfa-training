package jishuneimu.basis.metadata;

import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;

import java.util.Arrays;
import java.util.List;

public class TestMetaObject {

    public static void main(String[] args) throws Exception {

        Customer customer = new Customer();

        MetaObject metaObject = MetaObject.forObject(customer, new DefaultObjectFactory(), new DefaultObjectWrapperFactory(), new DefaultReflectorFactory());

        System.out.println(Arrays.deepToString(metaObject.getGetterNames()));
        System.out.println(metaObject.getValue("order"));

    }

    static class Customer {
        private Order order = new Order();
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

    static class Order {
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

    static class Address {
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
