package dev.mehdipoor;

import javax.swing.*;
import java.awt.*;

public class CalculatorUI extends Calculator{
    // Attribute
    String operator = "";
    static JTextField input;
    static String auxiliary;
    final static int WIDTH_BTN = 95;
    final static int HEIGHT_BTN = 45;
    final static Color BackgroundColorBtn = new Color(232, 234, 246);
    final static Font FontBtn = new Font("SansSerif", Font.BOLD, 20);

    public void UserInterface(){
        Color white = new Color(255, 255, 255);

        JFrame window = new JFrame();
            window.setLayout(null);
            window.setVisible(true);
            window.setResizable(false);
            window.setTitle("Calculator");
            window.setSize(409, 331);
            window.getContentPane().setBackground(white);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        input = new JTextField();
            window.add(input);
            input.setBounds(0, 0 , 400, 50);
            input.setBorder(null);
            input.setFont(FontBtn);

        JButton one = getButton("1", 0, 200, WIDTH_BTN, HEIGHT_BTN);
            window.add(one);
            one.setFont(FontBtn);
            one.setBackground(BackgroundColorBtn);

        JButton tow = getButton("2", 100, 200, WIDTH_BTN, HEIGHT_BTN);
            window.add(tow);
            tow.setFont(FontBtn);
            tow.setBackground(BackgroundColorBtn);

        JButton three = getButton("3", 200, 200, WIDTH_BTN, HEIGHT_BTN);
            window.add(three);
            three.setFont(FontBtn);
            three.setBackground(BackgroundColorBtn);

        JButton four = getButton("4", 0, 150, WIDTH_BTN, HEIGHT_BTN);
            window.add(four);
            four.setFont(FontBtn);
            four.setBackground(BackgroundColorBtn);

        JButton five = getButton("5", 100, 150, WIDTH_BTN, HEIGHT_BTN);
            window.add(five);
            five.setFont(FontBtn);
            five.setBackground(BackgroundColorBtn);

        JButton six = getButton("6", 200, 150, WIDTH_BTN, HEIGHT_BTN);
            window.add(six);
            six.setFont(FontBtn);
            six.setBackground(BackgroundColorBtn);

        JButton seven = getButton("7", 0, 100, WIDTH_BTN, HEIGHT_BTN);
            window.add(seven);
            seven.setFont(FontBtn);
            seven.setBackground(BackgroundColorBtn);

        JButton eight = getButton("8", 100, 100, WIDTH_BTN, HEIGHT_BTN);
            window.add(eight);
            eight.setFont(FontBtn);
            eight.setBackground(BackgroundColorBtn);

        JButton nine = getButton("9", 200, 100, WIDTH_BTN, HEIGHT_BTN);
            window.add(nine);
            nine.setFont(FontBtn);
            nine.setBackground(BackgroundColorBtn);

        JButton zero = new JButton("0");
            window.add(zero);
            zero.addActionListener(event ->{
                if (input.getText().contentEquals("0") || input.getText().isEmpty()){
                    input.setText(zero.getText() + ".");
                }else {
                    input.setText(input.getText() + zero.getText());
                }
            });
            zero.setBorder(null);
            zero.setFont(FontBtn);
            zero.setBackground(BackgroundColorBtn);
            zero.setFocusPainted(false);
            zero.setBounds(100, 250, WIDTH_BTN, HEIGHT_BTN);

        JButton clear = new JButton("C");
            window.add(clear);
            clear.addActionListener(event -> {
                input.setText("");
                auxiliary = "";
                operator = "";
            });
            clear.setBorder(null);
            clear.setFont(FontBtn);
            clear.setBackground(BackgroundColorBtn);
            clear.setFocusPainted(false);
            clear.setBounds(0, 50, 295, HEIGHT_BTN);

        JButton addition = new JButton("+");
            window.add(addition);
            addition.addActionListener(event -> {
                if (!input.getText().isEmpty())auxiliary = input.getText();
                input.setText("");
                this.operator = "+";
            });
            addition.setBorder(null);
            addition.setFont(FontBtn);
            addition.setBackground(BackgroundColorBtn);
            addition.setFocusPainted(false);
            addition.setBounds(300, 200, WIDTH_BTN, HEIGHT_BTN);

        JButton minus = new JButton("-");
            window.add(minus);
            minus.addActionListener(event -> {
                if (!input.getText().isEmpty())auxiliary = input.getText();
                input.setText("");
                this.operator = "-";
            });
            minus.setBorder(null);
            minus.setFont(FontBtn);
            minus.setBackground(BackgroundColorBtn);
            minus.setFocusPainted(false);
            minus.setBounds(300, 150, WIDTH_BTN, HEIGHT_BTN);

        JButton multiplication = new JButton("×");
            window.add(multiplication);
            multiplication.addActionListener(event -> {
                if (!input.getText().isEmpty())auxiliary = input.getText();
                input.setText("");
                this.operator = "*";
            });
            multiplication.setBorder(null);
            multiplication.setFont(FontBtn);
            multiplication.setBackground(BackgroundColorBtn);
            multiplication.setFocusPainted(false);
            multiplication.setBounds(300, 100, WIDTH_BTN, HEIGHT_BTN);

        JButton division = new JButton("/");
            window.add(division);
            division.addActionListener(event -> {
                if (!input.getText().isEmpty())auxiliary = input.getText();
                input.setText("");
                this.operator = "/";
            });
            division.setBorder(null);
            division.setFont(FontBtn);
            division.setBackground(BackgroundColorBtn);
            division.setFocusPainted(false);
            division.setBounds(300, 50, WIDTH_BTN, HEIGHT_BTN);

        JButton point = new JButton(".");
            window.add(point);
            point.addActionListener(event -> {
                if (input.getText().isEmpty()){

                }else {
                    input.setText(getTextPoint(input, point));
                }
            });
            point.setBorder(null);
            point.setFont(FontBtn);
            point.setBackground(BackgroundColorBtn);
            point.setFocusPainted(false);
            point.setBounds(0, 250, WIDTH_BTN, HEIGHT_BTN);

        JButton equal = new JButton("=");
            window.add(equal);
            equal.addActionListener(event -> {
                if (!input.getText().isEmpty() && !operator.isEmpty())input.setText(calculation(this.auxiliary, input.getText(), operator));
            });
            equal.setBorder(null);
            equal.setFont(FontBtn);
            equal.setBackground(BackgroundColorBtn);
            equal.setFocusPainted(false);
            equal.setBounds(200, 250, 195, HEIGHT_BTN);
    }

    private static JButton getButton(String Label, int xPosition, int yPosition, int Width, int Height) {
        JButton btn = new JButton(Label);
        btn.setBorder(null);
        btn.setFocusPainted(false);
        btn.setBounds(xPosition, yPosition, Width, Height);
        btn.addActionListener(event -> input.setText(input.getText() + btn.getText()));
        return btn;
    }

    private static String getTextPoint(JTextField input, JButton point) {
        String str = input.getText();
        if (!str.contains(".")){
            str = input.getText() + point.getText();
        }
        return str;
    }
}
