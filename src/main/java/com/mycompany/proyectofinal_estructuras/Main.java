/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectofinal_estructuras;

/**
 *
 * @author Andrew
 */
public class Main {

    public static void main(String[] args) {
        LaberintoModelo modelo = new LaberintoModelo();
        LaberintoVista vista = new LaberintoVista();
        new LaberintoControlador(modelo, vista);

        vista.setVisible(true);
    }
}
