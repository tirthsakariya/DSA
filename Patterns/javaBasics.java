import java.util.*;

public class javaBasics {

    // Functions / Methods

    public static void helloworld() {
        System.out.println("hello world");
    }

    public static int calSum(int a, int b) { // parameters // formal parameters
        int sum = a + b;
        return sum;
    }

    // call by value
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    // product of a & b
    public static int multiply(int a, int b) {
        int prod = a * b;
        return prod;
    }

    // factorial
    public static int fact(int n) {
        int f = 1;

        for (int i = 1; i <= n; i++) {
            f = f * i;
        }
        return f;
    }

    // binomial coeffiecent
    public static int bincoeff(int n, int r) {
        int nfact = fact(n);
        int rfact = fact(r);
        int nmrfact = fact(n - r);

        int bincoeff = (nfact) / (rfact * nmrfact);
        return bincoeff;
    }

    // function overloading with params

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    // function overloading with datataypes

    public static float sum(float a, float b) {
        return a + b;
    }

    // prime or not ?
    public static boolean isprime(int n) {
        boolean isprime = true;
        for (int i = 2; i <= n - 1; i++) {
            if (n % i == 0) {
                isprime = false;
                break;
            }
        }
        return isprime;
    }

    // binary to deecimal
    public static void bintodec(int binnum) {
        int mynum = binnum;
        int pow = 0;
        int decnum = 0;

        while (binnum > 0) {
            int lastdigit = binnum % 10;
            decnum += (lastdigit * (int) Math.pow(2, pow));
            pow++;
            binnum = binnum / 10;
        }
        System.out.println("decimal of " + mynum + " =  " + decnum);
    }

    // decimal to binary
    public static void dectobin(int n) {
        int mynum = n;
        int pow = 0;
        int binnum = 0;

        while (n > 0) {
            int rem = n % 2;
            binnum += (rem * (int) Math.pow(10, pow));
            pow++;
            n = n / 2;
        }
        System.out.println("binary of " + mynum + " =  " + binnum);
    }

