package fr.pierre.androidcalculator;

public class Service {
    public double nb1;
    public double nb2;
    public String operator;

    public Service(double nb1, double nb2, String operator) {
        this.nb1 = nb1;
        this.nb2 = nb2;
        this.operator = operator;
    }

    public double getNb1() {
        return nb1;
    }

    public void setNb1(double nb1) {
        this.nb1 = nb1;
    }

    public double getNb2() {
        return nb2;
    }

    public void setNb2(double nb2) {
        this.nb2 = nb2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
