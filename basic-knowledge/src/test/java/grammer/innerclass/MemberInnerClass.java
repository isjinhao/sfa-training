package grammer.innerclass;

import grammer.innerclass.Circle.Draw;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/4
 */
public class MemberInnerClass {

    public static void main(String[] args) {
        Draw draw = new Circle(1d).new Draw();
    }

}

class Circle {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    class Draw {

    }

}