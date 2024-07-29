/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal_estructuras;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Andrew
 */
import java.awt.event.ActionListener;

public class LaberintoVista extends JFrame {
    private JTextField filasField, columnasField, inicioXField, inicioYField, finXField, finYField;
    private JPanel gridPanel;
    private JButton[][] buttons;
    private JButton crearButton, recursivoButton, memoizacionButton, bfsButton, dfsButton;

    public LaberintoVista() {
        setTitle("Laberinto - Ruta Óptima");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel(new GridLayout(2, 1));

        JPanel configPanel = new JPanel(new GridLayout(4, 2));
        configPanel.add(new JLabel("Filas:"));
        filasField = new JTextField("5");
        configPanel.add(filasField);
        configPanel.add(new JLabel("Columnas:"));
        columnasField = new JTextField("5");
        configPanel.add(columnasField);
        configPanel.add(new JLabel("Inicio (x, y):"));
        inicioXField = new JTextField("0");
        inicioYField = new JTextField("0");
        JPanel inicioPanel = new JPanel(new GridLayout(1, 2));
        inicioPanel.add(inicioXField);
        inicioPanel.add(inicioYField);
        configPanel.add(inicioPanel);
        configPanel.add(new JLabel("Fin (x, y):"));
        finXField = new JTextField("4");
        finYField = new JTextField("4");
        JPanel finPanel = new JPanel(new GridLayout(1, 2));
        finPanel.add(finXField);
        finPanel.add(finYField);
        configPanel.add(finPanel);
        controlPanel.add(configPanel);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 5));
        crearButton = new JButton("Crear Laberinto");
        buttonPanel.add(crearButton);

        recursivoButton = new JButton("Recursivo");
        buttonPanel.add(recursivoButton);

        memoizacionButton = new JButton("Memoización");
        buttonPanel.add(memoizacionButton);

        bfsButton = new JButton("BFS");
        buttonPanel.add(bfsButton);

        dfsButton = new JButton("DFS");
        buttonPanel.add(dfsButton);

        controlPanel.add(buttonPanel);
        add(controlPanel, BorderLayout.NORTH);

        gridPanel = new JPanel();
        add(gridPanel, BorderLayout.CENTER);
    }

    public int getFilas() {
        return Integer.parseInt(filasField.getText());
    }

    public int getColumnas() {
        return Integer.parseInt(columnasField.getText());
    }

    public Punto getInicio() {
        return new Punto(Integer.parseInt(inicioXField.getText()), Integer.parseInt(inicioYField.getText()));
    }

    public Punto getFin() {
        return new Punto(Integer.parseInt(finXField.getText()), Integer.parseInt(finYField.getText()));
    }

    public void setGridPanel(JButton[][] buttons) {
        this.buttons = buttons;
        gridPanel.removeAll();
        gridPanel.setLayout(new GridLayout(buttons.length, buttons[0].length));
        for (JButton[] row : buttons) {
            for (JButton button : row) {
                gridPanel.add(button);
            }
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    public void addCrearButtonListener(ActionListener listener) {
        crearButton.addActionListener(listener);
    }

    public void addRecursivoButtonListener(ActionListener listener) {
        recursivoButton.addActionListener(listener);
    }

    public void addMemoizacionButtonListener(ActionListener listener) {
        memoizacionButton.addActionListener(listener);
    }

    public void addBfsButtonListener(ActionListener listener) {
        bfsButton.addActionListener(listener);
    }

    public void addDfsButtonListener(ActionListener listener) {
        dfsButton.addActionListener(listener);
    }
}
