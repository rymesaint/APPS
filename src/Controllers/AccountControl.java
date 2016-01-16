/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.UserModel;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author programmer
 */
public class AccountControl {
    private static String username;
    private static String password;
    private static String confirmPassword;
    private static String level;
    private static String idUser;

    public AccountControl(String username, char[] password) {
        AccountControl.username = username;
        AccountControl.password = Arrays.toString(password);
    }

    public AccountControl(String username) {
        AccountControl.username = username;
    }

    public AccountControl(String username, char[] password, char[] confirmPassword) {
        AccountControl.username = username;
        AccountControl.password = Arrays.toString(password);
        AccountControl.confirmPassword = Arrays.toString(confirmPassword);
    }

    public AccountControl() {
    }
    
    public UserModel getDataUser(){
        return new UserModel();
    }

    public static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(char[] confirmPassword) {
        this.confirmPassword = Arrays.toString(confirmPassword);
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = Arrays.toString(password);
    }

    public static String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        AccountControl.level = level;
    }

    public static String getIdUser() {
        return idUser;
    }

    public static void setIdUser(String idUser) {
        AccountControl.idUser = idUser;
    }
    
    public void checkEmpty(){
        if(getUsername().isEmpty() || getPassword().isEmpty()){
            JOptionPane.showMessageDialog(null, "Field tidak boleh kosong.");
            return;
        }
    }
    
    public void checkPasswordConfirm(){
        if(!getPassword().equals(getConfirmPassword())){
            JOptionPane.showMessageDialog(null, "Maaf, password konfirmasi tidak sama dengan password.");
            return;
        }
    }
}
