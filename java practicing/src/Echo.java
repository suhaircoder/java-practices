public class Echo {
    public static void main(String[] args){
        echoc p1=new echoc();
        echoc p2=new echoc();
        int x=0;
        while(x<6){
            p1.echo_p();
            p1.count=p1.count+1;
            if ( x == 3 ) {
                p2.count = p2.count + 1;
            }
            if ( x > 0 ) {
                p2.count = p2.count + p1.count;
            }
            x=x+1;
        }
        System.out.println(p2.count);


    }
}
class echoc{
    int count=0;
    void echo_p(){
        System.out.println("helloooo...");
    }
}
