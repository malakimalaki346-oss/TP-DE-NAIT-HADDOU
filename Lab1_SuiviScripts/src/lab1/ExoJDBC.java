import java.sql.*;

public class ExoJDBC {

    private static final String URL =
        "jdbc:mysql://localhost:3306/atelier?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {

        // Charger le driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver MySQL introuvable.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            System.out.println("Connexion MySQL OK.");

            // Création de la table
            stmt.executeUpdate("DROP TABLE IF EXISTS DevData");
            stmt.executeUpdate(
                "CREATE TABLE DevData (" +
                "Developpeurs VARCHAR(32), " +
                "Jour VARCHAR(16), " +
                "NbScripts INT)"
            );

            // Insertion des données
            stmt.executeUpdate("INSERT INTO DevData VALUES ('ALAMI','Lundi',1)");
            stmt.executeUpdate("INSERT INTO DevData VALUES ('WAFI','Lundi',2)");
            stmt.executeUpdate("INSERT INTO DevData VALUES ('SLAMI','Mardi',9)");
            stmt.executeUpdate("INSERT INTO DevData VALUES ('ALAMI','Mardi',3)");
            stmt.executeUpdate("INSERT INTO DevData VALUES ('WAFI','Mardi',4)");
            stmt.executeUpdate("INSERT INTO DevData VALUES ('SLAMI','Mercredi',2)");

            System.out.println("Table créée + données insérées.");

            // Stat 1 : Max par jour
            System.out.println("\n--- Max scripts par jour ---");
            ResultSet rs1 = stmt.executeQuery(
                "SELECT Jour, MAX(NbScripts) AS MaxScripts " +
                "FROM DevData GROUP BY Jour"
            );
            while (rs1.next()) {
                System.out.println(
                    rs1.getString("Jour") +
                    " | " +
                    rs1.getInt("MaxScripts")
                );
            }

            // Stat 2 : Classement
            System.out.println("\n--- Classement développeurs ---");
            ResultSet rs2 = stmt.executeQuery(
                "SELECT Developpeurs, SUM(NbScripts) AS Total " +
                "FROM DevData GROUP BY Developpeurs ORDER BY Total DESC"
            );
            while (rs2.next()) {
                System.out.println(
                    rs2.getString("Developpeurs") +
                    " | " +
                    rs2.getInt("Total")
                );
            }

            // Stat 3 : Total semaine
            ResultSet rs3 = stmt.executeQuery(
                "SELECT SUM(NbScripts) AS Total FROM DevData"
            );
            if (rs3.next()) {
                System.out.println("\nTotal semaine : " + rs3.getInt("Total"));
            }

            // Stat 4 : Total pour un développeur (PreparedStatement)
            String sql =
                "SELECT SUM(NbScripts) FROM DevData WHERE Developpeurs = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "ALAMI");

            ResultSet rs4 = ps.executeQuery();
            if (rs4.next()) {
                System.out.println(
                    "Total pour ALAMI : " + rs4.getInt(1)
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
