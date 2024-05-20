package View.Mahasiswa;

import Controller.ControllerMahasiswa;
import Main.HalamanUtama;
import Model.Mahasiswa.ModelMahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewData extends JFrame {

    Integer baris;
    ControllerMahasiswa controller;

    // Menginisiasi komponen
    JLabel header = new JLabel("Selamat Datang!");
    JButton tombolTambah = new JButton("Tambah Mahasiswa");
    JButton tombolEdit = new JButton("Edit Mahasiswa");
    JButton tombolHapus = new JButton("Hapus Mahasiswa");
    JButton tombolkembali= new JButton("Kembali");

    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    String namaKolom[] = {"ID", "Nama", "NIM"};

    public ViewData() {
        tableModel = new DefaultTableModel(namaKolom, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        setTitle("Daftar Mahasiswa");
        setVisible(true);
        setLayout(null);
        setSize(560, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(header);
        add(scrollPane);
        add(tombolTambah);
        add(tombolEdit);
        add(tombolHapus);
        add(tombolkembali);

        header.setBounds(20, 8, 440, 24);
        scrollPane.setBounds(20, 36, 512, 320);
        tombolTambah.setBounds(20, 370, 512, 40);
        tombolEdit.setBounds(20, 414, 512, 40);
        tombolHapus.setBounds(20, 456, 512, 40);
        tombolkembali.setBounds(20,498,512,40);

        controller = new ControllerMahasiswa(this);
        controller.showAllMahasiswa();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                baris = table.getSelectedRow();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InputData();
            }
        });
        
        tombolkembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HalamanUtama();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {

                    ModelMahasiswa mahasiswaTerpilih = new ModelMahasiswa();
                    Integer id = (int) table.getValueAt(baris, 0);
                    String nama = table.getValueAt(baris, 1).toString();
                    String nim = table.getValueAt(baris, 2).toString();

                    mahasiswaTerpilih.setId(id);
                    mahasiswaTerpilih.setNama(nama);
                    mahasiswaTerpilih.setNim(nim);

                    dispose();
                    new EditData(mahasiswaTerpilih);
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });

        tombolHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {
                    controller.deleteMahasiswa(baris);
                    baris = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });
    }

    public JTable getTableMahasiswa() {
        return table;
    }

}
