package com.exemple.hacktools.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.hacktools.model.modelQuestionario;
import com.exemple.hacktools.model.modelResposta;
import com.exemple.hacktools.repository.repositoryResposta;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/respostas")
public class controllerResposta {

	@Autowired
	private repositoryResposta repository;
	
	@GetMapping("/buscarRespostas")
	public List<modelResposta> buscarTodos(){
		return repository.findAll();
	}
	//Metodo para criar um novo questionario
	@PostMapping
	public ResponseEntity<modelResposta> post(@RequestBody modelResposta Resposta) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(Resposta));
	}
	
	//Metodo para atualizar dados em uma possivel atualização
	@PutMapping
	public ResponseEntity<modelResposta> put (@RequestBody modelResposta Resposta){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(Resposta));
	}
	
	//Metodo para deletar algum questionario pelo ID
	@DeleteMapping("/delete.{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}