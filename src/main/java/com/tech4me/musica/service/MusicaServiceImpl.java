package com.tech4me.musica.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tech4me.musica.model.Musica;
import com.tech4me.musica.repository.MusicaRepository;
import com.tech4me.musica.shared.MusicaDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class MusicaServiceImpl implements MusicaService {

    @Autowired
    MusicaRepository repositorioMusica;

    @Override
    public List<MusicaDTO> obterTodos() {
       
        List<Musica> musicas = repositorioMusica.findAll();

        ModelMapper mapper = new ModelMapper();

        return musicas.stream()
        .map(musica -> mapper.map(musica, MusicaDTO.class))
        .collect(Collectors.toList());
    }

    @Override
    public Optional<Musica> obterPorId(String idMusica) {
       
        Optional<Musica> optionalMusica = repositorioMusica.findById(idMusica);

        if(optionalMusica.isEmpty()) {
            throw new InputMismatchException("Não foi encontrada a música com o id: " + idMusica);
        }

        Musica musicaDto = new ModelMapper().map(optionalMusica.get(), Musica.class);

        return Optional.of(musicaDto);
    }

    @Override
    public MusicaDTO adicionar(MusicaDTO musicaDto) {
        
        ModelMapper mapper = new ModelMapper();

        Musica musica = mapper.map(musicaDto, Musica.class);

        musica.setId(null);

        musica = repositorioMusica.save(musica);

        return mapper.map(musica, MusicaDTO.class);
    }

    @Override
    public MusicaDTO atualizar(String idMusica, MusicaDTO musicaDto) {
       
        musicaDto.setId(idMusica);

        ModelMapper mapper = new ModelMapper();

        Musica musica = mapper.map(musicaDto, Musica.class);

        musica = repositorioMusica.save(musica);
        return mapper.map(musica, MusicaDTO.class);
    }

    @Override
    public void deletar(String idMusica) {
        
        repositorioMusica.deleteById(idMusica);
        
    }
    
}
