/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal_estructuras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.util.List;

public class LaberintoControlador {
    private LaberintoModelo modelo;
    private LaberintoVista vista;

    public LaberintoControlador(LaberintoModelo modelo, LaberintoVista vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.addCrearButtonListener(new CrearButtonListener());
        this.vista.addRecursivoButtonListener(new RecursivoButtonListener());
        this.vista.addMemoizacionButtonListener(new MemoizacionButtonListener());
        this.vista.addBfsButtonListener(new BfsButtonListener());
        this.vista.addDfsButtonListener(new DfsButtonListener());
    }

    class CrearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int filas = vista.getFilas();
            int columnas = vista.getColumnas();
            modelo.configurarLaberinto(filas, columnas);

            JButton[][] buttons = new JButton[filas][columnas];
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    buttons[i][j] = new JButton("0");
                    final int x = i;
                    final int y = j;
                    buttons[i][j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            modelo.configurarCelda(x, y, modelo.getLaberinto()[x][y] == '1');
                            buttons[x][y].setText(modelo.getLaberinto()[x][y] == '1' ? "1" : "0");
                        }
                    });
                }
            }
            vista.setGridPanel(buttons);
        }
    }

    class RecursivoButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            modelo.configurarPuntos(vista.getInicio(), vista.getFin());
            List<Punto> camino = modelo.recursivo();
            modelo.mostrarCamino(camino);
            actualizarVista();
        }
    }

    class MemoizacionButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            modelo.configurarPuntos(vista.getInicio(), vista.getFin());
            List<Punto> camino = modelo.memoizacion();
            modelo.mostrarCamino(camino);
            actualizarVista();
        }
    }

    class BfsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            modelo.configurarPuntos(vista.getInicio(), vista.getFin());
            List<Punto> camino = modelo.bfs();
            modelo.mostrarCamino(camino);
            actualizarVista();
        }
    }

    class DfsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            modelo.configurarPuntos(vista.getInicio(), vista.getFin());
            List<Punto> camino = modelo.dfs();
            modelo.mostrarCamino(camino);
            actualizarVista();
        }
    }

    private void actualizarVista() {
        JButton[][] buttons = new JButton[modelo.getLaberinto().length][modelo.getLaberinto()[0].length];
        for (int i = 0; i < modelo.getLaberinto().length; i++) {
            for (int j = 0; j < modelo.getLaberinto()[i].length; j++) {
                buttons[i][j] = new JButton(Character.toString(modelo.getLaberinto()[i][j]));
            }
        }
        vista.setGridPanel(buttons);
    }
}
