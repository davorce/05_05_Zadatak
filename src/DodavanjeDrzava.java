import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DodavanjeDrzava {
    public static void main(String[] args) {

        ArrayList<String> drzave = new ArrayList<>();
        drzave.add("Azeroth");
        drzave.add("Westeros");
        drzave.add("Oz");
        drzave.add("Eldia");
        drzave.add("Mordor");
        drzave.add("Atlantida");
        drzave.add("El Dorado");
        drzave.add("Neverland");
        drzave.add("Asgard");
        drzave.add("Midgard");

        DataSource dataSource = createDataSource();

        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Uspjesno ste spojeni na bazu podataka!");

            PreparedStatement stmt;
            stmt = connection.prepareStatement("INSERT INTO Drzava (Naziv) VALUES (?)");
            for (String s : drzave) {
                stmt.setString(1, s);
                stmt.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Greska prilikom spajanja!");
            e.printStackTrace();
        }

    }


    // ********** METODA ZA SPAJANJE NA BAZU **********
    private static DataSource createDataSource() {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setServerName("localhost");
        //ds.setPortNumber(1433);
        ds.setDatabaseName("AdventureWorksOBP");
        ds.setUser("sa");
        ds.setPassword("SQL");
        ds.setEncrypt(false);
        return ds;
    }
}