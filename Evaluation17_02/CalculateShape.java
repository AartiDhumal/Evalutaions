package Evaluation17_02;

class Reactangle {
    private int length, breadth;

    public void setLength(int length) {
        this.length = length;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public int getLength() {
        return length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void parimeter() {
        System.out.println("Parimeter of rectangle is : "+(length+breadth)/2);
    }


    public void area() {
        System.out.println("Area of rectangle is : "+(length*breadth));
    }
}
public class CalculateShape {
    public static void main(String args[]){
        Reactangle reactangle = new Reactangle();
        reactangle.setLength(30);
        reactangle.setBreadth(50);
        reactangle.parimeter();
        reactangle.area();
    }
}
//Parimeter of rectangle is : 40
//Area of rectangle is : 1200
//
//Process finished with exit code 0