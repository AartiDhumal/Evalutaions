package Evaluation17_02;
class Address{
    int laneNo,pincode;
    String area,city,state,country;

    public Address(int laneNo, int pincode, String area, String city, String state, String country) {
        this.laneNo = laneNo;
        this.pincode = pincode;
        this.area = area;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "laneNo=" + laneNo +
                ", pincode=" + pincode +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
class Teacher{
    int id;
    String name;
    Address address;

    public Teacher(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
class Student{
    int id;
    String name;
    Address address;

    public Student(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
public class StudentTeacher{
    public static void main(String args[]){
        Address address = new Address(12,20287,"sunita nagar","pune","Maharastra","india");
        Teacher teacher = new Teacher(232,"Aarti",address);
        Student student = new Student(121,"Yash",address);
        System.out.println(teacher);
        System.out.println(student);
    }
}
//Teacher{id=232, name='Aarti', address=Address{laneNo=12, pincode=20287, area='sunita nagar', city='pune', state='Maharastra', country='india'}}
//Student{id=121, name='Yash', address=Address{laneNo=12, pincode=20287, area='sunita nagar', city='pune', state='Maharastra', country='india'}}
//
//Process finished with exit code 0