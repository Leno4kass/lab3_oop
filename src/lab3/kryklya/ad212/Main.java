package lab3.kryklya.ad212;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner= new Scanner(System.in);

        //user enters a string
        System.out.print("Enter the string: ");
        String text= scanner.nextLine();

        //results all methods
        System.out.println("1.Does the string end with \"ed\"? -  " + hasEdInEnd(text));
        System.out.println("2.The sum of the found digits in the string: " + sumAllDigitsInString(text));
        System.out.println("3.The length of the longest block of characters in a string: " + longestBlockLength(text));
        System.out.println("4.Found words in a string: ");
        foundWords(text);


        //user enters 2 strings
        System.out.print("Enter the first string: ");
        String text1= scanner.nextLine();
        System.out.print("Enter the second string: ");
        String text2= scanner.nextLine();

        //result of the 5th method
        System.out.println("A string of characters from each of the previous strings: " + mixedStrings(text1,text2));
    }


    //checks if the string has "ed" in its end
    static boolean hasEdInEnd(String text) {
        return text.endsWith("ed");
    }

    //counts sum of digits in the string
    static int sumAllDigitsInString(String text) {
        int sum=0;
        for (int i=0; i<text.length(); i++) {
            if(Character.isDigit(text.charAt(i))) {
                sum+=text.charAt(i)-'0';   //if there are no digits, 0 is returned
            }
        }
        return sum;
    }

    //count the longest block of identical symbols in the string
    static int longestBlockLength(String text) {
        if (text.length()==0)
            return 0;

        int maxLength=1;
        int index=1;
        for (int i=0; i<text.length()-1; i++) {

            if(text.charAt(i)==text.charAt(i+1)) {
                index++;
            }
            else {
                if (maxLength<index) {
                    maxLength=index;
                }
                index=1;
            }
        }
        if (maxLength<index) {
            maxLength=index;
        }

        return maxLength;
    }

    //prints the found words in a line separately
    static void foundWords(String text) {
        if (text.length()==0) {
            return;
        }

        int firstSymbol=0;
        for (int i=0; i<text.length(); i++) {
            if (text.charAt(i)==' ') {
                if (i!=0 && text.charAt(i-1)!=' ')
                {
                    System.out.println(text.substring(firstSymbol,i));
                }
                firstSymbol=i+1;
            }
        }
        if (text.charAt(text.length()-1)!=' ') {  //output last word
            System.out.println(text.substring(firstSymbol));
        }
    }

    //creates mixed string from 2 other strings
    static String mixedStrings(String text1, String text2) {
        String text;
        StringBuilder s = new StringBuilder();
        for (int i=0; i<text1.length() && i <text2.length(); i++) {
            s.append(text1.charAt(i));
            s.append(text2.charAt(i));
        }

        text=s.toString();


        if (text1.length() > text2.length()) {
            text+=text1.substring(text2.length());
        }
        else if (text1.length() < text2.length()) {
            text+=text2.substring(text1.length());
        }

        return text;
    }
}