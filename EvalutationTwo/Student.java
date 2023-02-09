package EvalutationTwo;

public class Student {
    int id;
    double marks;
    String firstName,secondName,education,city;
    public Student(int id,String firstName,String secondName,String education,String city,int marks){
        this.id=id;
        this.firstName=firstName;
        this.secondName=secondName;
        this.education=education;
        this.city=city;
        this.marks=marks;
    }
    public void checkMarks(){
        if(marks>=70){
            System.out.println("Distinction");
        } else if (marks>=60) {
            System.out.println("First class");
        }
        else if (marks>=55) {
            System.out.println("Higher second class");
        }
        else if (marks>=50) {
            System.out.println("Second class");
        }
        else if (marks>=35) {
            System.out.println("Pass class");
        }
        else{
            System.out.println("Fail");
        }
    }
    public static void main(String args[]){
        Student student=new Student(11,"Yash","Paliwal","MCA","Agra",75);
        student.checkMarks();
    }
}
//output:
//Distinction
//
//Process finished with exit code 0