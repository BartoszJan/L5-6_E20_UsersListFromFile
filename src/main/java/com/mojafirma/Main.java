package com.mojafirma;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI gui = null;
                try {
                    gui = new GUI();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                gui.setVisible(true);
            }
        });

    }
}
