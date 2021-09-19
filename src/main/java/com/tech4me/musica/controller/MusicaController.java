package com.tech4me.musica.controller;

import java.util.List;
import java.util.Optional;

import com.tech4me.musica.model.Musica;
import com.tech4me.musica.service.MusicaServiceImpl;
import com.tech4me.musica.shared.MusicaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/musicas")

public class MusicaController {
   

    @Autowired
    MusicaServiceImpl servicoMusica;

    @GetMapping
    public ResponseEntity<List<MusicaDTO>> obterTodos(){
        return new ResponseEntity<>(servicoMusica.obterTodos(), HttpStatus.OK);
    } 

    @GetMapping ("/{id}")
    public ResponseEntity<Optional<MusicaDTO>> obterPorId(@PathVariable String idMusica){
        Optional<Musica> musicaOptional = servicoMusica.obterPorId(idMusica);
        
        return new ResponseEntity<> (musicaOptional, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<MusicaDTO> adicionar(@RequestBody MusicaDTO musicaDto) {
        MusicaDTO musicaCadastrada = servicoMusica.adicionar(musicaDto);

        return new ResponseEntity<>(musicaCadastrada, HttpStatus.CREATED);
    }

    @PutMapping  ("/{id}")
    public ResponseEntity<MusicaDTO> atualizar(@PathVariable String id, @RequestBody MusicaDTO musicaDto) {
        MusicaDTO musicaAtualizada = servicoMusica.atualizar(id, musicaDto);

        return new ResponseEntity<>(musicaAtualizada, HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deletar(@PathVariable String id) {
        servicoMusica.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
