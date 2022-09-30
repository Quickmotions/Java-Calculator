// Fergus Haak - 28/09/2022 - Java Calculator

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Main implements ActionListener {
    private static JLabel outputView;
    private static String finalNum;
    private static String currentNum;
    private static String currentOperation;

    public Main() {
        JFrame frame = new JFrame();
        JPanel buttonPanel = new JPanel();
        JPanel outputPanel = new JPanel();

        // Frame
        frame.setBounds(100, 100, 400, 1200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Components
        currentNum = "";
        finalNum = "";
        currentOperation = "";
        outputView = new JLabel("");

        JButton zero = new JButton("0");
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton multiply = new JButton("x");
        JButton divide = new JButton("/");
        JButton equals = new JButton("=");
        JButton reset = new JButton("CE");
        JButton undo = new JButton("C");


        zero.addActionListener(this);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        plus.addActionListener(this);
        minus.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);
        equals.addActionListener(this);
        reset.addActionListener(this);
        undo.addActionListener(this);


        // Panel
        //outputPanel.setLayout(null);
        outputPanel.setLayout(new GridLayout(0, 1, 80, 40));
        outputPanel.add(outputView);
        outputPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        outputPanel.setBounds(8, 0, 500, 50);

        //buttonPanel.setLayout(null);
        buttonPanel.setLayout(new GridLayout(0, 4, 8, 4));
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));;
        buttonPanel.setBounds(800, 800, 500, 500);



        frame.add(outputPanel);
        frame.add(buttonPanel);

        buttonPanel.add(reset);
        buttonPanel.add(undo);
        buttonPanel.add(zero);
        buttonPanel.add(one);
        buttonPanel.add(two);
        buttonPanel.add(three);
        buttonPanel.add(four);
        buttonPanel.add(five);
        buttonPanel.add(six);
        buttonPanel.add(seven);
        buttonPanel.add(eight);
        buttonPanel.add(nine);
        buttonPanel.add(plus);
        buttonPanel.add(minus);
        buttonPanel.add(multiply);
        buttonPanel.add(divide);
        buttonPanel.add(equals);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
            case "0":
                if (currentNum.length() > 0) {
                    // makes sure numbers don't start with 0 needs
                    // to be changed after decimals are added
                    currentNum += "0";
                    outputView.setText(currentNum);
                }
                break;
            case "1":
                currentNum += "1";
                outputView.setText(currentNum);
                break;
            case "2":
                currentNum += "2";
                outputView.setText(currentNum);
                break;
            case "3":
                currentNum += "3";
                outputView.setText(currentNum);
                break;
            case "4":
                currentNum += "4";
                outputView.setText(currentNum);
                break;
            case "5":
                currentNum += "5";
                outputView.setText(currentNum);
                break;
            case "6":
                currentNum += "6";
                outputView.setText(currentNum);
                break;
            case "7":
                currentNum += "7";
                outputView.setText(currentNum);
                break;
            case "8":
                currentNum += "8";
                outputView.setText(currentNum);
                break;
            case "9":
                currentNum += "9";
                outputView.setText(currentNum);
                break;
            case "CE":
                currentNum = "";
                finalNum = "";
                outputView.setText(currentNum);
                break;
            case "C":
                if (currentNum.length() > 0){
                    currentNum = currentNum.substring(0, currentNum.length() - 1);
                    outputView.setText(currentNum);
                }
                break;
            case "+":
                currentOperation = "+";
                finalNum = currentNum;
                currentNum = "";
                outputView.setText(currentNum);
                break;
            case "-":
                currentOperation = "-";
                finalNum = currentNum;
                currentNum = "";
                outputView.setText(currentNum);
                break;
            case "/":
                currentOperation = "/";
                finalNum = currentNum;
                currentNum = "";
                outputView.setText(currentNum);
                break;
            case "x":
                currentOperation = "*";
                finalNum = currentNum;
                currentNum = "";
                outputView.setText(currentNum);
                break;
            case "=":
                if (Objects.equals(finalNum, "")){
                    finalNum = "0";
                }
                switch (currentOperation){
                    case "+":
                        finalNum = "" + (Integer.parseInt(finalNum) + Integer.parseInt(currentNum));
                        currentNum = finalNum;
                        outputView.setText(currentNum);
                        break;
                    case "-":
                        finalNum = "" + (Integer.parseInt(finalNum) - Integer.parseInt(currentNum));
                        currentNum = finalNum;
                        outputView.setText(currentNum);
                        break;
                    case "*":
                        finalNum = "" + (Integer.parseInt(finalNum) * Integer.parseInt(currentNum));
                        currentNum = finalNum;
                        outputView.setText(currentNum);
                        break;
                    case "/":
                        finalNum = "" + (Integer.parseInt(finalNum) / Integer.parseInt(currentNum));
                        currentNum = finalNum;
                        outputView.setText(currentNum);
                        break;
                    default:
                        finalNum = currentNum;
                        outputView.setText(currentNum);
                        break;
                }
                currentOperation = "";
        }
    }
}
