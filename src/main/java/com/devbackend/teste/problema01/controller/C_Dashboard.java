package com.devbackend.teste.problema01.controller;

import com.devbackend.teste.problema01.service.S_Dashboard;
import com.devbackend.teste.problema01.model.M_Ticket;
import com.devbackend.teste.problema01.model.responses.ApiDashboardResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/dashboard")
public class C_Dashboard {
    private final S_Dashboard s_dashboard;

    public C_Dashboard(S_Dashboard s_dashboard) {
        this.s_dashboard = s_dashboard;
    }

    @GetMapping("/{mes}-{ano}")
    public ApiDashboardResponse getTickets(@PathVariable("mes") String mes, @PathVariable("ano") String ano){
        return s_dashboard.getTickets(mes, ano);
    }

    @GetMapping("/criarticket/{titulo}-{cod_cliente}-{cod_modulo}")
    public M_Ticket postCriarTicket(@PathVariable("titulo") String titulo, @PathVariable("cod_cliente") Long codCliente, @PathVariable("cod_modulo") Long codModulo){
        return s_dashboard.criarTicket(titulo, codCliente, codModulo);
    }
}
