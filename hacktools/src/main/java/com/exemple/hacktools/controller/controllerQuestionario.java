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
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.exemple.hacktools.model.modelQuestionario;
import com.exemple.hacktools.repository.repositoryQuestionario;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/questionario")
public class controllerQuestionario {

	public void addViewControllers(ViewControllerRegistry index) {
		index.addViewController("/").setViewName("forward:/index.html");
	}
	
	@Autowired
	private repositoryQuestionario repository;
	
	//Metodo para consultar os dados no banco de dados endereço( http://localhost:8080/questionario )
	@GetMapping("/buscarTodos")
	public List<modelQuestionario> buscarTodos(){
		return repository.findAll();
	}
	
	//Metodo para criar um novo questionario
	@PostMapping
	public ResponseEntity<modelQuestionario> post(@RequestBody modelQuestionario Questionario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(Questionario));
	}
	
	//Metodo para atualizar dados em uma possivel atualização
	@PutMapping
	public ResponseEntity<modelQuestionario> put (@RequestBody modelQuestionario Questionario){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(Questionario));
	}
	
	//Metodo para deletar algum questionario pelo ID
	@DeleteMapping("/delete.{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
