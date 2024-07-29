/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal_estructuras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Andrew
 */
public class LaberintoModelo {

  private char[][] laberinto;
    private Punto inicio;
    private Punto fin;

    public void configurarLaberinto(int filas, int columnas) {
        laberinto = new char[filas][columnas];
        for (int i = 0; i < filas; i++) {
            Arrays.fill(laberinto[i], '0');
        }
    }

    public void configurarCelda(int x, int y, boolean transitable) {
        laberinto[x][y] = transitable ? '0' : '1';
    }

    public void configurarPuntos(Punto inicio, Punto fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public char[][] getLaberinto() {
        return laberinto;
    }

    public Punto getInicio() {
        return inicio;
    }

    public Punto getFin() {
        return fin;
    }

    public void mostrarCamino(List<Punto> camino) {
        for (Punto p : camino) {
            laberinto[p.x][p.y] = '2'; // '2' para indicar el camino encontrado
        }
    }

    // Método Recursivo para encontrar el camino
    public List<Punto> recursivo() {
        List<Punto> camino = new ArrayList<>();
        boolean[][] visitado = new boolean[laberinto.length][laberinto[0].length];
        if (dfsRecursivo(inicio.x, inicio.y, visitado, camino)) {
            return camino;
        } else {
            return new ArrayList<>(); // Camino no encontrado
        }
    }

    private boolean dfsRecursivo(int x, int y, boolean[][] visitado, List<Punto> camino) {
        if (x < 0 || x >= laberinto.length || y < 0 || y >= laberinto[0].length || laberinto[x][y] == '1' || visitado[x][y]) {
            return false;
        }

        camino.add(new Punto(x, y));
        visitado[x][y] = true;

        if (x == fin.x && y == fin.y) {
            return true;
        }

        if (dfsRecursivo(x + 1, y, visitado, camino) || 
            dfsRecursivo(x - 1, y, visitado, camino) || 
            dfsRecursivo(x, y + 1, visitado, camino) || 
            dfsRecursivo(x, y - 1, visitado, camino)) {
            return true;
        }

        camino.remove(camino.size() - 1); // Backtrack
        return false;
    }

    // Método de Memoización para encontrar el camino
    public List<Punto> memoizacion() {
        List<Punto> camino = new ArrayList<>();
        Map<Punto, Boolean> memo = new HashMap<>();
        if (memoizacionHelper(inicio.x, inicio.y, memo, camino)) {
            return camino;
        } else {
            return new ArrayList<>(); // Camino no encontrado
        }
    }

    private boolean memoizacionHelper(int x, int y, Map<Punto, Boolean> memo, List<Punto> camino) {
        if (x < 0 || x >= laberinto.length || y < 0 || y >= laberinto[0].length || laberinto[x][y] == '1' || memo.getOrDefault(new Punto(x, y), false)) {
            return false;
        }

        camino.add(new Punto(x, y));
        memo.put(new Punto(x, y), true);

        if (x == fin.x && y == fin.y) {
            return true;
        }

        if (memoizacionHelper(x + 1, y, memo, camino) || 
            memoizacionHelper(x - 1, y, memo, camino) || 
            memoizacionHelper(x, y + 1, memo, camino) || 
            memoizacionHelper(x, y - 1, memo, camino)) {
            return true;
        }

        camino.remove(camino.size() - 1); // Backtrack
        return false;
    }

    // Método BFS para encontrar el camino
    public List<Punto> bfs() {
        List<Punto> camino = new ArrayList<>();
        boolean[][] visitado = new boolean[laberinto.length][laberinto[0].length];
        Queue<Punto> cola = new LinkedList<>();
        Map<Punto, Punto> padres = new HashMap<>();

        cola.add(inicio);
        visitado[inicio.x][inicio.y] = true;

        while (!cola.isEmpty()) {
            Punto actual = cola.poll();
            if (actual.equals(fin)) {
                return reconstruirCamino(padres);
            }

            for (Punto vecino : obtenerVecinos(actual)) {
                if (!visitado[vecino.x][vecino.y] && laberinto[vecino.x][vecino.y] == '0') {
                    visitado[vecino.x][vecino.y] = true;
                    cola.add(vecino);
                    padres.put(vecino, actual);
                }
            }
        }

        return new ArrayList<>(); // Camino no encontrado
    }

    private List<Punto> obtenerVecinos(Punto p) {
        List<Punto> vecinos = new ArrayList<>();
        if (p.x > 0) vecinos.add(new Punto(p.x - 1, p.y));
        if (p.x < laberinto.length - 1) vecinos.add(new Punto(p.x + 1, p.y));
        if (p.y > 0) vecinos.add(new Punto(p.x, p.y - 1));
        if (p.y < laberinto[0].length - 1) vecinos.add(new Punto(p.x, p.y + 1));
        return vecinos;
    }

    private List<Punto> reconstruirCamino(Map<Punto, Punto> padres) {
        List<Punto> camino = new ArrayList<>();
        Punto actual = fin;
        while (actual != null) {
            camino.add(actual);
            actual = padres.get(actual);
        }
        Collections.reverse(camino);
        return camino;
    }

    // Método DFS para encontrar el camino
    public List<Punto> dfs() {
        List<Punto> camino = new ArrayList<>();
        boolean[][] visitado = new boolean[laberinto.length][laberinto[0].length];
        Stack<Punto> pila = new Stack<>();
        Map<Punto, Punto> padres = new HashMap<>();

        pila.add(inicio);
        visitado[inicio.x][inicio.y] = true;

        while (!pila.isEmpty()) {
            Punto actual = pila.pop();
            if (actual.equals(fin)) {
                return reconstruirCamino(padres);
            }

            for (Punto vecino : obtenerVecinos(actual)) {
                if (!visitado[vecino.x][vecino.y] && laberinto[vecino.x][vecino.y] == '0') {
                    visitado[vecino.x][vecino.y] = true;
                    pila.add(vecino);
                    padres.put(vecino, actual);
                }
            }
        }

        return new ArrayList<>(); // Camino no encontrado
    }
}
