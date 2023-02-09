package EvalutationTwo;

public class QuestionThree {
    public void oddEven(int[] arr){
        int sum=0,mul=1;
        for(int i=0;i<arr.length;i++){
            if(i%2==0){
                sum+=arr[i];
            }
            else{
                mul*=arr[i];
            }
        }
        System.out.println("Sum : "+sum);
        System.out.println("Multiplication : "+mul);
    }
    public static void main(String args[]){
        int arr[]={2,4,6,8,10,12,7,3,8,3,9};
        QuestionThree questionThree=new QuestionThree();
        questionThree.oddEven(arr);
    }
}
//output:-
//Sum : 42
//Multiplication : 3456
//
//Process finished with exit code 0