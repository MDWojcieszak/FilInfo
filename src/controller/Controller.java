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

    private int printer;
    private int fillament_change;
    private View GUI;
    
    public Controller() throws Exception{
        this.GUI = new View();
        this.GUI.getFrame().setVisible(true);
        this.addActionListeners();

        actualLayout(0);
        Prusa = new ArrayList<>();
        Ender = new ArrayList<>();
        Sapphire = new ArrayList<>();
        for(int i=0;i<5;i++) {
            Prusa.add("WIP");
            Ender.add("WIP");
            Sapphire.add("WIP");
        }
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
                actualLayout(1);
               // printerButtonAction(0);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (((JButton) event.getSource()) == GUI.getButton_printer_2()) {
            try {
                this.printer=1;
                actualLayout(1);
               // printerButtonAction(1);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (((JButton) event.getSource()) == GUI.getButton_printer_3()) {
            try {
                this.printer=2;
                actualLayout(1);
               // printerButtonAction(2);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (((JButton) event.getSource()) == GUI.getButton_back()) {
            try {
                actualLayout(0);
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
                actualLayout(2);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (((JButton) event.getSource()) == GUI.getEx2()) {
            try {
                fillament_change=1;
                actualLayout(2);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (((JButton) event.getSource()) == GUI.getEx3()) {
            try {
                fillament_change=2;
                actualLayout(2);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (((JButton) event.getSource()) == GUI.getEx4()) {
            try {
                fillament_change=3;
                actualLayout(2);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (((JButton) event.getSource()) == GUI.getEx5()) {
            try {
                fillament_change=4;
                actualLayout(2);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
  /*  private void printerButtonAction(int pNumber){
        this.printer = pNumber;
        actualLayout(1);
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
        actualLayout(1);
    }
    private void actualLayout(int layout){
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
}
