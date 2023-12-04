package Day1;// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int sum = 0;
        HashMap<String, Integer> textToInt = new HashMap<>();
        textToInt.put("one", 1);
        textToInt.put("two", 2);
        textToInt.put("three", 3);
        textToInt.put("four", 4);
        textToInt.put("five", 5);
        textToInt.put("six", 6);
        textToInt.put("seven", 7);
        textToInt.put("eight", 8);
        textToInt.put("nine", 9);

        try{
            File myObj = new File("C:\\Users\\axcho\\Desktop\\advent1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
                String fileStr = myReader.nextLine();
                int firstInt = 0;
                int firstChar = 0;
                int firstIntPlace = 0;
                int firstCharPlace = 0;

                for (int i = 0; i < fileStr.length(); i++){
                    if (Character.isDigit(fileStr.charAt(i))){
                        firstInt = Character.getNumericValue(fileStr.charAt(i)) * 10;
                        firstIntPlace = i;
                        break;
                    }
                }
                for(Map.Entry<String, Integer> entry : textToInt.entrySet()) {
                    if ((fileStr.indexOf(entry.getKey()) <= firstCharPlace | firstCharPlace == 0 ) & fileStr.contains(entry.getKey())) {
                        firstCharPlace = fileStr.indexOf(entry.getKey());
                        firstChar = entry.getValue() * 10;
                    }
                }
                if ( firstChar == 0 ) sum += firstInt;
                else if (firstInt == 0) sum += firstChar;
                else if (firstIntPlace > firstCharPlace) sum += firstChar;
                else sum += firstInt;

                firstCharPlace = fileStr.length();

                for ( int i = fileStr.length() - 1; i >= 0; i--){
                    if (Character.isDigit(fileStr.charAt(i))){
                        firstInt = Character.getNumericValue(fileStr.charAt(i));
                        firstIntPlace = i;
                        break;
                    }
                }
                for(Map.Entry<String, Integer> entry : textToInt.entrySet()) {
                    if ((fileStr.lastIndexOf(entry.getKey()) > firstCharPlace | firstCharPlace == fileStr.length()) & fileStr.contains(entry.getKey())) {
                        firstCharPlace = fileStr.lastIndexOf(entry.getKey());
                        firstChar = entry.getValue();
                    }
                }
                if ( firstChar == 0 ) sum += firstInt;
                else if (firstInt == 0) sum += firstChar;
                else if (firstIntPlace < firstCharPlace) sum += firstChar;
                else sum += firstInt;
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
