package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public interface Equation {
        double f(double x);
    }

    public interface ExactForm {
        double compute();
    }

    public static class SqrtForm implements ExactForm {

        private final double v;

        public SqrtForm(double v) {
            this.v = v;
        }

        @Override
        public double compute() {
            return Math.sqrt(v);
        }

        @Override
        public String toString() {
            return "sqrt(" + v + ")";
        }
    }

    public static class Vector2 {

        private double x;
        private double y;

        public Vector2(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public SqrtForm dist(Vector2 point) {
            return new SqrtForm(Math.pow(point.y - y, 2) + Math.pow(point.x - x, 2));
        }
    }

    public static class Linear implements Equation {

        private double m;
        private double b;

        public Linear(double slope, double yIntercept) {
            this.m = slope;
            this.b = yIntercept;
        }

        @Override
        public double f(double x) {
            return m * x + b; // y = mx + b
        }

        public Linear getParallel(Vector2 point) {
            return new Linear(m, point.y - (m * point.x));
        }

        public Linear getPerpendicular(Vector2 point) {
            double j = -1 / m;
            return new Linear(j, b).getParallel(point);
        }

        public Vector2 getSystem(Linear linear) {
            double x = (linear.b - b) / (m - linear.m);
            return new Vector2(x, linear.f(x));
        }

        public SqrtForm getClosestDistance(Vector2 point) {
            return getPerpendicular(point).getSystem(this).dist(point);
        }

        public double getSlope() {
            return m;
        }

        public double getYIntercept() {
            return b;
        }

        @Override
        public String toString() {
            return m + "x + " + b;
        }
    }

    public Main() {
        System.out.println("17) " + new Linear(-1, 8).getParallel(new Vector2(3, -4)));
        System.out.println("19) " + new Linear(3, -5).getParallel(new Vector2(2, 0)));
        System.out.println("21) " + new Linear(-2, 8).getPerpendicular(new Vector2(6, -1)));
        System.out.println("23) " + new Linear(4, -7).getPerpendicular(new Vector2(8, 2)));
        System.out.println("25) " + new Linear(-1, 4).getClosestDistance(new Vector2(2, -1)));
    }

    public static void main(String[] args) {
        new Main();
    }
}