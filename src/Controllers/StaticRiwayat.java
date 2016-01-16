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
package Controllers;

import javax.swing.JOptionPane;

/**
 *
 * @author programmer
 */
public class StaticRiwayat {
    private static String nip;
    private static String nama;
    private static String MataPelajaran;
    private static String waktu;
    private static char kelas;
    private static String tahunAjar;

    public StaticRiwayat() {
    }

    public static String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
    
    public static String getNama() {
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }

    public static String getMataPelajaran() {
        return MataPelajaran;
    }

    public void setMataPelajaran(String MataPelajaran) {
        this.MataPelajaran = MataPelajaran;
    }

    public static String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public static char getKelas() {
        return kelas;
    }

    public void setKelas(char kelas) {
        this.kelas = kelas;
    }
    
    public static String getTahunAjar(){
        return tahunAjar;
    }
    
    public void setTahunAjar(String ganjil, String genap){
        this.tahunAjar = ganjil+"/"+genap;
    }
    
    public void checkEmpty(){
        if(nip.isEmpty() || nama.isEmpty() || waktu.isEmpty() || MataPelajaran.isEmpty() || tahunAjar.isEmpty()){
            JOptionPane.showMessageDialog(null, "Field harus diisi semua.");
            return;
        }
    }
}
