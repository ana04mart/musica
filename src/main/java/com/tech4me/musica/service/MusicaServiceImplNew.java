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

public class MusicaServiceImplNew implements MusicaService{

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
    public Optional<MusicaDTO> obterPorId(String idMusica) {
        Optional<Musica> optional = repositorioMusica.findById(idMusica);

        if(optional.isEmpty()){
            throw new InputMismatchException("Não foi encontrada a música com este id: " + idMusica);
        }
        MusicaDTO musicaDto = new ModelMapper().map(optional.get(), MusicaDTO.class);

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

      Musica musica = new ModelMapper().map(musicaDto, Musica.class);

      return musicaDto;
    }

    @Override
    public void deletar(String idMusica) {
      repositorioMusica.deleteById(idMusica);
        
    }
    
}
