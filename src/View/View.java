package View;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame{
    private JButton button_printer_1;
    private JButton button_printer_2;
    private JButton button_printer_3;
    private JButton Ex1;
    private JButton Ex2;
    private JButton Ex3;
    private JButton Ex4;
    private JButton Ex5;
    private JLabel Ex1_label;
    private JLabel Ex2_label;
    private JLabel Ex3_label;
    private JLabel Ex4_label;
    private JLabel Ex5_label;
    private JButton button_back;
    private JButton button_save;
    private JPanel panel_welcome;
    private JPanel panel_info;
    private JPanel panel_change;

    private JComboBox colour;
    private JComboBox company;
    private JComboBox filType;

    private JLabel printer_label;
    private JFrame frame;
    
    public View(){
        initializeView();
    }
    private void initializeView(){
        frame = new JFrame();
        frame.setBounds(100, 100, 300, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

        JLayeredPane layeredPane_1 = new JLayeredPane();
        frame.getContentPane().add(layeredPane_1);

        panel_change = new JPanel();
        panel_change.setBounds(0, 0, 284, 311);
        layeredPane_1.add(panel_change);
        panel_change.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lblFilaments = new JLabel("FILAMENT");
        lblFilaments.setHorizontalAlignment(SwingConstants.CENTER);
        lblFilaments.setFont(new Font("Times New Roman", Font.BOLD, 24));
        panel_change.add(lblFilaments);
        DefaultListModel<String> company_list = new DefaultListModel<>();
        company_list.addElement("3D Active");
        company_list.addElement("Wolfix");
        company_list.addElement("Prusament");

        JLabel lblCompany = new JLabel("  Choose Company:");
        lblCompany.setFont(new Font("Times New Roman", Font.BOLD, 16));
        panel_change.add(lblCompany);

        company = new JComboBox();
        for(int i=0;i<3;i++)
            company.addItem(company_list.get(i));
        panel_change.add(company);

        JLabel lblType = new JLabel("  Choose Type:");
        lblType.setFont(new Font("Times New Roman", Font.BOLD, 16));
        panel_change.add(lblType);

        DefaultListModel<String> type_list = new DefaultListModel<>();
        type_list.addElement("PLA");
        type_list.addElement("ABS");
        type_list.addElement("PETG");
        type_list.addElement("HIPS");

        filType = new JComboBox();
        for(int i=0;i<4;i++)
            filType.addItem(type_list.get(i));
        panel_change.add(filType);

        JLabel lblColour = new JLabel("  Choose Colour:");
        lblColour.setFont(new Font("Times New Roman", Font.BOLD, 16));
        panel_change.add(lblColour);

        DefaultListModel<String> colout_list = new DefaultListModel<>();
        colout_list.addElement("White");
        colout_list.addElement("Black");
        colout_list.addElement("Green");
        colout_list.addElement("Orange");
        colout_list.addElement("Red");
        colout_list.addElement("Lime");
        colout_list.addElement("Blue");

        colour = new JComboBox();
        for(int i=0;i<7;i++)
            colour.addItem(colout_list.get(i));
        panel_change.add(colour);

        button_save = new JButton("SAVE");
        button_save.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel_change.add(button_save);


// panel_welcome 2
        panel_info = new JPanel();
        panel_info.setBounds(0, 0, 284, 311);
        layeredPane_1.add(panel_info);
        panel_info.setLayout(new GridLayout(0, 1, 0, 0));

        printer_label = new JLabel("Prusa i3 MK3S");
        printer_label.setHorizontalTextPosition(SwingConstants.CENTER);
        panel_info.add(printer_label);
        printer_label.setFont(new Font("Times New Roman", Font.BOLD, 24));
        printer_label.setHorizontalAlignment(SwingConstants.CENTER);

        Ex1_label= new JLabel("Extruder 1");
        panel_info.add(Ex1_label);

        Ex1 = new JButton("");
        Ex1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_info.add(Ex1);

        Ex2_label = new JLabel("Extruder 2");
        panel_info.add(Ex2_label);

        Ex2 = new JButton("");
        Ex2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_info.add(Ex2);

        Ex3_label = new JLabel("Extruder 3");
        panel_info.add(Ex3_label);

        Ex3 = new JButton("");
        Ex3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_info.add(Ex3);

        Ex4_label = new JLabel("Extruder 4");
        panel_info.add(Ex4_label);

        Ex4 = new JButton("");
        Ex4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_info.add(Ex4);

        Ex5_label = new JLabel("Extruder 5");
        panel_info.add(Ex5_label);

        Ex5 = new JButton("");
        Ex5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_info.add(Ex5);


        button_back = new JButton("BACK");
        button_back.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel_info.add(button_back);

// panel_welcome printers
        panel_welcome = new JPanel();
        panel_welcome.setBounds(0, 0, 284, 311);
        layeredPane_1.add(panel_welcome);
        panel_welcome.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lblPrinters = new JLabel("PRINTERS:");
        panel_welcome.add(lblPrinters);
        lblPrinters.setHorizontalAlignment(SwingConstants.CENTER);
        lblPrinters.setFont(new Font("Times New Roman", Font.BOLD, 24));

        button_printer_1 = new JButton("Prusa i3 MK3S");
        panel_welcome.add(button_printer_1);
        button_printer_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button_printer_1.setFont(new Font("Times New Roman", Font.BOLD, 20));

        button_printer_2 = new JButton("Ender 3");
        panel_welcome.add(button_printer_2);
        button_printer_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button_printer_2.setFont(new Font("Times New Roman", Font.BOLD, 20));

        button_printer_3 = new JButton("Sapphire PRO");
        panel_welcome.add(button_printer_3);
        button_printer_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button_printer_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
    }
    public JButton getButton_printer_1() {
        return button_printer_1;
    }

    public JButton getButton_printer_2() {
        return button_printer_2;
    }

    public JButton getButton_printer_3() {
        return button_printer_3;
    }

    public JButton getEx1() {
        return Ex1;
    }

    public JButton getEx2() {
        return Ex2;
    }

    public JButton getEx3() {
        return Ex3;
    }

    public JButton getEx4() {
        return Ex4;
    }

    public JButton getEx5() {
        return Ex5;
    }

    public JLabel getEx1_label() {
        return Ex1_label;
    }

    public JLabel getEx2_label() {
        return Ex2_label;
    }

    public JLabel getEx3_label() {
        return Ex3_label;
    }

    public JLabel getEx4_label() {
        return Ex4_label;
    }

    public JLabel getEx5_label() {
        return Ex5_label;
    }

    public JButton getButton_back() {
        return button_back;
    }

    public JButton getButton_save() {
        return button_save;
    }

    public JPanel getPanel_welcome() {
        return panel_welcome;
    }

    public JPanel getPanel_info() {
        return panel_info;
    }

    public JPanel getPanel_change() {
        return panel_change;
    }

    public JComboBox getColour() {
        return colour;
    }

    public JComboBox getCompany() {
        return company;
    }
    public JComboBox getFilType() {
        return filType;
    }

    public JLabel getPrinter_label() {
        return printer_label;
    }

    public JFrame getFrame() {
        return frame;
    }
}
