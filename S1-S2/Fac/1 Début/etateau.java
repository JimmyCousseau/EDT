import scite.*;

public class etateau {
    public static void main(String[] args){
        Ecran.afficher("Veuillez saisir la température de l'eau en °C");
        float Temp = Clavier.saisirInt();
        if (Temp <= 0) {
            Ecran.afficher("L'eau est gelé");
        }
        else if (Temp <= 12) {
            Ecran.afficher("L'eau est froide");
        }
        else if (Temp <= 25) {
            Ecran.afficher("L'eau est convenable");
        }
        else if (Temp <= 75) {
            Ecran.afficher("L'eau est chaude");
        }
        else {
            Ecran.afficher("L'eau est bouillante");
        }
    }
}
