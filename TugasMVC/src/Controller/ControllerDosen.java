/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Model.Dosen.DAODosen;
import Model.Dosen.InterfaceDAODosen;
import Model.Dosen.ModelDosen;
import Model.Dosen.ModelTable;
import View.Dosen.EditData;
import View.Dosen.InputData;
import View.Dosen.ViewData;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ControllerDosen {
    ViewData halamanTable;
    InputData halamanInput;
    EditData halamanEdit;

    InterfaceDAODosen daoDosen;

    List<ModelDosen> daftarDosen;
    
    
    public ControllerDosen(ViewData halamanTable) {
        this.halamanTable = halamanTable;
        this.daoDosen = new DAODosen();
    }
    
    public ControllerDosen(InputData halamanInput){
        this.halamanInput= halamanInput;
        this.daoDosen= new DAODosen();
    }
    
    public ControllerDosen(EditData halamanEdit){
        this.halamanEdit= halamanEdit;
        this.daoDosen= new DAODosen();
        }

    public void showAllDosen() {
        daftarDosen = daoDosen.getAll();
        ModelTable table = new ModelTable(daftarDosen);
        halamanTable.getTableDosen().setModel(table);
       
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void deleteDosen(Integer baris) {
        Integer id = (int) halamanTable.getTableDosen().getValueAt(baris, 0);
        String nama = halamanTable.getTableDosen().getValueAt(baris, 1).toString();

        // Membuat Pop-Up untuk mengonfirmasi apakah ingin menghapus data
        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus Dosen",
                JOptionPane.YES_NO_OPTION
        );

        // Jika user memilih opsi "yes", maka hapus data.
        if (input == 0) {
            
            daoDosen.delete(id);
            
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");

            showAllDosen();
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void insertDosen() {
        try {
            ModelDosen dosenBaru = new ModelDosen();
            
            String nama = halamanInput.getInputNama();
            String nidn = halamanInput.getInputNidn();

            if ("".equals(nama) || "".equals(nidn)) {
                throw new Exception("Nama atau NIDN tidak boleh kosong!");
            }
            
            dosenBaru.setNama(nama);
            dosenBaru.setNidn(nidn);
            
            daoDosen.insert(dosenBaru);
            
            JOptionPane.showMessageDialog(null, "Dosen baru berhasil ditambahkan.");
            
            halamanInput.dispose();
            new View.Dosen.ViewData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void editDosen(Integer id) {
        try {
            ModelDosen dosenYangMauDiedit = new ModelDosen();
             
            String nama = halamanEdit.getInputNama();
            String nidn = halamanEdit.getInputNidn();

            if ("".equals(nama) || "".equals(nidn)) {
                throw new Exception("Nama atau NIDN tidak boleh kosong!");
            }
            
            dosenYangMauDiedit.setId(id);
            dosenYangMauDiedit.setNama(nama);
            dosenYangMauDiedit.setNidn(nidn);
            
            daoDosen.update(dosenYangMauDiedit);

            JOptionPane.showMessageDialog(null, "Data Dosen berhasil diubah.");

            halamanEdit.dispose();
            new ViewData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    

    
}
