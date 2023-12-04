package Day1;// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int sum = 0;

        try{
            File myObj = new File("C:\\Users\\axcho\\Desktop\\advent1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
                String fileStr = myReader.nextLine();
                for (int i = 0; i <= fileStr.length() ;i++){
                    if (Character.isDigit(fileStr.charAt(i))){
                        sum += Character.getNumericValue(fileStr.charAt(i)) * 10;
                        break;
                    }
                }
                for ( int i = fileStr.length() - 1; i >= 0; i--){
                    if (Character.isDigit(fileStr.charAt(i))){
                        sum += Character.getNumericValue(fileStr.charAt(i));
                        break;
                    }
                }
                //System.out.println(fileStr);
            }
            System.out.println(sum);
        }catch (FileNotFoundException e){
            System.out.println("FileNotFound");
        }
    }
}
// Press Alt+Enter with your caret at the highlighted text to see how
// IntelliJ IDEA suggests fixing it.



//System.out.print("Hello and welcome!");

// Press Shift+F10 or click the green arrow button in the gutter to run the code.
//for (int i = 1; i <= 5; i++) {

// Press Shift+F9 to start debugging your code. We have set one breakpoint
// for you, but you can always add more by pressing Ctrl+F8.
//  System.out.println("i = " + i);
//}
