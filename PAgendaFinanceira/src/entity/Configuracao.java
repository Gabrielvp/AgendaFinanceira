/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Homologação
 */
public class Configuracao {

    private EnumDiaSemana dia;
    private Date HoraInicial;
    private Date HoraFinal;
    private int intervalo;
    private Date almocoInicio;
    private Date almocoFim;

    public EnumDiaSemana getDia() {
        return dia;
    }

    public void setDia(EnumDiaSemana dia) {
        this.dia = dia;
    }

    public Date getHoraInicial() {
        return HoraInicial;
    }

    public void setHoraInicial(Date HoraInicial) {
        this.HoraInicial = HoraInicial;
    }

    public Date getHoraFinal() {
        return HoraFinal;
    }

    public void setHoraFinal(Date HoraFinal) {
        this.HoraFinal = HoraFinal;
    }

    public int getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }

    public Date getAlmocoInicio() {
        return almocoInicio;
    }

    public void setAlmocoInicio(Date almocoInicio) {
        this.almocoInicio = almocoInicio;
    }

    public Date getAlmocoFim() {
        return almocoFim;
    }

    public void setAlmocoFim(Date almocoFim) {
        this.almocoFim = almocoFim;
    }

}
