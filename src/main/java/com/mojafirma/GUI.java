package com.mojafirma;
import com.sun.xml.internal.ws.handler.HandlerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class GUI extends JFrame {

    public GUI() throws HandlerException, IOException {
        iniGUI();
    }

    private void iniGUI() throws IOException {
        setTitle("Dane użytkowników");
        setSize(600, 600);
        setLocation(50, 10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout borderLayout = new BorderLayout();

        JPanel panel1 = new JPanel();
        GridLayout gridLayout = new GridLayout(1, 3);
        panel1.setLayout(gridLayout);
        Font font1 = new Font("", Font.BOLD, 16);

        JLabel label1 = new JLabel("Imię");
        label1.setFont(font1);
        JLabel label2 = new JLabel("Nazwisko");
        label2.setFont(font1);
        JLabel label3 = new JLabel("Wiek");
        label3.setFont(font1);
        panel1.add(label1);
        panel1.add(label2);
        panel1.add(label3);
        getContentPane().add(panel1, borderLayout.NORTH);

        JPanel panel2 = new JPanel();
        GridLayout gridLayout2 = new GridLayout(1, 3);
        panel2.setLayout(gridLayout2);
        Font font2 = new Font("", Font.ITALIC, 13);

        JTextArea labelName = new JTextArea();
        labelName.setFont(font2);
        labelName.setEditable(false);
        JTextArea labelLName = new JTextArea();
        labelLName.setFont(font2);
        labelLName.setEditable(false);
        JTextArea labelAge = new JTextArea();
        labelAge.setFont(font2);
        labelAge.setEditable(false);
        panel2.add(labelName);
        panel2.add(labelLName);
        panel2.add(labelAge);
        getContentPane().add(panel2, borderLayout.CENTER);

        JPanel panel3 = new JPanel();
        GridLayout gridLayout3 = new GridLayout(1, 3);
        panel3.setLayout(gridLayout3);

        JTextField textName = new JTextField("Wprowadż imię");
        JTextField textLName = new JTextField("Wprowadż nazwisko");
        JTextField textAge = new JTextField("Wprowadż wiek");
        JButton button = new JButton("Dodaj do bazy");
        JButton button2 = new JButton("Wyczyść bazę");
        panel3.add(textName);
        panel3.add(textLName);
        panel3.add(textAge);
        panel3.add(button);
        panel3.add(button2);
        getContentPane().add(panel3, borderLayout.SOUTH);

        String fileContent = FileData.getData();

        ArrayList<User> users = new ArrayList<>();
        String splitText[] = fileContent.split("\\s");
        int i = 0;
        while (i < splitText.length && (splitText.length % 3 == 0)) {
            if (splitText.length % 3 == 0) {
            String userName = splitText[i];
            i++;
            String userLastName = splitText[i];
            i++;
            String userAge = splitText[i];
            users.add(new User(userName, userLastName, userAge));
            i++; } else {
                labelName.setText(" ");
                labelLName.setText(" ");
                labelAge.setText(" ");
            }
        }
        String textLabelName = "";
        String textLabelLastName = "";
        String textLabelAge = "";

        for (int j = 0; j < users.size(); ++j) {
            textLabelName = textLabelName + "\n" + users.get(j).getName();
            textLabelLastName = textLabelLastName + "\n" + users.get(j).getLastname();
            textLabelAge = textLabelAge + "\n" + users.get(j).getAge();
        }
        labelName.setText(textLabelName);
        labelLName.setText(textLabelLastName);
        labelAge.setText(textLabelAge);

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelName.setText("");
                labelLName.setText("");
                labelAge.setText("");
                users.clear();
                System.out.println(users);
                try {
                    FileData.setData(users);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String addName = labelName.getText() + "\n" + textName.getText();
                labelName.setText(addName);
                String addLastName = labelLName.getText() + "\n" + textLName.getText();
                labelLName.setText(addLastName);
                String addAge = labelAge.getText() + "\n" + textAge.getText();
                labelAge.setText(addAge);
                users.add(new User(textName.getText(), textLName.getText(), textAge.getText()));
                try {
                    FileData.setData(users);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}



