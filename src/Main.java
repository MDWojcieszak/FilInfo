import jdk.jshell.tool.JavaShellToolBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;

public class Main {
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
    private JButton back;
    private JButton save_button;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;

    private JComboBox colour;
    private JComboBox company;
    private JComboBox type;

    private JLabel printer_label;
    private JFrame frame;
    private int printer;
    private int fillament_change;
    private List<String> Prusa;
    private List<String> Ender;
    private List<String> Sapphire;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Main() {
        initialize();
        actualLayout(0);
        actions();
        Prusa = new ArrayList<>();
        Ender = new ArrayList<>();
        Sapphire = new ArrayList<>();
        for(int i=0;i<5;i++) {
            Prusa.add("WIP");
            Ender.add("WIP");
            Sapphire.add("WIP");
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void actualLayout(int layout){
        switch (layout)
        {
            case 0:
                panel.setVisible(true);
                panel_1.setVisible(false);
                panel_2.setVisible(false);
                break;
            case 1:
                if(printer == 0) {
                    printer_label.setText(button_printer_1.getText());
                    Ex1.setText(Prusa.get(0));
                    Ex2.setVisible(true);
                    Ex2_label.setVisible(true);
                    Ex2.setText(Prusa.get(1));
                    Ex3.setVisible(true);
                    Ex3_label.setVisible(true);
                    Ex3.setText(Prusa.get(2));
                    Ex4.setVisible(true);
                    Ex4_label.setVisible(true);
                    Ex4.setText(Prusa.get(3));
                    Ex5.setVisible(true);
                    Ex5_label.setVisible(true);
                    Ex5.setText(Prusa.get(4));
                }
                else {
                    if(printer == 1) {
                        Ex1.setText(Ender.get(0));
                        printer_label.setText(button_printer_2.getText());
                    }
                    else {
                        printer_label.setText(button_printer_3.getText());
                        Ex1.setText(Sapphire.get(0));
                    }
                    Ex2.setVisible(false);
                    Ex2_label.setVisible(false);
                    Ex3.setVisible(false);
                    Ex3_label.setVisible(false);
                    Ex4.setVisible(false);
                    Ex4_label.setVisible(false);
                    Ex5.setVisible(false);
                    Ex5_label.setVisible(false);
                }
                panel.setVisible(false);
                panel_1.setVisible(true);
                panel_2.setVisible(false);
                break;
            case 2:

                panel.setVisible(false);
                panel_1.setVisible(false);
                panel_2.setVisible(true);
                break;
        }
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 300, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

        JLayeredPane layeredPane_1 = new JLayeredPane();
        frame.getContentPane().add(layeredPane_1);

        panel_2 = new JPanel();
        panel_2.setBounds(0, 0, 284, 311);
        layeredPane_1.add(panel_2);
        panel_2.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lblFilaments = new JLabel("FILAMENT");
        lblFilaments.setHorizontalAlignment(SwingConstants.CENTER);
        lblFilaments.setFont(new Font("Times New Roman", Font.BOLD, 24));
        panel_2.add(lblFilaments);
        DefaultListModel<String> company_list = new DefaultListModel<>();
        company_list.addElement("3D Active");
        company_list.addElement("Wolfix");
        company_list.addElement("Prusament");

        JLabel lblCompany = new JLabel("  Choose Company:");
        lblCompany.setFont(new Font("Times New Roman", Font.BOLD, 16));
        panel_2.add(lblCompany);

        company = new JComboBox();
        for(int i=0;i<3;i++)
            company.addItem(company_list.get(i));
        panel_2.add(company);

        JLabel lblType = new JLabel("  Choose Type:");
        lblType.setFont(new Font("Times New Roman", Font.BOLD, 16));
        panel_2.add(lblType);

        DefaultListModel<String> type_list = new DefaultListModel<>();
        type_list.addElement("PLA");
        type_list.addElement("ABS");
        type_list.addElement("PETG");
        type_list.addElement("HIPS");

        type = new JComboBox();
        for(int i=0;i<4;i++)
            type.addItem(type_list.get(i));
        panel_2.add(type);

        JLabel lblColour = new JLabel("  Choose Colour:");
        lblColour.setFont(new Font("Times New Roman", Font.BOLD, 16));
        panel_2.add(lblColour);

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
        panel_2.add(colour);

        save_button = new JButton("SAVE");
        save_button.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel_2.add(save_button);


// panel 2
        panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 284, 311);
        layeredPane_1.add(panel_1);
        panel_1.setLayout(new GridLayout(0, 1, 0, 0));

        printer_label = new JLabel("Prusa i3 MK3S");
        printer_label.setHorizontalTextPosition(SwingConstants.CENTER);
        panel_1.add(printer_label);
        printer_label.setFont(new Font("Times New Roman", Font.BOLD, 24));
        printer_label.setHorizontalAlignment(SwingConstants.CENTER);

        Ex1_label= new JLabel("Extruder 1");
        panel_1.add(Ex1_label);

        Ex1 = new JButton("");
        Ex1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_1.add(Ex1);

        Ex2_label = new JLabel("Extruder 2");
        panel_1.add(Ex2_label);

        Ex2 = new JButton("");
        Ex2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_1.add(Ex2);

        Ex3_label = new JLabel("Extruder 3");
        panel_1.add(Ex3_label);

        Ex3 = new JButton("");
        Ex3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_1.add(Ex3);

        Ex4_label = new JLabel("Extruder 4");
        panel_1.add(Ex4_label);

        Ex4 = new JButton("");
        Ex4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_1.add(Ex4);

        Ex5_label = new JLabel("Extruder 5");
        panel_1.add(Ex5_label);

        Ex5 = new JButton("");
        Ex5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_1.add(Ex5);


        back = new JButton("BACK");
        back.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel_1.add(back);

// panel printers
        panel = new JPanel();
        panel.setBounds(0, 0, 284, 311);
        layeredPane_1.add(panel);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lblPrinters = new JLabel("PRINTERS:");
        panel.add(lblPrinters);
        lblPrinters.setHorizontalAlignment(SwingConstants.CENTER);
        lblPrinters.setFont(new Font("Times New Roman", Font.BOLD, 24));

        button_printer_1 = new JButton("Prusa i3 MK3S");
        panel.add(button_printer_1);
        button_printer_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button_printer_1.setFont(new Font("Times New Roman", Font.BOLD, 20));

        button_printer_2 = new JButton("Ender 3");
        panel.add(button_printer_2);
        button_printer_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button_printer_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        
        button_printer_3 = new JButton("Sapphire PRO");
        panel.add(button_printer_3);
        button_printer_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button_printer_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        
    }
    private void actions(){
        button_printer_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                printer = 0;
                actualLayout(1);
            }
        });
        button_printer_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                printer = 1;
                actualLayout(1);
            }
        });
        button_printer_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                printer = 2;
                actualLayout(1);
            }
        });
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                printer = -1;
                actualLayout(0);
            }
        });
        Ex1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                fillament_change=0;
                actualLayout(2);
            }
        });
        Ex2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                fillament_change=1;
                actualLayout(2);
            }
        });
        Ex3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                fillament_change=2;
                actualLayout(2);
            }
        });
        Ex4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                fillament_change=3;
                actualLayout(2);
            }
        });
        Ex5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                fillament_change=4;
                actualLayout(2);
            }
        });
        save_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String temp =type.getSelectedItem().toString() + " " + colour.getSelectedItem().toString() + " - " + company.getSelectedItem().toString();
                switch (fillament_change){
                    case 0:
                        if(printer == 0)
                            Prusa.set(0,temp);
                        else if(printer == 1)
                            Ender.set(0,temp);
                        else Sapphire.set(0,temp);
                        break;
                    case 1:
                        Prusa.set(1,temp);
                        break;
                    case 2:
                        Prusa.set(2,temp);
                        break;
                    case 3:
                        Prusa.set(3,temp);
                        break;
                    case 4:
                        Prusa.set(4,temp);
                        break;
                }
                actualLayout(1);
            }
        });
    }
}
