/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscaminasjunio;

/**
 * @author edwar
 */
public class Estadisticas {

    private int jugadas, ganadas, perdidas, minas_a_favor, minas_en_contra;

    public Estadisticas() {  
        this.jugadas = 0;
        this.ganadas = 0;
        this.perdidas = 0;
        this.minas_a_favor = 0;
        this.minas_en_contra = 0;
    }

    public void statsEdit(boolean gana, int minasEncontradas, int minasRival) {
        if (gana == true) {
            this.ganadas++;
            this.minas_a_favor += minasEncontradas;
            this.minas_en_contra += minasRival;
        } else {
            this.perdidas++;
            this.minas_a_favor += minasEncontradas;
            this.minas_en_contra += minasRival;
        }
        this.jugadas++;
    }

    public Estadisticas(int ganadas, int perdidas, int jugadas, int minasFavor, int minasContra) {  // Contructor para el cara a cara
        this.ganadas = ganadas;
        this.perdidas = perdidas;
        this.jugadas = jugadas;
        this.minas_a_favor = minasFavor;
        this.minas_en_contra = minasContra;
    }

    public int getJugadas() {
        return this.jugadas;
    }

    public int getGanadas() {
        return this.ganadas;
    }

    public int getPerdidas() {
        return this.perdidas;
    }

    public int getMinasContra() {
        return this.minas_en_contra;
    }

    public int getMinasFavor() {
        return this.minas_a_favor;
    }

    public void setMinasContra(int minasContra) {
        this.minas_en_contra = minasContra;
    }

    public void setMinasFavor(int minasFavor) {
        this.minas_en_contra = minasFavor;
    }

    public String printStats() {
        return ("Partidas jugadas: " + this.getJugadas() + "\n"
                + "Partidas ganadas: " + this.getGanadas() + "\n"
                + "Partidas perdidas: " + this.getPerdidas() + "\n"
                + "Minas a favor: " + this.getMinasFavor() + "\n"
                + "Minas en contra: " + this.getMinasContra() + "\n");
    }

}
