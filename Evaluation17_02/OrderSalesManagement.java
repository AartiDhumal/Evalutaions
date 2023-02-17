package Evaluation17_02;
abstract class Order{
    int memberId;
    String description;
    abstract void display();

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", description='" + description + '\'' +
                '}';
    }
}
class PurchaseOrder extends Order{
    String vendorName;

    void accept(int memberId, String description,String vendorName) {
        super.memberId = memberId;
        super.description = description;
        this.vendorName = vendorName;
    }

    @Override
    void display() {
        System.out.println("member id : "+memberId+" description is : "+description+" vendorname is :  "+vendorName);
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "vendorName='" + vendorName + '\'' +
                ", memberId=" + memberId +
                ", description='" + description + '\'' +
                '}';
    }
}
class SalesOrder extends  Order{
    String customerName;

    void accept(int memberId, String description,String customerName) {
        super.memberId = memberId;
        super.description = description;
        this.customerName = customerName;
    }

    @Override
    void display() {
        System.out.println("member id : "+memberId+" description is : "+description+" customername is :  "+customerName);
    }

    @Override
    public String toString() {
        return "SalesOrder{" +
                "customerName='" + customerName + '\'' +
                ", memberId=" + memberId +
                ", description='" + description + '\'' +
                '}';
    }
}
public class OrderSalesManagement {
    public static void main(String args[]){
        Order order = new Order() {
            @Override
            void display() {
                System.out.println("This is a abstract class");
            }
        };
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.accept(101,"Soap","Cinthol");
        purchaseOrder.display();
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.accept(101,"Soap","Yash");
        salesOrder.display();

    }
}
//
//member id : 101 description is : Soap vendorname is :  Cinthol
//        member id : 101 description is : Soap customername is :  Yash
//
//        Process finished with exit code 0