import java.util.*;

public class StringBasics {

    public static void printletters(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i) + " ");
        }
    }

    public static void main(String[] args) {
        // char arr[] = { 'a', 'b', 'c', 'd' };
        // String str1 = "abcd";
        // String str2 = new String("xyz");

        // // Strings are immutable

        // Scanner s = new Scanner(System.in);
        // String name = s.nextLine();
        // System.out.println(name);

        // // length function
        // System.out.println(name.length());

        // concatanation
        // String fname = "Tirth";
        // String lname = "Sakariya";
        // System.out.println(fname + " " + lname);

        // charAt method
        // String fname = "Tirth";
        // System.out.println(fname.charAt(0));
        // printletters(fname);

        // comapre function
        // String s1 = "Tony";
        // String s2 = "Tony";
        // String s3 = new String("Tony");

        // if (s1 == s2) {
        // System.out.println("Strings are equals");
        // } else {
        // System.out.println("Strings are not equals");
        // }
        // if (s1 == s3) {
        // System.out.println("Strings are equals");
        // } else {
        // System.out.println("Strings are not equals");
        // }
        // if (s1.equals(s3)) {
        // System.out.println("Strings are equals");
        // } else {
        // System.out.println("Strings are not equals");
        // }

        // Substring
        // String str = "helloworld";
        // String substr = "";
        // int si = 0;
        // int ei = 5;
        // for (int i = si; i < ei; i++) {
        // substr += str.charAt(i);
        // }
        // System.out.println("Substring is : " + substr);
        // // with java function .substring()
        // System.out.println("with java function Substring is : " + str.substring(0,
        // 5));

        // StringBuilder //it is memory efficent
        StringBuilder sb = new StringBuilder("");
        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(ch);
        }
        System.out.println(sb);
        System.out.println(sb.length());
    }
}
