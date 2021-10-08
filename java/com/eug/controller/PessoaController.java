package com.eug.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.eug.exception.ResourceNotFoundException;
import com.eug.model.Pessoa;
import com.eug.repository.PessoaRepository;

import javassist.NotFoundException;

@CrossOrigin( origins = "http://localhost:4200")
@RequestMapping("/pcontroller/")
@RestController
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRep;
	
	
	//Listar
	@GetMapping("pessoas")
	public List<Pessoa> listar(){
		
		return this.pessoaRep.findAll();
	}
	
	//Buscar
	@GetMapping("/pessoas/{id}")
	public ResponseEntity<Pessoa> consultar(@PathVariable Long id){
		
		 Pessoa pessoa = pessoaRep.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Pessoa Não Encontrada " + id));
		
		return ResponseEntity.ok(pessoa);
		
	}
	
	//Inserir
	@PostMapping("/pessoas")
	public Pessoa inserir(@RequestBody Pessoa pessoa) {
		return pessoaRep.save(pessoa);
		
	}
	
	
	//Deletar
	@DeleteMapping("/pessoas/{id}")
	public ResponseEntity<Map<String,Boolean>> excluir(@PathVariable Long id){
		
		Pessoa pessoa = pessoaRep.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Pessoa Não Encontrada " + id));
		
		pessoaRep.delete(pessoa);
		
		Map<String, Boolean> resposta = new HashMap<>();
		resposta.put("Pessoa excluída", Boolean.TRUE);
		
		return ResponseEntity.ok(resposta);
	}
	
	//Alterar Produtos
	@PutMapping("/pessoas/{id}")
	public ResponseEntity<Pessoa> alterar(@PathVariable Long id, @RequestBody Pessoa pessoa){
		
		Pessoa pes = pessoaRep.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Produto Não Encontrado! " + id));
				
		pes.setId(pessoa.getId());
		pes.setNome(pessoa.getNome());
		pes.setCpf(pessoa.getCpf());
		pes.setPrimeiraDose(pessoa.getPrimeiraDose());
		pes.setSegundaDose(pessoa.getSegundaDose());
		pes.setVacinou(pessoa.getVacinou());
		
		Pessoa atualizado = pessoaRep.save(pes);
		return ResponseEntity.ok(atualizado);
		
	}
	
}
