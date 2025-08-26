
public class Solution {
    public static double arrowArea(int a, int b) {
        return (double) a * b / 4.0;
    }
    public static void main(String [] args) {

       Solution solution=new Solution();
       double area;
       area= solution.arrowArea(4,2);
        System.out.println(area);
    }
}