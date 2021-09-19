package com.tech4me.musica.service;

import java.util.List;
import java.util.Optional;

import com.tech4me.musica.model.Musica;
import com.tech4me.musica.shared.MusicaDTO;



public interface MusicaService {
    
    List<MusicaDTO> obterTodos();
    
    Optional<Musica> obterPorId(String idMusica);

    MusicaDTO adicionar(MusicaDTO musica);

    MusicaDTO atualizar(String idMusica, MusicaDTO musica);

    void deletar(String idMusica);
}
