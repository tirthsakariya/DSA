import java.util.*;

public class OOPS {
    public static void main(String[] args) {
        // student st = new student();
        // st.calmarks(97, 98, 99);
        // student s1 = new student("tirth;");

        // bank myac = new bank();
        // myac.username = "tirth";
        // // myac.password = "abcd";
        // myac.setpwd("abcd");

        // pen np = new pen();
        // np.setcolor("yellow");
        // System.out.println(np.getcolor());

        // fish shark = new fish();
        // shark.eat();

        // dog doggy = new dog();
        // doggy.eat();
        // doggy.legs = 4;
        // System.out.println(doggy.legs);

        // System.out.println(cal.sum(1, 2));
        // System.out.println(cal.sum((float) 1.5, (float) 2.5));
        // System.out.println(cal.sum(1, 2, 3));

        // deer d = new deer();
        // d.eat();

        // // scanner package
        // Scanner s = new Scanner(System.in);

        // horse h = new horse();
        // h.eat();
        // h.walk();
        // System.out.println(h.color);

        // chicken c = new chicken();
        // c.eat();
        // c.walk();
        // System.out.println(c.color);

        // Animal a = new Animal();

        // cunstrctor calling
        // mustang m = new mustang();

        // queen q = new queen();
        // q.moves();

        Student s1 = new Student();
        s1.schoolname = "gajera";

        Student s2 = new Student();
        System.out.println(s2.schoolname);

    }
}

class Student {
    static int retper(int m, int p, int c) {
        return (m + p + c) / 3;
    }

    String name;
    int roll;

    static String schoolname;

    void setname(String name) {
        this.name = name;
    }

    String getname() {
        return this.name;
    }
}

// Multiple interface
interface herbi {
    // codes // A
}

interface carni {
    // codes // B
}

class bear implements herbi, carni {
    // codes // C
}

interface chessplayer {
    void moves();
}

class queen implements chessplayer {
    public void moves() {
        System.out.println("up,down,left,right,diagonal");
    }
}

class rook implements chessplayer {
    public void moves() {
        System.out.println("up,down,left,right");
    }
}

class king implements chessplayer {
    public void moves() {
        System.out.println("up,down,left,right,diagonal - 1 steps");
    }
}

abstract class Animal {
    String color;

    Animal() {
        System.out.println("animal cunstrooctor called");
        color = "brown";
    }

    void eat() {
        System.out.println("animal eats");
    }

    abstract void walk();
}

class horse extends Animal {
    horse() {
        System.out.println("horse const. called");
    }

    void changecolor() {
        color = "darkbrown";
    }

    void walk() {
        System.out.println("walks on 4 legs");
    }
}

class mustang extends horse {
    mustang() {
        System.out.println("mustang const..called");
    }
}

class chicken extends Animal {
    void changecolor() {
        color = "white";
    }

    void walk() {
        System.out.println("walks on 2 legs");
    }
}

class cal {
    static int sum(int a, int b) {
        return a + b;
    }

    static float sum(float a, float b) {
        return a + b;
    }

    static int sum(int a, int b, int c) {
        return a + b + c;
    }
}

class animal {
    String color;

    void eat() {
        System.out.println("eats");
    }

    void breath() {
        System.out.println("breaths");
    }
}

class deer extends animal {
    void eat() {
        System.out.println("eats grass");
    }
}

class fish extends animal {
    int fins;

    void swim() {
        System.out.println("swims");
    }
}

class mamals extends animal {
    int legs;

    void walk() {
        System.out.println("walks");
    }
}

class bird extends animal {
    void fly() {
        System.out.println("fly");
    }
}

class dog extends mamals {
    String bread;
}

class student {
    String name;
    int age;
    float per;

    student() {
        System.out.println("cunstrocts has been called");
    }

    student(String name) {
        this.name = name;
    }

    void calmarks(int phy, int che, int maths) {
        per = (phy + che + maths) / 3;
        System.out.println(per);
    }
}

class bank {
    public String username;
    private String password;

    public void setpwd(String pwd) {
        password = pwd;
    }
}

class pen {
    private String color;
    private int tip;

    String getcolor() {
        return this.color;
    }

    void setcolor(String newcolor) {
        this.color = newcolor;
    }
}
