package atmmachine;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu extends Account{
    int selection;
    Scanner menueinput=new Scanner(System.in);
    DecimalFormat moneyformat=new DecimalFormat("'$'###,##0.000");
    HashMap<Integer,Integer> data=new HashMap<Integer,Integer>();

    public void getLogin() throws IOException{
        int x=1;
        do {
            try {
                data.put(99976543, 1234);
                data.put(88886663, 2345);
                System.out.println("Welcome to ATM Mchine:");
                System.out.println("customer number is :");
                setAcountnumber(menueinput.nextInt());
                System.out.println("customer pin number is :");
                setPinnumber(menueinput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "involid character only numbers :");
                x = 2;
            }
            for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
                 if (entry.getKey()==getAcountnumber() && entry.getValue()==getPinnumber()){
                     getAccountType();
                 }
            }
         System.out.println("\n"+"wrong account number or pin number ."+"\n");
        }while(x==1);

        }

    public void getAccountType() {
        System.out.println("select the account you want to access:");
        System.out.println("Type1: checking Account :");
        System.out.println("Type2: Saving Account :");
        System.out.println("Type3: excite :");
        selection=menueinput.nextInt();
       switch (selection){
           case 1:
          getchecking();
          break;
           case 2:
               getsaving();
               break;
           case 3:
          System.out.println("thanks for using ATM Machine :");
          break;
           default:
               System.out.println("\n"+"invalid choice:");
               getAccountType();
       }

}
   public void getchecking() {
       System.out.println("checking account:");
       System.out.println("Type1:view balance :");
       System.out.println("Type2: withdraw funds :");
       System.out.println("Type3:deposit funds:");
       System.out.println("Type4: excite :");
       System.out.println("choice:");
       selection = menueinput.nextInt();
       switch (selection) {
           case 1:
               System.out.println("checking account balance :" + moneyformat.format(getBalanceacount()));
               getAccountType();
               break;
           case 2:
               getSavingbalance();
               getAccountType();
               break;
           case 3:
               savingwithdeposit();
               getAccountType();
               break;
           case 4:
               System.out.println("thanks for using ATM Machine. bye");
               break;
           default:
               System.out.println("\n" + "invalid choice:");
               getSavingbalance();
       }
   }
       public void getsaving(){
           System.out.println("saving account:");
           System.out.println("Type1:view balance :");
           System.out.println("Type2: withdraw funds :");
           System.out.println("Type3:deposit funds:");
           System.out.println("Type4: excite :");
           System.out.println("choice:");
           selection=menueinput.nextInt();
           switch (selection){
               case 1:
                   System.out.println("checking account balance :"+moneyformat.format(getSavingbalance()));
                   getAccountType();
                   break;
               case 2:
                   getcheckwithdraw();
                   getAccountType();
                   break;
               case 3:
                   checkwithdeposit();
                   getAccountType();
                   break;
               case 4:
                   System.out.println("thanks for using ATM Machine. bye");
                   break;
               default:
                   System.out.println("\n"+"invalid choice:");
                   getSavingbalance();
           }
}

}
