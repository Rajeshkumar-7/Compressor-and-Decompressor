/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author rajes
 */
public class Appframe extends JFrame implements ActionListener{

// Creating two buttons
    JButton compressButton;
    JButton decompressButton;
    
    Appframe(){
        
        this.setLayout(null);   
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel headingLabel = new JLabel("Compressor and Decompressor");
        headingLabel.setBounds(200, 150, 350, 30);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        
        compressButton = new JButton("Select file to compress");
        compressButton.setBounds(100 , 280 , 200 , 30);
        compressButton.addActionListener(this);
        
        decompressButton = new JButton("Select file to decompress");
        decompressButton.setBounds(400 , 280 , 200 , 30);
        decompressButton.addActionListener(this);
        
        this.add(headingLabel);
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(750,750); 
        this.getContentPane().setBackground(Color.black);
        this.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == compressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null , ee.toString());
                }
            }
            
        }
        
        if(e.getSource() == decompressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    decompressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null , ee.toString());
                }
            }
            
        }
    }
}
