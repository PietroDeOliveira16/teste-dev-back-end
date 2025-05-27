package com.devbackend.teste.problema01.model.dadosDashboard;

import com.devbackend.teste.problema01.model.M_Ticket;

import java.util.List;

public class DashboardDadosPorCliente extends DashboardDadosGeral{
    private String cliente;

    public DashboardDadosPorCliente(String cliente, Long quantidadeTickets, List<M_Ticket> tickets) {
        this.cliente = cliente;
        super.setQuantidadeTickets(quantidadeTickets);
        super.setTickets(tickets);
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
