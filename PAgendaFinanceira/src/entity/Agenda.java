package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel1
 */
public class Agenda {

    private List<DataHora> agendamento;

    public List<DataHora> getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(List<DataHora> agendamento) {
        this.agendamento = agendamento;
    }

    public Agenda() {

        agendamento = new ArrayList<>();

    }
    
     public void dataHora(DataHora dtHora) {
        agendamento.add(dtHora);
    }

}
