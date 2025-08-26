package atmmachine;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    int acountnumber;
    int pinnumber;
    double balanceacount=0;
    double savingbalance=0;
    
    Scanner input=new Scanner(System.in);
    DecimalFormat moneyformat=new DecimalFormat("'$'###,##0.000");

    public int getAcountnumber() {
        return acountnumber;
    }

    public void setAcountnumber(int acountnumber) {
        this.acountnumber = acountnumber;
    }

    public int getPinnumber() {
        return pinnumber;
    }

    public void setPinnumber(int pinnumber) {
        this.pinnumber = pinnumber;
    }

    public double getBalanceacount() {
        return balanceacount;
    }

    public void setBalanceacount(double balanceacount) {
        this.balanceacount = balanceacount;
    }

    public double getSavingbalance() {
        return savingbalance;
    }

    public void setSavingbalance(double savingbalance) {
        this.savingbalance = savingbalance;
    }
    public double calcheckingbalancedraw (double amount){
        balanceacount=balanceacount-amount;
        return balanceacount;
    }
    public double calsavingbalancedraw(double amount){
        savingbalance=savingbalance-amount;
        return savingbalance;
    }
    public  double calacountdepsit(double amount){
        balanceacount=balanceacount+amount;
        return balanceacount;
    }
    public double calsavingdeposit (double amount){
        savingbalance=savingbalance+amount;
        return savingbalance;
    }
    public void getcheckwithdraw(){
        System.out.println("checking balance you want to draw:"+moneyformat.format(balanceacount));
        System.out.println("amount you want to draw is :");
        double amount=input.nextDouble();
        if (balanceacount-amount>=0) {
            calcheckingbalancedraw(amount);
            System.out.println("checking balance you want to draw:" + moneyformat.format(balanceacount));
        }
        else{
            System.out.println("balance account can not be in negative:"+"\n");
            }
    }
    public void savingcheckwithdraw(){
        System.out.println("Saving balance you want to draw:"+moneyformat.format(savingbalance));
        System.out.println("amount you want to draw is :");
        double amount=input.nextDouble();
        if (savingbalance-amount>=0) {
           calsavingbalancedraw(amount);
            System.out.println("new saving balance you want to draw:" + moneyformat.format(savingbalance));
        }
        else{
            System.out.println("balance account can not be in negative:"+"\n");
        }
    }
    public void checkwithdeposit(){
        System.out.println("checking balance you want to deposit:"+moneyformat.format(balanceacount));
        System.out.println("amount you want to deposit is :");
        double amount=input.nextDouble();
        if (balanceacount+amount>=0) {
            calacountdepsit(amount);
            System.out.println("New checking balance you want to deposit:" + moneyformat.format(balanceacount));
        }
        else{
            System.out.println("balance account can not be in negative:"+"\n");
        }
    }
    public void savingwithdeposit(){
        System.out.println("Saving balance you want to deposit:"+moneyformat.format(balanceacount));
        System.out.println("New amount you want to deposit is :");
        double amount=input.nextDouble();
        if (balanceacount+amount>=0) {
            calsavingdeposit(amount);
            System.out.println("checking balance you want to draw:" + moneyformat.format(savingbalance));
        }
        else{
            System.out.println("balance account can not be in negative:"+"\n");
        }
    }

}
