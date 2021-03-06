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

import Controllers.Riwayat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author programmer
 */
public class RiwayatTabelModel  extends AbstractTableModel{
    List<Riwayat> histories =new ArrayList<Riwayat>();
 
    /*** Nama Kolom ***/
    private final String HEADER[]={"NIP","Nama","Mata Pelajaran", "Tahun Ajaran"};
    
    /*** Memasukkan data awal dari database ke tabel model
     * @param histories ***/
    public RiwayatTabelModel(List<Riwayat> histories){
        this.histories = histories;
    }
    
    /*** Menambahkan sebuah data ke tabel model
     * @param history ***/
    public void saveProfil(Riwayat history){
        histories.add(history);
        fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
    }
    
    /*** Melakukan perubahan data yang ada pada tabel model
     * @param index
     * @param profil ***/
    public void updateHistory(int index, Riwayat history){
        histories.set(index, history);
        fireTableRowsUpdated(index, index);
    }
    
    /*** Menghapus data pada tabel model
     * @param index ***/
    public void deleteHistory(int index){
        histories.remove(index);
        fireTableRowsDeleted(index, index);
    }
    
    /*** Mendapatkan data pada tabel model
     * @param index
     * @return  ***/
    public Riwayat getHistory(int index){
        return histories.get(index);
    }
 
    /*** Mendapatkan banyak data
     * @return  ***/
    @Override
    public int getRowCount() {
        return histories.size();
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
        Riwayat history = histories.get(rowIndex);
        
        switch(columnIndex){
            case 0: return history.getNip();
            case 1: return history.getNama();
            case 2: return history.getMataPelajaran();
            case 3: return history.getTahunAjar();
            default: return null;
        }
    }
}
