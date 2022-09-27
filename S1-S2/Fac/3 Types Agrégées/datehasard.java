import java.lang.Math;
import scite.*;

public class datehasard {
    public static void main(String[] args) {
        String months;
        int day;
        int year = (int) (Math.random() * 70 + 1951);
        int month = (int) (Math.random() * 12 + 1);

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            day = (int) (Math.random() * 31 + 1);
        } else {
            day = (int) (Math.random() * 30 + 1);
        }
        switch (month) {
        case 1:
            months = "Janvier";
            break;
        case 2:
            months = "Février";
            break;
        case 3:
            months = "Mars";
            break;
        case 4:
            months = "Avril";
            break;
        case 5:
            months = "Mai";
            break;
        case 6:
            months = "Juin";
            break;
        case 7:
            months = "Juillet";
            break;
        case 8:
            months = "Aout";
            break;
        case 9:
            months = "Septembre";
            break;
        case 10:
            months = "Octobre";
            break;
        case 11:
            months = "Novembre";
            break;
        default:
            months = "Décembre";
            break;
        }
        Ecran.afficherln(day + " " + months + " " + year);
    }
}
