package com.devbackend.teste.problema01.service;

import com.devbackend.teste.problema01.model.M_Cliente;
import com.devbackend.teste.problema01.model.M_Modulo;
import com.devbackend.teste.problema01.model.M_Ticket;
import com.devbackend.teste.problema01.model.responses.ApiDashboardResponse;
import com.devbackend.teste.problema01.model.dadosDashboard.DashboardDadosPorCliente;
import com.devbackend.teste.problema01.model.dadosDashboard.DashboardDadosPorModulo;
import com.devbackend.teste.problema01.repository.R_Cliente;
import com.devbackend.teste.problema01.repository.R_Modulo;
import com.devbackend.teste.problema01.repository.R_Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class S_Dashboard {
    @Autowired
    private R_Ticket r_ticket;
    @Autowired
    private R_Cliente r_cliente;
    @Autowired
    private R_Modulo r_modulo;

    /**
     * Captura todos os tickets do mês e ano especificados e agrupa estes tickets baseado em cada Cliente e Módulo.
     * @param mes String dos digitos do mês (ex.: 03)
     * @param ano String dos digitos do ano (ex.: 2021)
     * @return ApiDashboardResponse contendo uma lista de todos os clientes e seus tickets e uma lista de todos os módulos e seus tickets
     */
    public ApiDashboardResponse getTickets(String mes, String ano) {
        // Recupera todos os tickets do mes e ano especificado e todos os clientes e modulos
        List<M_Ticket> tickets = r_ticket.findAllTicketsFromMonthAndYear(mes, ano);
        List<M_Cliente> clientes = r_cliente.findAll(Sort.by("id").ascending());
        List<M_Modulo> modulos = r_modulo.findAll(Sort.by("id").ascending());

        List<DashboardDadosPorCliente> dadosClientes = new ArrayList<>();
        List<DashboardDadosPorModulo> dadosModulos = new ArrayList<>();

        // Cria uma coleção que agrupa os tickets para cada Cliente
        Map<M_Cliente, List<M_Ticket>> ticketsPorCliente = tickets.stream()
                .collect(Collectors.groupingBy(M_Ticket::getCliente));

        // Percorre cada Cliente com sua lista de tickets, captura a quantidade de tickets registrados para aquele cliente e salva na lista de dados
        for(Map.Entry<M_Cliente, List<M_Ticket>> entry : ticketsPorCliente.entrySet()){
            M_Cliente cliente = entry.getKey();
            List<M_Ticket> ticketsDoCliente = entry.getValue();
            Long quantidadeTickets = (long) ticketsDoCliente.size();
            dadosClientes.add(new DashboardDadosPorCliente(cliente.getNome(), quantidadeTickets, ticketsDoCliente));
        }

        // Cria uma coleção que agrupa os tickets para cada tipo de Módulo
        Map<M_Modulo, List<M_Ticket>> ticketsPorModulo = tickets.stream()
                .collect(Collectors.groupingBy(M_Ticket::getModulo));

        // Percorre cada Módulo com sua lista de tickets, captura a quantidade de tickets registrados para aquele módulo e salva na lista de dados
        for(Map.Entry<M_Modulo, List<M_Ticket>> entry : ticketsPorModulo.entrySet()){
            M_Modulo modulo = entry.getKey();
            List<M_Ticket> ticketsDoModulo = entry.getValue();
            Long quantidadeTickets = (long) ticketsDoModulo.size();
            dadosModulos.add(new DashboardDadosPorModulo(modulo.getNome(), quantidadeTickets, ticketsDoModulo));
        }

        // Retorna as listas de dados agrupados
        return new ApiDashboardResponse(dadosClientes, dadosModulos);
    }

    /**
     * Gera um novo ticket e salva no banco de dados. A data de abertura do ticket é determinada como o momento em que o ticket foi criado e a data de encerramento fica null.
     * @param titulo String do titulo do ticket
     * @param codCliente Long correspondente ao id do Cliente
     * @param codModulo Long correspondente ao id do Módulo
     * @return O ticket que acabou de ser gerado pelos parâmetros.
     */
    public M_Ticket criarTicket(String titulo, Long codCliente, Long codModulo) {
        // Garante que nenhum informação está faltando ou incorreta
        if (!titulo.isBlank() && codCliente > 0 && codModulo > 0) {

            // Gera um espaço em branco onde houver o caractere "_" para separar palavras do titulo
            titulo = titulo.replaceAll("_", " ");

            try {
                // Tenta encontrar o usuario e o módulo especificados nos parâmetros
                Optional<M_Cliente> cliente = r_cliente.findById(codCliente);
                Optional<M_Modulo> modulo = r_modulo.findById(codModulo);

                // Valida se o cliente e o módulo não foram devidamente encontrados e/ou não existem
                if (cliente.isEmpty() || modulo.isEmpty()) {
                    System.out.println("Verifique se os codigos de identificação do cliente ou do módulo estão corretos");
                    return null;
                }

                // Salva o ticket no banco de dados e retorna o próprio ticket
                return r_ticket.save(new M_Ticket(titulo, cliente.get(), modulo.get()));
            } catch (DataAccessException e) {
                System.out.println("Erro ao salvar no banco de dados: \n" + e);
                return null;
            }
        }

        return null;
    }
}
