package com.devbackend.teste.problema01.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ticket", schema = "teste")
public class M_Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "cod_cliente")
    private M_Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "cod_modulo")
    private M_Modulo modulo;
    private LocalDate dataAbertura = LocalDate.now();
    private LocalDate dataEncerramento;

    public M_Ticket() {}

    public M_Ticket(String titulo, M_Cliente cliente, M_Modulo modulo) {
        this.titulo = titulo;
        this.cliente = cliente;
        this.modulo = modulo;
        this.dataEncerramento = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public M_Cliente getCliente() {
        return cliente;
    }

    public void setCliente(M_Cliente cliente) {
        this.cliente = cliente;
    }

    public M_Modulo getModulo() {
        return modulo;
    }

    public void setModulo(M_Modulo modulo) {
        this.modulo = modulo;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(LocalDate dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }
}
