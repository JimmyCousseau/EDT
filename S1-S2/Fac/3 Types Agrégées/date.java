import scite.*;

public class date {
    public static void main(String[] args) {
        Date date = insert();
        Ecran.afficherln(date.day + " " + date.months + " " + date.year);
        Date next = lendemain(date);
        Ecran.afficherln(next.day + " " + next.months + " " + next.year);
        Date nextS = saison(next);
        Ecran.afficherln(nextS.saison);
    }

    static class Date {
        int year;
        int month;
        String months;
        int day;
        String saison;
    }

    public static Date saison(Date date) {
        if (date.month >= 3) {
            if (date.month >= 6 && date.day >= 21) {
                if (date.month >= 9 && date.day >= 23) {
                    if (date.month >= 12 && date.day >= 22) {
                        date.saison = "Nous sommes en hiver";
                    } else {
                        if (date.month >= 1) {
                            date.saison = "Nous sommes en hiver";
                        } else {
                            date.saison = "Nous sommes en automne";
                        }
                    }
                } else {
                    if (date.month >= 10) {
                        date.saison = "Nous sommes en automne";
                    } else {
                        date.saison = "Nous sommes en été";
                    }
                }
            } else {
                if (date.month >= 7) {
                    date.saison = "Nous sommes en été";
                } else {
                    date.saison = "Nous sommes au printemps";
                }
            }
        } else {
            if (date.month >= 4) {
                date.saison = "Nous sommes au printemps";
            } else {
                date.saison = "Nous sommes en hiver";
            }
        }
        return date;
    }

    public static Date lendemain(Date date) {
        int m = date.month;
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
            if (date.day >= 31) {
                if (date.month >= 12) {
                    date.month = 1;
                    date.year = date.year + 1;
                    date.day = 1;
                } else {
                    date.month = date.month + 1;
                    date.day = 1;
                }
            } else {
                date.day = date.day + 1;
            }
        } else {
            if (date.month == 2) {
                if (date.year % 400 == 0) {
                    if (date.day >= 29) {
                        date.day = 1;
                        date.month += 1;
                    }
                    else {
                        date.day += 1;
                    }
                } else if (date.year % 100 != 0 && date.year % 4 == 0) {
                    if (date.day >= 29) {
                        date.day = 1;
                        date.month += 1;
                    }
                    else {
                        date.day += 1;
                    }
                }
                else {
                    if (date.day >= 28) {
                        date.day = 1;
                        date.month += 1;
                    }
                    else {
                        date.day += 1;
                    }
                }
            } else if (date.day >= 30) {
                if (date.month == 12) {
                    date.month = 1;
                    date.year = date.year + 1;
                } else {
                    date.month = date.month + 1;
                    date.day = 1;
                }
            } else {
                date.day = date.day + 1;
            }
        }
        date.month = month(date);
        return date;
    }

    public static int month(Date date) {
        switch (date.month) {
        case 1:
            date.months = "Janvier";
            break;
        case 2:
            date.months = "Février";
            break;
        case 3:
            date.months = "Mars";
            break;
        case 4:
            date.months = "Avril";
            break;
        case 5:
            date.months = "Mai";
            break;
        case 6:
            date.months = "Juin";
            break;
        case 7:
            date.months = "Juillet";
            break;
        case 8:
            date.months = "Aout";
            break;
        case 9:
            date.months = "Septembre";
            break;
        case 10:
            date.months = "Octobre";
            break;
        case 11:
            date.months = "Novembre";
            break;
        default:
            date.months = "Décembre";
            break;
        }
        return date.month;
    }

    public static Date insert() {
        Date date = new Date();
        Ecran.afficherln("Veuillez saisir la date sous forme : dd/mm/yyyy");
        Ecran.afficher("Jour: ");
        date.day = Clavier.saisirInt();
        Ecran.afficher("Mois: ");
        date.month = Clavier.saisirInt();
        date.month = month(date);
        Ecran.afficher("Année: ");
        date.year = Clavier.saisirInt();
        return date;
    }
}
