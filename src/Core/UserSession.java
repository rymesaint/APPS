/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Models.UserModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MIKO
 */
public class UserSession {
    private static String nip;
    private static String level;
    private static String temp;
    private final UserModel user_model = new UserModel();
    
    public UserSession(){};
    
    public ResultSet getUserByNIP(String nip) throws SQLException{
        ResultSet profile;
        profile = user_model.SelectById(nip);
        
        if(profile.next()){
            return profile;
        }else{
            return profile = null;
        }
    }

    public static String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public static String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }    

    public static String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
