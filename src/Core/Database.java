package Core;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MIKO
 */
public class Database {
    
    private static Connection connect;
    private final String hostname = "localhost";
    private final String userhost = "root";
    private final String passhost = "";
    private final String database = "trm_pasundan";
    
    /**
     *
     * Mengembalikan hasil koneksi
     * @return connect
     * Ketika gagal terkoneksi akan 
     * @throws SQLException
     * Untuk mendapatkan informasi kegagalan.
     */
    public Connection getConnection() throws SQLException {
        if(connect == null){
            new Driver();
            
            String url;
            url = "jdbc:mysql://localhost:3306/"+ this.getDatabase();
            connect = DriverManager.getConnection(url, this.getUserhost(), this.getPasshost());
        }
        return connect;
    }

    /**
     * Mengembalikan nilai hostname
     * @return hostname
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * Mengembalikan nilai String userhost
     * @return userhost
     */
    public String getUserhost() {
        return userhost;
    }

    /**
     * Mengembalikan nilai String passhost
     * @return passhost
     */
    public String getPasshost() {
        return passhost;
    }

    /**
     * Mengembalikan nilai String database
     * @return database
     */
    public String getDatabase() {
        return database;
    }

    /**
     * Mengembalikan nilai Connection
     * @return connect
     */
    public static Connection getConnect() {
        return connect;
    }

    /**
     *
     * @param connect
     * Digunakan untuk menset data koneksi ke variable kelas connect.
     */
    public static void setConnect(Connection connect) {
        Database.connect = connect;
    }    
}
