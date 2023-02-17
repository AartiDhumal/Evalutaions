package Evaluation17_02;

import java.util.Scanner;

class Vehicle{
    int price;
    String company;
    Vehicle(int price, String company){
        this.price=price;
        this.company=company;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "price=" + price +
                ", company='" + company + '\'' +
                '}';
    }
}
class LightMotorVehicle extends Vehicle{
    int mileage;
    LightMotorVehicle(int price, String company,int mileage) {
        super(price, company);
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "LightMotorVehicle{" +
                "mileage=" + mileage +
                ", price=" + price +
                ", company='" + company + '\'' +
                '}';
    }
}
class HeavyMotorVehicle extends Vehicle{
    int capacityInTon;
    HeavyMotorVehicle(int price, String company,int capacityInTon) {
        super(price, company);
        this.capacityInTon = capacityInTon;
    }

    @Override
    public String toString() {
        return "HeavyMotorVehicle{" +
                "capacityInTon=" + capacityInTon +
                ", price=" + price +
                ", company='" + company + '\'' +
                '}';
    }
}
public class VehicleManagement {
    public static void main(String args[]){
        Vehicle vehicle[]=new Vehicle[10];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<10;i++){
            System.out.println("Enter 1 for light vehicle 2 for heavy");
            int choice = sc.nextInt();
            if(choice==1){
                vehicle[i] = new LightMotorVehicle(50000,"MARUTI",15);
            }
            else if(choice==2){
                vehicle[i] = new HeavyMotorVehicle(120000,"TATA",1000);
            }

        }
        for(int i=0;i<10;i++){
            System.out.println(vehicle[i]);
        }
    }
}
//"C:\Program Files\Java\jdk1.8.0_361\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.2\lib\idea_rt.jar=54162:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.2\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_361\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\rt.jar;C:\Users\Coditas\IdeaProjects\Evaluation\out\production\Evaluation" Evaluation17_02.VehicleManagement
//Enter 1 for light vehicle 2 for heavy
//1
//Enter 1 for light vehicle 2 for heavy
//2
//Enter 1 for light vehicle 2 for heavy
//1
//Enter 1 for light vehicle 2 for heavy
//2
//Enter 1 for light vehicle 2 for heavy
//1
//Enter 1 for light vehicle 2 for heavy
//2
//Enter 1 for light vehicle 2 for heavy
//1
//Enter 1 for light vehicle 2 for heavy
//2
//Enter 1 for light vehicle 2 for heavy
//1
//Enter 1 for light vehicle 2 for heavy
//2
//LightMotorVehicle{mileage=15, price=50000, company='MARUTI'}
//HeavyMotorVehicle{capacityInTon=1000, price=120000, company='TATA'}
//LightMotorVehicle{mileage=15, price=50000, company='MARUTI'}
//HeavyMotorVehicle{capacityInTon=1000, price=120000, company='TATA'}
//LightMotorVehicle{mileage=15, price=50000, company='MARUTI'}
//HeavyMotorVehicle{capacityInTon=1000, price=120000, company='TATA'}
//LightMotorVehicle{mileage=15, price=50000, company='MARUTI'}
//HeavyMotorVehicle{capacityInTon=1000, price=120000, company='TATA'}
//LightMotorVehicle{mileage=15, price=50000, company='MARUTI'}
//HeavyMotorVehicle{capacityInTon=1000, price=120000, company='TATA'}
//
//Process finished with exit code 0