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
package Helpers;

import Controllers.Profil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author programmer
 */
public class ProfilTabelModel extends AbstractTableModel{
    List<Profil> profiles =new ArrayList<Profil>();
 
    /*** Nama Kolom ***/
    private final String HEADER[]={"NIP","Nama","Lulusan", "Warga Negara"};
    
    /*** Memasukkan data awal dari database ke tabel model
     * @param profiles ***/
    public ProfilTabelModel(List<Profil> profiles){
        this.profiles = profiles;
    }
    
    /*** Menambahkan sebuah data ke tabel model
     * @param profil ***/
    public void saveProfil(Profil profil){
        profiles.add(profil);
        fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
    }
    
    /*** Melakukan perubahan data yang ada pada tabel model
     * @param index
     * @param profil ***/
    public void updateProfil(int index, Profil profil){
        profiles.set(index, profil);
        fireTableRowsUpdated(index, index);
    }
    
    /*** Menghapus data pada tabel model
     * @param index ***/
    public void deleteProfil(int index){
        profiles.remove(index);
        fireTableRowsDeleted(index, index);
    }
    
    /*** Mendapatkan data pada tabel model
     * @param index
     * @return  ***/
    public Profil getProfil(int index){
        return profiles.get(index);
    }
 
    /*** Mendapatkan banyak data
     * @return  ***/
    @Override
    public int getRowCount() {
        return profiles.size();
    }
 
    /*** Mendapatkan jumlah kolom
     * @return  ***/
    @Override
    public int getColumnCount() {
        return HEADER.length;
    }
    
    /*** Mendapatkan nama kolom
     * @return  ***/
    @Override
    public String getColumnName(int column){
        return HEADER[column];
    }
 
   /*** Mendapatkan sebuah nilai pada kolom dan baris tertentu
     * @param rowIndex
     * @param columnIndex
     * @return  ***/
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Profil profil = profiles.get(rowIndex);
        
        switch(columnIndex){
            case 0: return profil.getNip();
            case 1: return profil.getNama();
            case 2: return profil.getLulusan();
            case 3: return profil.getNegara();
            default: return null;
        }
    }
}
