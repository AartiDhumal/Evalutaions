package Evaluation17_02;
interface test{
    void square();
}
class Arithmetic implements test{
    private int n;
    public void setN(int n) {
        this.n = n;
    }
    @Override
    public void square() {
        System.out.println("Square of the number is "+n*n);
    }
}
public class TestInt {
    public static void main(String args[]){
        Arithmetic arithmetic =new Arithmetic();
        arithmetic.setN(56);
        arithmetic.square();
    }
}
//Square of the number is 3136
//
//Process finished with exit code 0