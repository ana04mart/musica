package com.tech4me.musica.service;

import java.util.List;
import java.util.Optional;

import com.tech4me.musica.shared.MusicaDTO;

public interface MusicaService {
    
    List<MusicaDTO> obterTodos();
    
    Optional<MusicaDTO> obterPorId(String idMusica);

    MusicaDTO adicionar(MusicaDTO musicaDto);

    MusicaDTO atualizar(String idMusica, MusicaDTO musicaDto);

    void deletar(String idMusica);
}
