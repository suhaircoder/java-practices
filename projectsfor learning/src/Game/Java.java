package Game;
import java.util.Scanner;
public class Java {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String ob1;
            String name;
            String verb;
            String obj2;
            System.out.print("enter the ob1: ");
            ob1=scanner.nextLine();
            System.out.print("enter the name: ");
            name=scanner.nextLine();
            System.out.print("enter the verb: ");
            verb=scanner.nextLine();
            System.out.print("enter the ob2: ");
            obj2=scanner.nextLine();
            System.out.println("today i want to a " + ob1 + "out of the market ");
            System.out.println("there i saw a " + name);
            System.out.println("the " + name + " he was " + verb + "so fast");
            System.out.println("i was so  " + obj2);
        }
    }

