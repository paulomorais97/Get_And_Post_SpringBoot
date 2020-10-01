package com.servico.global;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




//Com o cross a classe aceita reposições de qualquer origem.
@CrossOrigin("*")
@RestController
public class Controller {
	
	@Autowired
	private ServicoRepository repository;
	
	
	@GetMapping("/servicos")
	public List<ServicoModel> pegarTodos(){
		return repository.findAll();
	}
	
	//findById() =  busca por ID
	@GetMapping("/{id}") 
	public ResponseEntity<ServicoModel> GetById(@PathVariable long id){//quando for inserido um busca por ID ele pode trazer tanto
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))						//A RESPOSTA DO OBJETO, UM OKAY POR EXEMPLO
				.orElse(ResponseEntity.notFound().build());					// OU ERRO QUANDO UM OBJETO NÃO EXISTA OU AJA ALGUM ERRO	
		 
	}
	
	
	
	
	@PostMapping("/servicos")
	public ServicoModel criar(@RequestBody ServicoModel model) {
		repository.save(model);
		return model;
	}
	
	
	
}
