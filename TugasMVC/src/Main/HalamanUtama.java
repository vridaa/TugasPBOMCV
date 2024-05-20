/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author ASUS
 */
public class HalamanUtama extends JFrame implements ActionListener {
    JButton tomboldosen = new JButton("Dosen");
    JButton tombolmahasiswa = new JButton("Mahasiswa");
    
    public HalamanUtama(){
        setTitle("Halaman Utama");
        setVisible(true);
        setLayout(null);
        setSize(560, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add (tomboldosen);
        tomboldosen.setBounds(20, 70, 240, 50);
        tomboldosen.addActionListener(this);
        
        add (tombolmahasiswa);
        tombolmahasiswa.setBounds(280, 70, 240, 50);
        tombolmahasiswa.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == tombolmahasiswa){
        new  View.Mahasiswa.ViewData();
        this.dispose();
    } else if (e.getSource()==tomboldosen){
        new View.Dosen.ViewData();
        this.dispose();
    }
    
    } 
}
