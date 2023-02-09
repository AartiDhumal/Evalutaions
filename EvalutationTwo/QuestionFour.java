package EvalutationTwo;

public class QuestionFour {
    public void pattern(){
        for(int i=1;i<=4;i++){
            for(int j=3;j>=i;j--){
                System.out.print("  ");
            }
            for(int k=1;k<=i;k++){
                System.out.print("  * ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        QuestionFour questionFour=new QuestionFour();
        questionFour.pattern();
    }
}
// Output:
//        *
//      *   *
//    *   *   *
//  *   *   *   *
