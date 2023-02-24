package evaluation2402;
import java.util.*;
class PerformOperations{
    String s;
    PerformOperations(String s){
        this.s=s;
    }
    void countChar(){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' ')
                count++;
        }
        System.out.println("Number of Character are "+count);
    }
    void countVowel(){
        int count=0;
        String n="";
        String str1=s.toLowerCase();
        for(int i=0;i<str1.length();i++){
            char ch = str1.charAt(i);
            if(ch=='a' || ch=='e'||ch=='i' || ch=='o'||ch=='u'){
                count++;
                n+=ch;
            }
        }
        System.out.println("Number of vowels are :: "+count+" new string is "+n);
    }
    void countToken(){
        StringTokenizer stringTokenizer = new StringTokenizer(s);
        System.out.println("Number of tokens are :: "+stringTokenizer.countTokens());
    }
    void NewString(){
        String newString="";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='a' || ch=='e'||ch=='i' || ch=='o'||ch=='u'||ch=='A' || ch=='E'||ch=='I' || ch=='O'||ch=='U' || ch==' ')
                newString+=(char)ch;
            else
                newString+=(char)(ch+1);

        }
        System.out.println("New string is "+newString);
    }
}
public class CalcutaleString {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter 1 string");
        String str=scanner.nextLine();
        PerformOperations performOperations = new PerformOperations(str);
        Boolean flag=true;
        while(flag) {
            System.out.println("Enter 1 for count Character, 2 for number of token ,3 for number of vowels ,4 for new string and 5 for exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    performOperations.countChar();
                    break;
                case 2:
                    performOperations.countToken();
                    break;
                case 3:
                    performOperations.countVowel();
                    break;
                case 4:
                    performOperations.NewString();
                    break;
                case 5:
                    flag = false;
            }
        }
    }
}
//"C:\Program Files\Java\jdk1.8.0_361\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.2\lib\idea_rt.jar=62218:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.2\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_361\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_361\jre\lib\rt.jar;C:\Users\Coditas\IdeaProjects\Evaluation\out\production\Evaluation" evaluation2402.CalcutaleString
//Please Enter 1 string
//yash paliwal
//Enter 1 for count Character, 2 for number of token ,3 for number of vowels ,4 for new string and 5 for exit
//1
//Number of Character are 11
//Enter 1 for count Character, 2 for number of token ,3 for number of vowels ,4 for new string and 5 for exit
//2
//Number of tokens are :: 2
//Enter 1 for count Character, 2 for number of token ,3 for number of vowels ,4 for new string and 5 for exit
//3
//Number of vowels are :: 4 new string is aaia
//Enter 1 for count Character, 2 for number of token ,3 for number of vowels ,4 for new string and 5 for exit
//4
//New string is zati qamixam
//Enter 1 for count Character, 2 for number of token ,3 for number of vowels ,4 for new string and 5 for exit
//5
//
//Process finished with exit code 0
