package com.tech4me.musica.shared;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MusicaDTO {
    
    private String id;

    @NotBlank(message = "O título deve possuir caracteres não brancos!")
    @NotEmpty(message = "O título deve ser preenchido!")
    @Size(min = 3, message = "O título deve ter, no mínimo, 3 caracteres!")
    private String titulo;

    @NotBlank(message = "O nome do artista deve possuir caracteres não brancos!")
    @NotEmpty(message = "O nome do artista deve ser preenchido!")
    @Size(min = 3, message = "O nome do artista deve ter, no mínimo, 7 caracteres!")
    private String artista;

    @NotBlank(message = "O nome do álbum deve possuir caracteres não brancos!")
    @NotEmpty(message = "O nome do álbum deve ser preenchido!")
    @Size(min = 3, message = "O nome do álbum deve ter, no mínimo, 4 caracteres!")
    private String album;

    @NotBlank(message = "O ano do lançamento deve possuir caracteres não brancos!")
    @NotEmpty(message = "O ano do lançamento deve ser preenchido!")
    private Integer anoLancamento;

    @NotBlank(message = "O nome deve possuir caracteres não brancos")
    @NotEmpty(message = "O nome deve ser preenchido")
    @Size(min = 3, message = "O nome deve ter, no mínimo, 5 caracteres")
    private String compositor;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

}
