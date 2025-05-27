package com.devbackend.teste.problema01.model.dadosDashboard;

import com.devbackend.teste.problema01.model.M_Ticket;

import java.util.List;

public class DashboardDadosPorModulo extends DashboardDadosGeral{
    private String modulo;

    public DashboardDadosPorModulo(String modulo, Long quantidadeTickets, List<M_Ticket> tickets) {
        this.modulo = modulo;
        super.setQuantidadeTickets(quantidadeTickets);
        super.setTickets(tickets);
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }
}
