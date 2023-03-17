package evaluation17_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class ManageDatabase {
    Connection connection = Connectivity.connection();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public void retrieve(){
        System.out.println("enter 1 for student data\n enter 2 for teacher data");
        try {
            int choice=Integer.parseInt(bufferedReader.readLine());
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            if(choice==1){
                resultSet = statement.executeQuery("select * from student");
                while(resultSet.next()){
                    System.out.println("id : "+resultSet.getInt(1)+" name : "+resultSet.getString(2)+" subject : "+resultSet.getString(3)+" city : "+resultSet.getString(4)+" marks : "+resultSet.getInt(5));
                }
            }
            else if(choice==2){
                resultSet = statement.executeQuery("select * from teacher");
                while(resultSet.next()){
                    System.out.println("id : "+resultSet.getInt(1)+" name : "+resultSet.getString(2)+" subject : "+resultSet.getString(3)+" city : "+resultSet.getString(4)+" salary : "+resultSet.getInt(5)+" experience : "+resultSet.getInt(6));
                }
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(){
        System.out.println("Enter id of teacher");
        try {
            int id = Integer.parseInt(bufferedReader.readLine());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from teacher where id = "+id);
            if(resultSet.next()) {
                System.out.println("enter updated salary");
                int salary = Integer.parseInt(bufferedReader.readLine());
                PreparedStatement preparedStatement = connection.prepareStatement("update teacher set salary = ? where id =?");
                preparedStatement.setInt(1, salary);
                preparedStatement.setInt(2, id);
                preparedStatement.execute();
            }
            else{
                System.out.println("Id does not exist");
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(){
        System.out.println("Enter id of student to be deleted");
        try {
            int id = Integer.parseInt(bufferedReader.readLine());
            Statement statement = connection.createStatement();
            String query  = "select * from student where sid = "+id;
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                PreparedStatement preparedStatement = connection.prepareStatement("delete from student where sid = ?");
                preparedStatement.setInt(1,id);
                preparedStatement.execute();
            }
            else {
                System.out.println("You have entered wrong ID");
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void insert(){
        System.out.println("enter 1 for student data insert");

        try {
            System.out.println("Enter id of student");
            int id = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Enter name");
            String name = bufferedReader.readLine();
            System.out.println("enter subject");
            String subject = bufferedReader.readLine();
            System.out.println("Enter city");
            String city = bufferedReader.readLine();
            System.out.println("Enter marks");
            int marks = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Enter teacher id");
            int tid = Integer.parseInt(bufferedReader.readLine());
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student values(?,?,?,?,?,?)");
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,subject);
            preparedStatement.setString(4,city);
            preparedStatement.setInt(5,marks);
            preparedStatement.setInt(6,tid);
            preparedStatement.execute();
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void fetchStudent(){
        try {
            Statement statement = connection.createStatement();
            String query = "select * from student where sname like 'z%'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                System.out.println("id : "+resultSet.getInt(1)+" name : "+resultSet.getString(2)+" subject : "+resultSet.getString(3)+" city : "+resultSet.getString(4)+" marks : "+resultSet.getInt(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void fetchTeacher(){
        try {
            Statement statement = connection.createStatement();
            String query = "select * from teacher where expirence >= 5 and salary >= 50000";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                System.out.println("id : "+resultSet.getInt(1)+" name : "+resultSet.getString(2)+" subject : "+resultSet.getString(3)+" city : "+resultSet.getString(4)+" Salary : "+resultSet.getInt(5)+" Experience : "+resultSet.getInt(6));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void fetchBoth(){
        try {
            Statement statement = connection.createStatement();
            String query = "select * from student s join teacher t on t.id=s.tid where t.city in('pune','mumbai') and t.name like '%a'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                System.out.println("id : "+resultSet.getInt(1)+" name : "+resultSet.getString(2)+" subject : "+resultSet.getString(3)+" city : "+resultSet.getString(4)+" Salary : "+resultSet.getInt(5)+" Experience : "+resultSet.getInt(6));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
