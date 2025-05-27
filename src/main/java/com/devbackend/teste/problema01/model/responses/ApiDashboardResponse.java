package com.devbackend.teste.problema01.model.responses;

import com.devbackend.teste.problema01.model.dadosDashboard.DashboardDadosPorCliente;
import com.devbackend.teste.problema01.model.dadosDashboard.DashboardDadosPorModulo;

import java.util.List;

public class ApiDashboardResponse {
    private List<DashboardDadosPorCliente> dadosPorClientes;
    private List<DashboardDadosPorModulo> dadosPorModulos;

    public ApiDashboardResponse(List<DashboardDadosPorCliente> dadosPorClientes, List<DashboardDadosPorModulo> dadosPorModulos) {
        this.dadosPorClientes = dadosPorClientes;
        this.dadosPorModulos = dadosPorModulos;
    }

    public List<DashboardDadosPorCliente> getDadosPorClientes() {
        return dadosPorClientes;
    }

    public void setDadosPorClientes(List<DashboardDadosPorCliente> dadosPorClientes) {
        this.dadosPorClientes = dadosPorClientes;
    }

    public List<DashboardDadosPorModulo> getDadosPorModulos() {
        return dadosPorModulos;
    }

    public void setDadosPorModulos(List<DashboardDadosPorModulo> dadosPorModulos) {
        this.dadosPorModulos = dadosPorModulos;
    }
}
