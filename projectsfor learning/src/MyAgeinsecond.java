import java.time.*;
import java.time.Period;
public class MyAgeinsecond {
    public static void main(String[] args){
        // birth day in years by using period becuase period using localdate
        LocalDate birthday= LocalDate.of(1993,12,07);
        LocalDate current= LocalDate.now();
        Period period = Period.between(birthday, current);
        int ageInYears = period.getYears();
        System.out.println("You are " + ageInYears + " years old!");

        // mybirthday in hours/minutes /second using localdatetime

       LocalDateTime mybirthday= LocalDateTime.of(1993,12,07,0,0);
       LocalDateTime now= LocalDateTime.now();
        Duration duration=Duration.between(mybirthday,now);
        Long myagenow= duration.getSeconds();
        Long myageinhours= duration.toHours();
        long ageindays= duration.toDays();

        System.out.println("Suhair age now is :"+myagenow+" seconds old");
        System.out.println("Suhair age now is :"+ myageinhours+" hours old");
        System.out.println("Suhair age now is :"+ ageindays+" days old");


    }
}
