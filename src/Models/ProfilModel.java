/*
 * Copyright (C) 2015 programmer
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Models;

import Controllers.AccountControl;
import Controllers.Profil;
import Controllers.StaticProfil;
import Core.Database;
import Core.UserSession;
import Helpers.ProfilSelectModel;
import Helpers.ProfilTabelModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author programmer
 */
public class ProfilModel {

    private Database MySQL = new Database();
    private String nip;
    private String nama;
    private String lulusan;
    private String mata_pelajaran;
    private char jenis_kelamin;
    private String tempat_lahir;
    private Date tglLahir;
    private String warga_negara;
    private String agama;
    private String status_sipil;
    private String alamat;
    private String kota;
    private String kode_pos;
    private String kode_rt;
    private String kode_rw;
    private String provinsi;
    private String negara;
    private String email;
    private String telepon;
    private String hp;

    public ProfilModel() {
    }

    public void saveProfil() throws SQLException {
        this.nip = StaticProfil.getNip();
        this.nama = StaticProfil.getNama();
        this.lulusan = StaticProfil.getLulusan();
        this.mata_pelajaran = StaticProfil.getMata_pelajaran();
        this.jenis_kelamin = StaticProfil.getJenis_kelamin();
        this.tempat_lahir = StaticProfil.getTempat_lahir();
        this.tglLahir = StaticProfil.getTglLahir();
        this.warga_negara = StaticProfil.getWarga_negara();
        this.agama = StaticProfil.getAgama();
        this.status_sipil = StaticProfil.getStatus_sipil();
        this.alamat = StaticProfil.getAlamat();
        this.kota = StaticProfil.getKota();
        this.kode_pos = StaticProfil.getKode_pos();
        this.kode_rt = StaticProfil.getKode_rt();
        this.kode_rw = StaticProfil.getKode_rw();
        this.provinsi = StaticProfil.getProvinsi();
        this.negara = StaticProfil.getNegara();
        this.email = StaticProfil.getEmail();
        this.telepon = StaticProfil.getTelepon();
        this.hp = StaticProfil.getHp();

        String sql = "INSERT INTO profil (nip, nama, lulusan, jenis_kelamin, tempat_lahir, tgl_lahir, warga_negara, agama, status_sipil, alamat, kota, kode_pos, kode_rt,kode_rw, provinsi, negara, email,telepon, hp) VALUES "
                + "('" + this.nip + "',"
                + "'" + this.nama + "', "
                + "'" + this.lulusan + "', "
                + "'" + this.jenis_kelamin + "', "
                + "'" + this.tempat_lahir + "', "
                + "'" + this.tglLahir + "', "
                + "'" + this.warga_negara + "', "
                + "'" + this.agama + "', "
                + "'" + this.status_sipil + "', "
                + "'" + this.alamat + "', "
                + "'" + this.kota + "', "
                + "'" + this.kode_pos + "', "
                + "'" + this.kode_rt + "', "
                + "'" + this.kode_rw + "', "
                + "'" + this.provinsi + "', "
                + "'" + this.negara + "', "
                + "'" + this.email + "', "
                + "'" + this.telepon + "', "
                + "'" + this.hp + "')";
        try {
            Statement st = MySQL.getConnection().createStatement();
            int row = st.executeUpdate(sql);
            if (row >= 1) {
                JOptionPane.showMessageDialog(null, "Berhasil menyimpan data profil.");
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menyimpan data profil.");
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void checkEmpty() {
        if (StaticProfil.getNip().isEmpty() || StaticProfil.getNama().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Maaf, kotak NIP dan Nama tidak boleh kosong.");
            return;
        }
    }
    
    public String getNama(String nip){
        String sql = "SELECT nama FROM profil WHERE nip='"+nip+"'";
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("nama");
            }else{
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ProfilTabelModel loadTableProfil() {
        ProfilTabelModel tableModel;
        List<Profil> profiles = new ArrayList<>();

        try {
            String sql = "SELECT nip, nama, lulusan, negara FROM profil ORDER BY nip DESC";
            PreparedStatement ps = MySQL.getConnection().prepareStatement(sql);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                Profil profil = new Profil();
                profil.setNip(result.getString("nip"));
                profil.setNama(result.getString("nama"));
                profil.setLulusan(result.getString("lulusan"));
                profil.setNegara(result.getString("negara"));
                profiles.add(profil);
            }

            tableModel = new ProfilTabelModel(profiles);
            return tableModel;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public ProfilSelectModel loadSelectProfil(){
        ProfilSelectModel selectModel;
        List<Profil> profiles = new ArrayList<>();

        try {
            String sql = "SELECT nip FROM profil INNER JOIN users ON profil.nip=users.username WHERE level='Pengajar' ORDER BY nip ASC";
            PreparedStatement ps = MySQL.getConnection().prepareStatement(sql);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                Profil profil = new Profil();
                profil.setNip(result.getString("nip"));
                profiles.add(profil);
            }

            selectModel = new ProfilSelectModel(profiles);
            return selectModel;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void getProfil(String nip) {
        StaticProfil p = new StaticProfil();
        String sql = "SELECT * FROM profil WHERE nip='" + nip + "'";
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p.setNama(rs.getString("nama"));
                p.setNip(rs.getString("nip"));
                p.setLulusan(rs.getString("lulusan"));
                p.setAlamat(rs.getString("alamat"));
                p.setEmail(rs.getString("email"));
                p.setHp(rs.getString("hp"));
                p.setKota(rs.getString("kota"));
                p.setNegara(rs.getString("negara"));
                p.setKode_pos(rs.getString("kode_pos"));
                p.setProvinsi(rs.getString("provinsi"));
                p.setKode_rt(rs.getString("kode_rt"));
                p.setKode_rw(rs.getString("kode_rw"));
                p.setTelepon(rs.getString("telepon"));
                p.setTempat_lahir(rs.getString("tempat_lahir"));
                p.setJenis_kelamin(rs.getString("jenis_kelamin").charAt(0));
                p.setAgama(rs.getString("agama"));
                p.setWarga_negara(rs.getString("warga_negara"));
                p.setStatus_sipil(rs.getString("status_sipil"));
                p.setMata_pelajaran(rs.getString("mata_pelajaran"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int countData() {
        try {
            String sql = "SELECT nip, nama FROM profil";
            PreparedStatement ps = MySQL.getConnection().prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            int row = result.getRow();
            return row;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public void ubahProfil() {
        this.nip = StaticProfil.getNip();
        this.nama = StaticProfil.getNama();
        this.lulusan = StaticProfil.getLulusan();
        this.mata_pelajaran = StaticProfil.getMata_pelajaran();
        this.jenis_kelamin = StaticProfil.getJenis_kelamin();
        this.tempat_lahir = StaticProfil.getTempat_lahir();
        this.tglLahir = StaticProfil.getTglLahir();
        this.warga_negara = StaticProfil.getWarga_negara();
        this.agama = StaticProfil.getAgama();
        this.status_sipil = StaticProfil.getStatus_sipil();
        this.alamat = StaticProfil.getAlamat();
        this.kota = StaticProfil.getKota();
        this.kode_pos = StaticProfil.getKode_pos();
        this.kode_rt = StaticProfil.getKode_rt();
        this.kode_rw = StaticProfil.getKode_rw();
        this.provinsi = StaticProfil.getProvinsi();
        this.negara = StaticProfil.getNegara();
        this.email = StaticProfil.getEmail();
        this.telepon = StaticProfil.getTelepon();
        this.hp = StaticProfil.getHp();

        String sql = "UPDATE profil SET "
                + "nama='" + this.nama + "',"
                + "lulusan='" + this.lulusan + "',"
                + "jenis_kelamin='" + this.jenis_kelamin + "',"
                + "tempat_lahir='" + this.tempat_lahir + "',"
                + "tgl_lahir='" + this.tglLahir + "',"
                + "warga_negara='" + this.warga_negara + "',"
                + "agama='" + this.agama + "',"
                + "status_sipil='" + this.status_sipil + "',"
                + "alamat='" + this.alamat + "',"
                + "kota='" + this.kota + "',"
                + "kode_pos='" + this.kode_pos + "',"
                + "kode_rt='" + this.kode_rt + "',"
                + "kode_rw='" + this.kode_rw + "',"
                + "provinsi='" + this.provinsi + "',"
                + "negara='" + this.negara + "',"
                + "email='" + this.email + "',"
                + "telepon='" + this.telepon + "',"
                + "hp='" + this.hp + "'"
                + " WHERE nip='" + this.nip + "'";
        try {
            Statement st = MySQL.getConnection().createStatement();
            int row = st.executeUpdate(sql);
            if (row >= 1) {
                JOptionPane.showMessageDialog(null, "Berhasil mengubah data profil.");
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menyimpan data profil.");
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ProfilTabelModel getUser() {
        ProfilTabelModel tableModel;
        List<Profil> profiles = new ArrayList<>();

        try {
            String sql = "SELECT nip, nama, lulusan, negara FROM profil WHERE nip LIKE '%"+UserSession.getTemp()+"%'";
            PreparedStatement ps = MySQL.getConnection().prepareStatement(sql);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                Profil profil = new Profil();
                profil.setNip(result.getString("nip"));
                profil.setNama(result.getString("nama"));
                profil.setLulusan(result.getString("lulusan"));
                profil.setNegara(result.getString("negara"));
                profiles.add(profil);
            }

            tableModel = new ProfilTabelModel(profiles);
            return tableModel;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public boolean hapus() throws SQLException{
        String sql = "DELETE FROM profil WHERE nip='" + UserSession.getTemp() + "'";
        Statement st = MySQL.getConnection().createStatement();
        
        int rs = st.executeUpdate(sql);
        if(rs >= 1){
            return true;
        }else{
            return false;
        }
    }
}
