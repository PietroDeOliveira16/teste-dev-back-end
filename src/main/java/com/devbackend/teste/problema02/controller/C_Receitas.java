package com.devbackend.teste.problema02.controller;

import com.devbackend.teste.problema02.service.S_Receitas;
import com.devbackend.teste.problema02.model.responses.ApiReceitasResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/receitas")
public class C_Receitas {
    private final S_Receitas s_receitas;

    public C_Receitas(S_Receitas s_receitas) {
        this.s_receitas = s_receitas;
    }

    @GetMapping("/{prato}")
    public ApiReceitasResponse getReceitasPrato(@PathVariable("prato") String prato){
        return s_receitas.getReceitasPrato(prato);
    }
}
