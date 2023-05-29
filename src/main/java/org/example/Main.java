package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public interface Equation { }

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
    }

    public static class Linear implements Equation {

        private double m;
        private double b;

        public Linear(double slope, double yIntercept) {
            this.m = slope;
            this.b = yIntercept;
        }

        public double f(double x) {
            return m * x + b; // y = mx + b
        }

        public Linear getParallel(Vector2 point) {
            return new Linear(m, b - m * point.x);
        }

        public Linear getPerpendicular(Vector2 point) {
            double j = -1 / m;
            return new Linear(j, b).getParallel(point);
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
    }

    public static void main(String[] args) {
        new Main();
    }
}