import Game.Gender;
import Game.Performer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateTime {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date currentdate = new Date();
        System.out.println("Today is :" + sdf.format(currentdate));

        Date Habibi = new Date(92, 9, 10);
        System.out.println("my honey birthday is  :" + sdf.format(Habibi));
        int day = Habibi.getDate();
        System.out.println("Day: " + day);
        int month = Habibi.getMonth() + 1;
        System.out.println("Month: " + month);
        int year = Habibi.getYear();
        System.out.println("Year: " + year);

        try {
            Date johnBirthday = sdf.parse("16-10-1977");
        } catch (ParseException e) {
            System.out.println("SOME ERROR HAPPENED");
        }
        List objeclist = new ArrayList();
        objeclist.add("temp");
        objeclist.add(Integer.valueOf(5));
        objeclist.add(new Performer("Jhon", 40, 5.6f, Gender.Male));

        for (Object obj : objeclist) {
            if (obj instanceof String) {
                System.out.println("String object = " + obj.toString());
            } else if (obj instanceof Integer) {
                Integer i = (Integer) obj;
                System.out.println("Integer object = " + i.intValue());
            } else {
                Performer p = (Performer) obj;
                System.out.println("Performer object = " + p.getName());
            }
        }
    }
}
