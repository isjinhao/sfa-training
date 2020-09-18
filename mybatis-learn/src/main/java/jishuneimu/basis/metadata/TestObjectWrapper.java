package jishuneimu.basis.metadata;

import com.sun.org.apache.xpath.internal.operations.Or;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;

public class TestObjectWrapper {

    public static void main(String[] args) {

        Map<String, Customer> stringCustomerMap = new HashMap<>();
        Customer customer = new Customer();
        stringCustomerMap.put("customer", customer);
        MetaObject metaObject = MetaObject.forObject(stringCustomerMap, new DefaultObjectFactory(), new DefaultObjectWrapperFactory(), new DefaultReflectorFactory());

        ArrayList<Order> orderList = new ArrayList<>(10);
        orderList.add(null);

        metaObject.setValue("customer.orderList", orderList);
        metaObject.setValue("customer.orderList[0]", new Order("milk", 1.2d));
        System.out.println(metaObject.getValue("customer.orderList[0].name"));
        System.out.println(metaObject.getValue("customer.orderList[0].price"));

    }

}

class Customer {
    private List<Order> orderList = new ArrayList<>();
    private Address address;
    public List<Order> getOrderList() {
        return orderList;
    }
    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

class Order {
    private String name;
    private Double price;
    public Order(String name, Double price) {
        this.name = name;
        this.price = price;
    }
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
    private String name;
    private String postcode;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}