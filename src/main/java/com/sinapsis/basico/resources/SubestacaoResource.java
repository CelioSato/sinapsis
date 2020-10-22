package com.sinapsis.basico.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sinapsis.basico.domain.Subestacao;
import com.sinapsis.basico.services.SubestacaoService;

@RestController
@RequestMapping(value="/subestacoes")
public class SubestacaoResource {
	
	@Autowired
	SubestacaoService subEstacaoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Subestacao insert(@RequestBody @Valid Subestacao obj) {
		obj = subEstacaoService.insert(obj);
		return obj;
	}
	
	@GetMapping("{id}")
	public Subestacao findId(@PathVariable Integer id) {
		Subestacao obj = subEstacaoService.findId(id);
		return obj;
	}
	
	@GetMapping()
	public List<Subestacao> findAll(){
		List<Subestacao> obj = subEstacaoService.findAll();
		return obj;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		findId(id);
		subEstacaoService.delete(id);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id, @RequestBody @Valid Subestacao obj) {
		findId(id);
		obj.setId(id);
		obj = subEstacaoService.update(id, obj);
	}
	
	@GetMapping("/page")
	public Page<Subestacao> findPage(
			@RequestParam(value = "page", defaultValue = "0")Integer page,
			@RequestParam(value = "linesPerpage", defaultValue = "12")Integer linesPerPage){
			Page<Subestacao> objSub = subEstacaoService.findPage(page, linesPerPage);
			return objSub;
	}
}
