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

import Models.RiwayatModel;

/**
 *
 * @author programmer
 */
public class Riwayat {
    private String nip;
    private String nama;
    private String MataPelajaran;
    private String waktu;
    private String kelas;
    private String tahunAjar;

    public Riwayat() {
    }
    
    public RiwayatModel getDataRiwayat(){
        return new RiwayatModel();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }    

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getMataPelajaran() {
        return MataPelajaran;
    }

    public void setMataPelajaran(String MataPelajaran) {
        this.MataPelajaran = MataPelajaran;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getTahunAjar() {
        return tahunAjar;
    }

    public void setTahunAjar(String tahunAjar) {
        this.tahunAjar = tahunAjar;
    }
    
    
}
