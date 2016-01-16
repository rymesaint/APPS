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

import Controllers.Riwayat;
import Controllers.StaticRiwayat;
import Core.Database;
import Core.UserSession;
import Helpers.JadwalTabelModel;
import Helpers.RiwayatTabelModel;
import Helpers.TahunAjarSelectModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author programmer
 */
public class RiwayatModel {
    private Database MySQL = new Database();
    
    public RiwayatTabelModel loadTableRiwayat() {
        RiwayatTabelModel tableModel;
        List<Riwayat> histories = new ArrayList<>();
        String sql = null;
        try {
            switch(UserSession.getLevel()){
                    case "Admin":
                        sql = "SELECT nip, nama, mata_pelajaran, tahun_ajaran FROM jadwal ORDER BY tahun_ajaran DESC";
                        break;
                    case "Pengajar":
                        sql = "SELECT nip, nama, mata_pelajaran, tahun_ajaran FROM jadwal WHERE nip="+UserSession.getNip()+" ORDER BY tahun_ajaran DESC";
                    break;
            }
            
            PreparedStatement ps = MySQL.getConnection().prepareStatement(sql);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                Riwayat history = new Riwayat();
                history.setNip(result.getString("nip"));
                history.setNama(result.getString("nama"));
                history.setMataPelajaran(result.getString("mata_pelajaran"));
                history.setTahunAjar(result.getString("tahun_ajaran"));
                histories.add(history);
            }

            tableModel = new RiwayatTabelModel(histories);
            return tableModel;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public JadwalTabelModel loadTableJadwal() {
        JadwalTabelModel tableModel;
        List<Riwayat> jadwals = new ArrayList<>();
        String sql = null;
        try {
            switch(UserSession.getLevel()){
                    case "Admin":
                        sql = "SELECT nip, nama, mata_pelajaran, tahun_ajaran, waktu, kelas FROM jadwal ORDER BY tahun_ajaran DESC";
                        break;
                    case "Pengajar":
                        sql = "SELECT nip, nama, mata_pelajaran, tahun_ajaran, waktu, kelas FROM jadwal WHERE nip="+UserSession.getNip()+" ORDER BY tahun_ajaran DESC";
                    break;
            }
            
            PreparedStatement ps = MySQL.getConnection().prepareStatement(sql);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                Riwayat jadwal = new Riwayat();
                jadwal.setNip(result.getString("nip"));
                jadwal.setNama(result.getString("nama"));
                jadwal.setMataPelajaran(result.getString("mata_pelajaran"));
                jadwal.setTahunAjar(result.getString("tahun_ajaran"));
                jadwal.setKelas(result.getString("kelas"));
                jadwal.setWaktu(result.getString("waktu"));
                jadwals.add(jadwal);
            }

            tableModel = new JadwalTabelModel(jadwals);
            return tableModel;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public TahunAjarSelectModel loadSelectTahunAjar(){
        TahunAjarSelectModel selectModel;
        List<Riwayat> histories = new ArrayList<>();
        String sql = null;
        try {
            switch(UserSession.getLevel()){
                case "Admin":
                    sql = "SELECT DISTINCT(tahun_ajaran) AS tahun_ajar FROM jadwal ORDER BY tahun_ajaran DESC";
                    break;
                case "Pengajar":
                    sql = "SELECT DISTINCT(tahun_ajaran) AS tahun_ajar FROM jadwal WHERE nip="+UserSession.getNip()+" ORDER BY tahun_ajaran DESC";
                    break;
            }
            PreparedStatement ps = MySQL.getConnection().prepareStatement(sql);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                Riwayat histori = new Riwayat();
                histori.setTahunAjar(result.getString("tahun_ajar"));
                histories.add(histori);
            }

            selectModel = new TahunAjarSelectModel(histories);
            return selectModel;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public void tambahJadwal(){
        String sql = "INSERT INTO jadwal (nip, nama, waktu, kelas, mata_pelajaran, tahun_ajaran) VALUES "
                + "("
                + "'"+StaticRiwayat.getNip()+"',"
                + "'"+StaticRiwayat.getNama()+"',"
                + "'"+StaticRiwayat.getWaktu()+"',"
                + "'"+StaticRiwayat.getKelas()+"',"
                + "'"+StaticRiwayat.getMataPelajaran()+"',"
                + "'"+StaticRiwayat.getTahunAjar()+"')";
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement(sql);
            int rs = ps.executeUpdate();
            if(rs >= 1){
                JOptionPane.showMessageDialog(null, "Berhasil menambahkan jadwal.");
                return;
            }else{
                JOptionPane.showMessageDialog(null, "Gagal menambahkan jadwal.");
                return;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public JadwalTabelModel cariJadwal() {
        JadwalTabelModel tableModel;
        List<Riwayat> jadwals = new ArrayList<>();
        String sql = null;
        try {
            switch(UserSession.getLevel()){
                case "Admin":
                    sql = "SELECT nip, nama, mata_pelajaran, tahun_ajaran, waktu, kelas FROM jadwal WHERE nip LIKE '%"+UserSession.getTemp()+"%'";
                    break;
                case "Pengajar":
                    sql = "SELECT nip, nama, mata_pelajaran, tahun_ajaran, waktu, kelas FROM jadwal WHERE nip='"+UserSession.getNip()+"'";
                    break;
            }
            PreparedStatement ps = MySQL.getConnection().prepareStatement(sql);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                Riwayat jadwal = new Riwayat();
                jadwal.setNip(result.getString("nip"));
                jadwal.setNama(result.getString("nama"));
                jadwal.setMataPelajaran(result.getString("mata_pelajaran"));
                jadwal.setTahunAjar(result.getString("tahun_ajaran"));
                jadwal.setKelas(result.getString("kelas"));
                jadwal.setWaktu(result.getString("waktu"));
                jadwals.add(jadwal);
            }

            tableModel = new JadwalTabelModel(jadwals);
            return tableModel;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public RiwayatTabelModel cariRiwayat() {
        RiwayatTabelModel tableModel;
        List<Riwayat> histories = new ArrayList<>();
        String sql = null;
        try {
            switch(UserSession.getLevel()){
                case "Admin":
                    sql = "SELECT nip, nama, mata_pelajaran, tahun_ajaran FROM jadwal WHERE nip LIKE '%"+UserSession.getTemp()+"%'";
                    break;
                case "Pengajar":
                    sql = "SELECT nip, nama, mata_pelajaran, tahun_ajaran jadwal WHERE nip='"+UserSession.getNip()+"'";
                    break;
            }
            PreparedStatement ps = MySQL.getConnection().prepareStatement(sql);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                Riwayat histori = new Riwayat();
                histori.setNip(result.getString("nip"));
                histori.setNama(result.getString("nama"));
                histori.setMataPelajaran(result.getString("mata_pelajaran"));
                histori.setTahunAjar(result.getString("tahun_ajaran"));
                histories.add(histori);
            }

            tableModel = new RiwayatTabelModel(histories);
            return tableModel;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public RiwayatTabelModel filterTahunAjar() {
        RiwayatTabelModel tableModel;
        List<Riwayat> histories = new ArrayList<>();
        String sql = null;
        try {
            switch(UserSession.getLevel()){
                case "Admin":
                    sql = "SELECT nip, nama, mata_pelajaran, tahun_ajaran FROM jadwal WHERE tahun_ajaran LIKE '%"+UserSession.getTemp()+"%'";
                    break;
                case "Pengajar":
                    sql = "SELECT nip, nama, mata_pelajaran, tahun_ajaran FROM jadwal WHERE tahun_ajaran LIKE '%"+UserSession.getTemp()+"%' AND nip='"+UserSession.getNip()+"'";
                    break;
            }
            PreparedStatement ps = MySQL.getConnection().prepareStatement(sql);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                Riwayat histori = new Riwayat();
                histori.setNip(result.getString("nip"));
                histori.setNama(result.getString("nama"));
                histori.setMataPelajaran(result.getString("mata_pelajaran"));
                histori.setTahunAjar(result.getString("tahun_ajaran"));
                histories.add(histori);
            }

            tableModel = new RiwayatTabelModel(histories);
            return tableModel;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
