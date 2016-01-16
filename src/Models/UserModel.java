package Models;

import Controllers.StaticProfil;
import Core.Database;
import Core.UserSession;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author programmer
 */
public class UserModel {
    
    private static Database MySQL = new Database();
    private static UserSession session = new UserSession();
    private static StaticProfil profil = new StaticProfil();
    
    public UserModel() {
    }
    
    public ResultSet SelectById(String nip) throws SQLException {
        ResultSet ret = null;
        String sql = "SELECT * FROM users WHERE id_user='" + nip + "'";
        Statement st = MySQL.getConnection().createStatement();
        ResultSet result = st.executeQuery(sql);
        if (result.next()) {
            ret = result;
        }
        return ret;
    }
    
    public String getIDUser(String nip) throws SQLException{
        String ret = null;
        String sql = "SELECT * FROM users WHERE id_user='" + nip + "'";
        Statement st = MySQL.getConnection().createStatement();
        ResultSet result = st.executeQuery(sql);
        if(result.next()){
            ret = result.getString("id_user");
        }
        return ret;
    }
    
    public static boolean checkLogin(String username, String password) throws SQLException{
        boolean ret;
        String sql;
        Database connect;
        
        sql = "SELECT id_user,username,password,level FROM users WHERE username='"+username+"'";
        
        connect = new Database();
        try
        {
            connect.getConnection();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Kode SQL Error : "+ex.getSQLState());
        }
        
        try (Statement st = connect.getConnection().createStatement()) {
            ResultSet result = st.executeQuery(sql);
            
            if(result.next()){
                if(password.equals(result.getString("password"))){
                    session.setNip(result.getString("username"));
                    session.setLevel(result.getString("level"));
                    ret = true;
                    st.close();
                }else{
                    st.close();
                    ret = false;
                }
            }else{
                st.close();
                ret = false;
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
        return ret;
    }
    
    public static void existUser(String nip) throws SQLException {
        String sql = "SELECT id_user, username FROM users WHERE username='" + nip + "'";
        Statement st = MySQL.getConnection().createStatement();
        ResultSet result = st.executeQuery(sql);
        if(result.next()){
            JOptionPane.showMessageDialog(null, "Maaf, user dengan nip ini sudah terdaftar.");
            return;
        }
    }

    public void createAccount(String username, String password, String level) throws SQLException {
        String sql = "INSERT INTO users (username, password, level) VALUES ('" + username + "', '" + password + "', '" + level + "')";
        try {
            Statement st = MySQL.getConnection().createStatement();
            int rs = st.executeUpdate(sql);

            if (rs >= 1) {
                
                JOptionPane.showMessageDialog(null, "Berhasil menambahkan akun.");
                return;
            }else{
                JOptionPane.showMessageDialog(null, "Gagal menambahkan akun.");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public boolean DeleteAccount() throws SQLException{
        String sql = "DELETE FROM users WHERE username='" + UserSession.getTemp() + "'";
        Statement st = MySQL.getConnection().createStatement();
        
        int rs = st.executeUpdate(sql);
        if(rs >= 1){
            return true;
        }else{
            return false;
        }
    }
}
