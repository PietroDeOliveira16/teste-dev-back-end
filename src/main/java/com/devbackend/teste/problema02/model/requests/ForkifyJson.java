package com.devbackend.teste.problema02.model.requests;

import com.devbackend.teste.problema02.model.Receitas;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ForkifyJson {
    @JsonProperty("count")
    private int count;
    @JsonProperty("recipes")
    private List<Receitas> recipes;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Receitas> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Receitas> recipes) {
        this.recipes = recipes;
    }
}
