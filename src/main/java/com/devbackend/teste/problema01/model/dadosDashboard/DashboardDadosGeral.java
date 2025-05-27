package com.devbackend.teste.problema01.model.dadosDashboard;

import com.devbackend.teste.problema01.model.M_Ticket;

import java.util.List;

public abstract class DashboardDadosGeral {
    private Long quantidadeTickets;
    private List<M_Ticket> tickets;

    public Long getQuantidadeTickets() {
        return quantidadeTickets;
    }

    public void setQuantidadeTickets(Long quantidadeTickets) {
        this.quantidadeTickets = quantidadeTickets;
    }

    public List<M_Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<M_Ticket> tickets) {
        this.tickets = tickets;
    }
}
