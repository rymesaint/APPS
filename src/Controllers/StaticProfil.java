package Controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author programmer
 */
public class StaticProfil {
    private static String nip;
    private static String nama;
    private static String lulusan;
    private static String mata_pelajaran;
    private static char jenis_kelamin;
    private static String tempat_lahir;
    private static int tanggal;
    private static String bulan;
    private static int tahun;
    private static String warga_negara;
    private static String agama;
    private static String status_sipil;
    private static String alamat;
    private static String kota;
    private static String kode_pos;
    private static String kode_rt;
    private static String kode_rw;
    private static String provinsi;
    private static String negara;
    private static String email;
    private static String telepon;
    private static String hp;

    public static String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public static String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public static String getLulusan() {
        return lulusan;
    }

    public void setLulusan(String lulusan) {
        this.lulusan = lulusan;
    }

    public static String getMata_pelajaran() {
        return mata_pelajaran;
    }

    public void setMata_pelajaran(String mata_pelajaran) {
        this.mata_pelajaran = mata_pelajaran;
    }

    public static char getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(char jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public static String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public static int getTanggal() {
        return tanggal;
    }

    public void setTanggal(int tanggal) {
        StaticProfil.tanggal = tanggal;
    }

    public static String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        StaticProfil.bulan = bulan;
    }

    public static int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        StaticProfil.tahun = tahun;
    }

    public static String getWarga_negara() {
        return warga_negara;
    }

    public void setWarga_negara(String warga_negara) {
        this.warga_negara = warga_negara;
    }

    public static String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public static String getStatus_sipil() {
        return status_sipil;
    }

    public void setStatus_sipil(String status_sipil) {
        this.status_sipil = status_sipil;
    }

    public static String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public static String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public static String getKode_pos() {
        return kode_pos;
    }

    public void setKode_pos(String kode_pos) {
        this.kode_pos = kode_pos;
    }

    public static String getKode_rt() {
        return kode_rt;
    }

    public void setKode_rt(String kode_rt) {
        this.kode_rt = kode_rt;
    }

    public static String getKode_rw() {
        return kode_rw;
    }

    public void setKode_rw(String kode_rw) {
        this.kode_rw = kode_rw;
    }
    
    public static Date getTglLahir(){
        Date date = null;
        String strDate;
        strDate = Integer.toString(StaticProfil.getTahun())+"-"+StaticProfil.getBulan()+"-"+Integer.toString(StaticProfil.getTanggal());
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = format.parse(strDate);
            return date;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    public static String numMonth(String M){
        String numM = "01";
        switch(M){
            case "Januari":
                numM = "01";
                break;
            case "Februari":
                numM = "02";
                break;
            case "Maret":
                numM = "03";
                break;
            case "April":
                numM = "04";
                break;
            case "Mei":
                numM = "05";
                break;
            case "Juni":
                numM = "06";
                break;
            case "Juli":
                numM = "07";
                break;
            case "Agustus":
                numM = "08";
                break;
            case "September":
                numM = "09";
                break;
            case "Oktober":
                numM = "10";
                break;
            case "November":
                numM = "11";
                break;
            case "Desember":
                numM = "12";
                break;
        }
        return numM;
    }

    public static String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public static String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public static String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }
}
