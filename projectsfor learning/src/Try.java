public class Try {
public static void main(String[] args){

}
    private int age;
    private String name;
    private String lastname;
    private double salary;
    private char A;

    public Try(int age, String name, String lastname, double salary, char a) {

        this.age = age;
        this.name = name;
        this.lastname = lastname;
        this.salary = salary;
        A = a;
    }



    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setA(char a) {
        A = a;
    }


    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public double getSalary() {
        return salary;
    }

    public char getA() {
        return A;
    }


}
