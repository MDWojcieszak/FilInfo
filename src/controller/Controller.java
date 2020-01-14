package controller;

import View.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Controller implements ActionListener {

    private List<String> Prusa;
    private List<String> Ender;
    private List<String> Sapphire;
    private FileController file;

    private int printer;
    private int fillament_change;
    private View GUI;
    
    public Controller() throws Exception{
        this.GUI = new View();
        this.GUI.getFrame().setVisible(true);
        this.addActionListeners();

        changeLayout(0);
        Prusa = new ArrayList<>();
        Ender = new ArrayList<>();
        Sapphire = new ArrayList<>();
        this.file = new FileController(".\\info.txt");
        this.file.fileRead();
        for(int i=1;i<6;i++) {
            Prusa.add(this.file.getFileContent().get(i));
        }
        Ender.add(this.file.getFileContent().get(7));
        Sapphire.add(this.file.getFileContent().get(9));
    }
    private void addActionListeners() {
        GUI.getButton_printer_1().addActionListener(this);
        GUI.getButton_printer_2().addActionListener(this);
        GUI.getButton_printer_3().addActionListener(this);
        GUI.getButton_back().addActionListener(this);
        GUI.getButton_save().addActionListener(this);
        GUI.getEx1().addActionListener(this);
        GUI.getEx2().addActionListener(this);
        GUI.getEx3().addActionListener(this);
        GUI.getEx4().addActionListener(this);
        GUI.getEx5().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent event){
        if (((JButton) event.getSource()) == GUI.getButton_printer_1()) {
            try {
                this.printer=0;
                changeLayout(1);
               // printerButtonAction(0);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (((JButton) event.getSource()) == GUI.getButton_printer_2()) {
            try {
                this.printer=1;
                changeLayout(1);
               // printerButtonAction(1);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (((JButton) event.getSource()) == GUI.getButton_printer_3()) {
            try {
                this.printer=2;
                changeLayout(1);
               // printerButtonAction(2);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (((JButton) event.getSource()) == GUI.getButton_back()) {
            try {
                changeLayout(0);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (((JButton) event.getSource()) == GUI.getButton_save()) {
            try {
                ChangeFillament();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (((JButton) event.getSource()) == GUI.getEx1()) {
            try {
                fillament_change=0;
                changeLayout(2);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (((JButton) event.getSource()) == GUI.getEx2()) {
            try {
                fillament_change=1;
                changeLayout(2);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (((JButton) event.getSource()) == GUI.getEx3()) {
            try {
                fillament_change=2;
                changeLayout(2);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (((JButton) event.getSource()) == GUI.getEx4()) {
            try {
                fillament_change=3;
                changeLayout(2);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (((JButton) event.getSource()) == GUI.getEx5()) {
            try {
                fillament_change=4;
                changeLayout(2);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
  /*  private void printerButtonAction(int pNumber){
        this.printer = pNumber;
        changeLayout(1);
    }*/
    private void ChangeFillament(){
        String filament =GUI.getFilType().getSelectedItem().toString() + " " + GUI.getColour().getSelectedItem().toString() + " - " + GUI.getCompany().getSelectedItem().toString();
        switch (fillament_change){
            case 0:
                if(printer == 0)
                    Prusa.set(0,filament);
                else if(printer == 1)
                    Ender.set(0,filament);
                else Sapphire.set(0,filament);
                break;
            case 1:
                Prusa.set(1,filament);
                break;
            case 2:
                Prusa.set(2,filament);
                break;
            case 3:
                Prusa.set(3,filament);
                break;
            case 4:
                Prusa.set(4,filament);
                break;
        }
        saveToFile(fillament_change);
        changeLayout(1);
    }
    private void changeLayout(int layout){
        switch (layout)
        {
            case 0:
                GUI.getPanel_welcome().setVisible(true);
                GUI.getPanel_info().setVisible(false);
                GUI.getPanel_change().setVisible(false);
                break;
            case 1:
                if(printer == 0) {
                    GUI.getPrinter_label().setText(GUI.getButton_printer_1().getText());
                    GUI.getEx1().setText(Prusa.get(0));
                    GUI.getEx1().setVisible(true);
                    
                    GUI.getEx2_label().setVisible(true);
                    GUI.getEx2().setText(Prusa.get(1));
                    GUI.getEx2().setVisible(true);

                    GUI.getEx3_label().setVisible(true);
                    GUI.getEx3().setText(Prusa.get(2));
                    GUI.getEx3().setVisible(true);

                    GUI.getEx4_label().setVisible(true);
                    GUI.getEx4().setText(Prusa.get(3));
                    GUI.getEx4().setVisible(true);

                    GUI.getEx5_label().setVisible(true);
                    GUI.getEx5().setText(Prusa.get(4));
                    GUI.getEx5().setVisible(true);
                }
                else {
                    if(printer == 1) {
                        GUI.getEx1().setText(Ender.get(0));
                        GUI.getPrinter_label().setText(GUI.getButton_printer_2().getText());
                    }
                    else {
                        GUI.getPrinter_label().setText(GUI.getButton_printer_3().getText());
                        GUI.getEx1().setText(Sapphire.get(0));
                    }
                    GUI.getEx2().setVisible(false);
                    GUI.getEx2_label().setVisible(false);
                    GUI.getEx3().setVisible(false);
                    GUI.getEx3_label().setVisible(false);
                    GUI.getEx4().setVisible(false);
                    GUI.getEx4_label().setVisible(false);
                    GUI.getEx5().setVisible(false);
                    GUI.getEx5_label().setVisible(false);
                }
                GUI.getPanel_welcome().setVisible(false);
                GUI.getPanel_info().setVisible(true);
                GUI.getPanel_change().setVisible(false);
                break;
            case 2:

                GUI.getPanel_welcome().setVisible(false);
                GUI.getPanel_info().setVisible(false);
                GUI.getPanel_change().setVisible(true);
                break;
        }
    }
    private void saveToFile(int exNumber) {
        switch(printer){
            case 0:
                file.getFileContent().set(exNumber+1,Prusa.get(exNumber));
                break;
            case 1:
                file.getFileContent().set(7,Ender.get(0));
                break;
            case 2:
                file.getFileContent().set(9,Sapphire.get(0));
        }
        this.file.fileSave();
    }
}
