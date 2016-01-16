package Controllers;

import Models.ProfilModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author programmer
 */
public class Profil {
    private String nip;
    private String nama;
    private String lulusan;
    private String mata_pelajaran;
    private char jenis_kelamin;
    private String tempat_lahir;
    private int tanggal;
    private String bulan;
    private int tahun;
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
    
    public ProfilModel getProfilM(){
        return new ProfilModel();
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLulusan() {
        return lulusan;
    }

    public void setLulusan(String lulusan) {
        this.lulusan = lulusan;
    }

    public String getMata_pelajaran() {
        return mata_pelajaran;
    }

    public void setMata_pelajaran(String mata_pelajaran) {
        this.mata_pelajaran = mata_pelajaran;
    }

    public char getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(char jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public int getTanggal() {
        return tanggal;
    }

    public void setTanggal(int tanggal) {
        this.tanggal = tanggal;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getWarga_negara() {
        return warga_negara;
    }

    public void setWarga_negara(String warga_negara) {
        this.warga_negara = warga_negara;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getStatus_sipil() {
        return status_sipil;
    }

    public void setStatus_sipil(String status_sipil) {
        this.status_sipil = status_sipil;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getKode_pos() {
        return kode_pos;
    }

    public void setKode_pos(String kode_pos) {
        this.kode_pos = kode_pos;
    }

    public String getKode_rt() {
        return kode_rt;
    }

    public void setKode_rt(String kode_rt) {
        this.kode_rt = kode_rt;
    }

    public String getKode_rw() {
        return kode_rw;
    }

    public void setKode_rw(String kode_rw) {
        this.kode_rw = kode_rw;
    }
    
    public Date getTglLahir(){
        Date date = null;
        String strDate;
        strDate = Integer.toString(this.getTahun())+"-"+this.getBulan()+"-"+Integer.toString(this.getTanggal());
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = format.parse(strDate);
            return date;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    public String numMonth(String M){
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

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }
}
