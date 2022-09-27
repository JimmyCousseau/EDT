import java.sql.*;

public class BD {
    public static String adresse = "sql11.freemysqlhosting.net";
    public static String bd = "sql11482418";
    public static String login = "sql11482418";
    public static String password = "JEZNCVVFcf";

    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String args[]) {
        try {
            // étape 1: charger la classe de driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://sql11.freemysqlhosting.net/sql11482418", "sql11482418", "JEZNCVVFcf");

            // étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();
            /* stmt.executeUpdate("INSERT INTO PATIENT (NumSecu, Nom) VALUES ('139049294897', 'Sam Soung')"); */
            ResultSet res = stmt
                    .executeQuery("SELECT PATIENT.* FROM PATIENT WHERE PATIENT.Nom LIKE 'Sam%'");

            // étape 4: exécuter la requête
            while (res.next())
                System.out.println(res.getString(1) + "  " + res.getString(2));

                // étape 5: fermez l'objet de connexion
                conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
