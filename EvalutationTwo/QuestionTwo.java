package EvalutationTwo;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class QuestionTwo {
    public void dates(DayOfWeek day){
        switch (day){

            case MONDAY: System.out.println("Its a start of week");
                break;
            case TUESDAY:  System.out.println("Its a second day of week");
                break;
            case WEDNESDAY:System.out.println("Its a third day of week");
                break;
            case THURSDAY:System.out.println("Its a fourth day of week");
            break;
            case FRIDAY: System.out.println("yay!!! Its a last day of week....enjoy your weekend");
                break;
            case SATURDAY: System.out.println("Its a Weekend!!!majjani life :)");
                break;
            case SUNDAY:System.out.println("Last day of weekend :(");
                break;
        }
    }
    public void days(DayOfWeek day){
        String today=String.valueOf( day);
        String weekdays[]={"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};
        for(int i=0;i<7;i++){
            if(weekdays[i]!=today){
                System.out.println(weekdays[i]);
            }
        }


    }
    public static void main(String args[]){
        QuestionTwo questionTwo=new QuestionTwo();
        LocalDate currentDate=LocalDate.now();
        DayOfWeek dow=currentDate.getDayOfWeek();

        questionTwo.dates(dow);
        questionTwo.days(dow);
    }
}
//Output:-
//Its a fourth day of week
//MONDAY
//TUESDAY
//WEDNESDAY
//FRIDAY
//SATURDAY
//SUNDAY
//
//Process finished with exit code 0