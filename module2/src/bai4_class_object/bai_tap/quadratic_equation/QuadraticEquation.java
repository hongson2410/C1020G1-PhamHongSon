package bai4_class_object.bai_tap.quadratic_equation;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    private double delta;
    private double root1;
    private double root2;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }



    public double getDiscriminant() {
        delta= (getB()*getB())-4*getA()*getC();
        return delta;
    }

    public String getCheck() {
        if (getDiscriminant()>0){
            return "x1: " + getRoot1() +" " + "x2: " +getRoot2();
        } else if (getDiscriminant()==0){
            return "x: " + getRoot1();
        } else {
            return "The equation has no roots";
        }
    }

    public double  getRoot1() {
        root1=(-getB()+Math.pow(getDiscriminant(),0.5))/2*getA();
        return root1;
    }

    public double getRoot2() {
        root2=(-getB()-Math.pow(getDiscriminant(),0.5))/2*getA();
        return root2;
    }
}