    public static void main(String[] args) {

        // decimal to bin.
        dectobin(256);

        // bin to decimal
        // bintodec(101);

        // prime
        // System.out.println(isprime(125));

        // function overloading
        // System.out.println(sum(3, 5));
        // System.out.println(sum(3, 5, 7));
        // System.out.println(sum(3.5f, 5.5f));

        // bin. coeff.
        // System.out.println(bincoeff(5, 2));

        // factorial cal
        // System.out.println(fact(5));

        // product of a & b
        // int a = 3;
        // int b = 5;
        // int res = multiply(a, b);
        // System.out.println(a + "*" + b + "=" + res);

        // call by value
        // int a = 5;
        // int b = 10;
        // swap(a, b);
        // System.out.println(a);
        // System.out.println(b);

        // function
        // Scanner s = new Scanner(System.in);
        // int a = s.nextInt();
        // int b = s.nextInt();
        // int res = calSum(a, b); // arguments // actual parameters
        // System.out.println("sum is " + res);

        // helloworld();

        // System.out.println("hello world");
        // System.out.println("****\n***\n**\n*");
        //
        // int a = 5;
        // int b = 10;
        // byte c = 8;
        // char d = 'a';
        // boolean var = false;
        // float f = 10.5f;
        // String n = "tirth";
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(n);
        //
        // // sum of a & b & Arithmetic
        // System.out.println("sum is " + (a + b));
        //
        //
        // Scanner s = new Scanner(System.in);
        // String name = s.nextLine();
        // System.out.println(name);

        // int a = s.nextInt();
        // int b = s.nextInt();
        // System.out.println(a * b);

        // float r = s.nextFloat();
        // float ar = 3.14f * r * r;
        // System.out.println(ar);

        // float a = 25.12f;
        // int b = (int) a;
        // System.out.println(b);

        // operators
        // int a = 10;
        // int b = 5;

        // System.out.println(a + b);// arithmetic
        // System.out.println(a - b);
        // System.out.println(a * b);
        // System.out.println(a / b);
        // System.out.println(a % b);
        // System.out.println(++a);// unary
        // System.out.println(b = a++);
        // System.out.println(a == b);// reletional
        // System.out.println(a != b);
        // System.out.println(a > b);
        // System.out.println(a < b);
        // System.out.println(a >= b);
        // System.out.println(a <= b);
        // System.out.println((3 > 2) && !(5 < 0)); // logical
        // System.out.println((3 > 2) || (5 < 0));
        // System.out.println(a -= 10);// assignmental

        // int age = 22;
        // if (age >= 18) {
        // System.out.println("vote now");
        // } else {
        // System.out.println("can't vote");
        // }

        // int a = 1;
        // int b = 5;

        // if (a >= b) {
        // System.out.println("a is largest of 2");
        // } else {
        // System.out.println("b is largest of 2");
        // }

        // Scanner s = new Scanner(System.in);

        // odd even ques..

        // int a= s.nextInt();
        // if (a % 2 == 0) {
        // System.out.println("even number");
        // } else {
        // System.out.println("odd number");
        // }

        // income tax calculator

        // int inc = s.nextInt();
        // if (inc < 500000)
        // System.out.println("0 % tax");
        // else if (inc >= 500000 && inc <= 1000000)
        // System.out.println("with 20 % tax add tax is " + (inc * 0.2));
        // else
        // System.out.println("with 30 % tax add tax is " + (inc * 0.3));

        // largest of 3

        // int a = 1, b = 3, c = 6;

        // if (a > b && a > c) {
        // System.out.println("a is largest");
        // } else if (b > c) {
        // System.out.println("b is largest");
        // } else {
        // System.out.println("c is largest");
        // }

        // System.out.println((a > b) ? a : b); //terary operator

        // int marks = s.nextInt();
        // String sts = (marks >= 33) ? "pass" : "fail";
        // System.out.println(sts);

        // Switch statements

        // int number = 3;
        // int a = 4;
        // int b = 3;
        // switch (number) {
        // case 1:
        // System.out.println(a + b);
        // break;
        // case 2:
        // System.out.println(a - b);
        // break;
        // case 3:
        // System.out.println(a * b);
        // break;
        // default:
        // break;
        // }

        // LOOPS

        // Print number from 1 to 10

        // int i = 1;
        // while (i <= 10) {
        // System.out.println(i);
        // i++;
        // }

        // print number from 1 to n

        // System.out.println("Enter the end point :");
        // int n = s.nextInt();

        // int i = 1;
        // while (i <= n) {
        // System.out.print("\t" + i);
        // i++;
        // }
        // System.out.println();

        // System.out.println("Enter the end point :");
        // int n = s.nextInt();

        // int i = 0;
        // int sum = 0;
        // while (i <= n) {
        // sum += i;
        // i++;
        // }
        // System.out.println("Sum is " + sum);

        // print square pattern using for loop

        // for (int i = 1; i <= 4; i++) {
        // System.out.println("****");
        // }

        // print reverse of number & revrse the given number
        // int rev = 0;
        // int n = 1234;
        // while (n > 0) {
        // int digit = n % 10;
        // // with the below print statemnt you can directly print number not storing
        // digit
        // // into variable
        // // System.out.print(digit + " ");
        // rev = (rev * 10) + digit;
        // n = n / 10;
        // }
        // System.out.println("Reverse is " + rev);

        // prime or not ?
        // int n = s.nextInt();

        // boolean isprime = true;
        // for (int i = 2; i < n - 1; i++) {
        // if (n % i == 0) { // n is multiple of i
        // isprime = false;
        // }
        // }
        // if (isprime == true) {
        // System.out.println(n + " is prime number");
        // } else {
        // System.out.println(n + " is not a prime number");
        // }
    }
}