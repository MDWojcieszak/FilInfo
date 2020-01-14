import controller.Controller;

import java.awt.*;


public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Controller controller = new Controller();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
