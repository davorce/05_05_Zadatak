import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class BrisanjeDrzava {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = createDataSource();
        int brisanje = brisanjeDrzava(21);
        System.out.println("Drzave s IDem " + brisanje + " i vise, su obrisane.");
    }

    public static int brisanjeDrzava(int id) throws SQLException {
        try (Connection connection = createDataSource().getConnection()) {
            System.out.println("Uspjesno ste spojeni na bazu podatak!");

            CallableStatement cs = connection.prepareCall("{call ObrisiDrzave(?)}");
            cs.setInt(1, id);
            cs.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

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
