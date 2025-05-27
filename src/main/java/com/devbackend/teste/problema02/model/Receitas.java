package com.devbackend.teste.problema02.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Receitas {
    @JsonProperty("publisher")
    private String autor;
    @JsonProperty("title")
    private String titulo;
    @JsonProperty("source_url")
    private String urlConteudo;
    @JsonProperty("recipe_id")
    private String idReceita;
    @JsonProperty("image_url")
    private String urlImagem;
    @JsonProperty("social_rank")
    private int rankSocial;
    @JsonProperty("publisher_url")
    private String urlAutor;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrlConteudo() {
        return urlConteudo;
    }

    public void setUrlConteudo(String urlConteudo) {
        this.urlConteudo = urlConteudo;
    }

    public String getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(String idReceita) {
        this.idReceita = idReceita;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public int getRankSocial() {
        return rankSocial;
    }

    public void setRankSocial(int rankSocial) {
        this.rankSocial = rankSocial;
    }

    public String getUrlAutor() {
        return urlAutor;
    }

    public void setUrlAutor(String urlAutor) {
        this.urlAutor = urlAutor;
    }
}
