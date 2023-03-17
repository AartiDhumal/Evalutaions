package evaluation17_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentTeacher {
    public static void main(String[] args) throws IOException {
        Boolean flag = true;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ManageDatabase manageDatabase = new ManageDatabase();
        while(flag){
            System.out.println("1: Retrieve data\n2:Update data\n3:delete data\n4:insert data\n5:fetch student data\n6:fetch teacher data\n7:fetch both\n0:Exit");
            int choice = Integer.parseInt(bufferedReader.readLine());
            switch (choice){
                case 1: manageDatabase.retrieve();
                break;
                case 2: manageDatabase.update();
                break;
                case 3: manageDatabase.delete();
                break;
                case 4: manageDatabase.insert();
                break;
                case 5: manageDatabase.fetchStudent();
                break;
                case 6: manageDatabase.fetchTeacher();
                break;
                case 7: manageDatabase.fetchBoth();
                break;
                case 0: flag=false;
                break;
                default:
                    System.out.println("You  have entered wrong choice");
            }
        }
    }
}
//1: Retrieve data
//2:Update data
//3:delete data
//4:insert data
//5:fetch student data
//6:fetch teacher data
//7:fetch both
//0:Exit
//1
//enter 1 for student data
// enter 2 for teacher data
//1
//id : 1 name : yash subject : java city : agra marks : 100
//id : 2 name : aniket subject : j-script city : pune marks : 80
//id : 3 name : aryaman subject : j-script city : indore marks : 85
//id : 4 name : tanmay subject : physics city : pune marks : 75
//id : 5 name : zudy subject : j-script city : pune marks : 81
//1: Retrieve data
//2:Update data
//3:delete data
//4:insert data
//5:fetch student data
//6:fetch teacher data
//7:fetch both
//0:Exit
//1
//enter 1 for student data
// enter 2 for teacher data
//2
//id : 1 name : aarti subject : java city : pune salary : 35000 experience : 2
//id : 2 name : anirudha subject : j-script city : pune salary : 100000 experience : 4
//id : 3 name : abca subject : physics city : mumbai salary : 80000 experience : 7
//1: Retrieve data
//2:Update data
//3:delete data
//4:insert data
//5:fetch student data
//6:fetch teacher data
//7:fetch both
//0:Exit
//2
//Enter id of teacher
//1
//enter updated salary
//39000
//1: Retrieve data
//2:Update data
//3:delete data
//4:insert data
//5:fetch student data
//6:fetch teacher data
//7:fetch both
//0:Exit
//3
//Enter id of student to be deleted
//4
//1: Retrieve data
//2:Update data
//3:delete data
//4:insert data
//5:fetch student data
//6:fetch teacher data
//7:fetch both
//0:Exit
//1
//enter 1 for student data
// enter 2 for teacher data
//1
//id : 1 name : yash subject : java city : agra marks : 100
//id : 2 name : aniket subject : j-script city : pune marks : 80
//id : 3 name : aryaman subject : j-script city : indore marks : 85
//id : 5 name : zudy subject : j-script city : pune marks : 81
//id : 6 name : zakir subject : hindi city : pune marks : 98
//1: Retrieve data
//2:Update data
//3:delete data
//4:insert data
//5:fetch student data
//6:fetch teacher data
//7:fetch both
//0:Exit
//1: Retrieve data
//2:Update data
//3:delete data
//4:insert data
//5:fetch student data
//6:fetch teacher data
//7:fetch both
//0:Exit
//4
//Enter id of student
//6
//Enter name
//zakir
//enter subject
//hindi
//Enter city
//pune
//Enter marks
//98
//Enter teacher id
//1
//1: Retrieve data
//2:Update data
//3:delete data
//4:insert data
//5:fetch student data
//6:fetch teacher data
//7:fetch both
//0:Exit
//5
//id : 5 name : zudy subject : j-script city : pune marks : 81
//id : 6 name : zakir subject : hindi city : pune marks : 98
//1: Retrieve data
//2:Update data
//3:delete data
//4:insert data
//5:fetch student data
//6:fetch teacher data
//7:fetch both
//0:Exit
//6
//id : 3 name : abca subject : physics city : mumbai Salary : 80000 Experience : 7
//1: Retrieve data
//2:Update data
//3:delete data
//4:insert data
//5:fetch student data
//6:fetch teacher data
//7:fetch both
//0:Exit
//7
//id : 2 name : aniket subject : j-script city : pune Salary : 80 Experience : 2
//id : 3 name : aryaman subject : j-script city : indore Salary : 85 Experience : 2
//id : 5 name : zudy subject : j-script city : pune Salary : 81 Experience : 2
//id : 4 name : tanmay subject : physics city : pune Salary : 75 Experience : 3
//1: Retrieve data
//2:Update data
//3:delete data
//4:insert data
//5:fetch student data
//6:fetch teacher data
//7:fetch both
//0:Exit
//0
//
//Process finished with exit code 0