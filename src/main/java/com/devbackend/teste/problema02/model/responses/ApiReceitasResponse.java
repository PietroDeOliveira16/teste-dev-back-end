package com.devbackend.teste.problema02.model.responses;

import com.devbackend.teste.problema02.model.Receitas;

import java.util.List;

public class ApiReceitasResponse {
    private String prato;
    private int receitasEncontradas;
    private List<Receitas> receitas;

    public ApiReceitasResponse(String prato, int receitasEncontradas, List<Receitas> receitas) {
        this.prato = prato;
        this.receitasEncontradas = receitasEncontradas;
        this.receitas = receitas;
    }

    public String getPrato() {
        return prato;
    }

    public void setPrato(String prato) {
        this.prato = prato;
    }

    public int getReceitasEncontradas() {
        return receitasEncontradas;
    }

    public void setReceitasEncontradas(int receitasEncontradas) {
        this.receitasEncontradas = receitasEncontradas;
    }

    public List<Receitas> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receitas> receitas) {
        this.receitas = receitas;
    }
}
