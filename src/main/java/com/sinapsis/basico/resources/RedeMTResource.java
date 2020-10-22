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

import com.sinapsis.basico.domain.RedeMT;
import com.sinapsis.basico.dto.RedeMTDTO;
import com.sinapsis.basico.services.RedeMTService;

@RestController
@RequestMapping(value = "/redes")
public class RedeMTResource {
	
	@Autowired
	private RedeMTService redeService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RedeMT insert(@RequestBody @Valid RedeMTDTO objDto) {
		RedeMT obj = redeService.fromDto(objDto);
		obj = redeService.insert(obj);
		return obj;	
	}
	
	@GetMapping("{id}")
	public RedeMT findId(@PathVariable Integer id) {
		RedeMT obj = redeService.findId(id); 
		return obj;
	}
	
	@GetMapping
	public List<RedeMT> findRede(
			@RequestParam(value = "nome", required = false, defaultValue = "") String nome){
		List<RedeMT> obj = redeService.findRede(nome);
		return obj;
	}
	
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		findId(id);
		redeService.delete(id);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id, @RequestBody @Valid RedeMT obj) {
		findId(id);
		obj.setId(id);
		obj = redeService.update(id, obj);
	}
	
	@GetMapping("/page")
	public Page<RedeMT> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage){
			Page<RedeMT> objRede = redeService.findPage(page, linesPerPage);
			return objRede;
		
	}

}
