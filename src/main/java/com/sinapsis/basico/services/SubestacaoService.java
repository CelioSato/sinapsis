package com.sinapsis.basico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sinapsis.basico.domain.Subestacao;
import com.sinapsis.basico.repositories.SubestacaoRepository;

@Service
public class SubestacaoService {
	
	@Autowired
	SubestacaoRepository subEstacaoRepository;

	public Subestacao insert(Subestacao obj) {
		obj.setId(null);
		obj = subEstacaoRepository.save(obj);
		return obj;
	}

	public Subestacao findId(Integer id) {
		Optional<Subestacao> obj = subEstacaoRepository.findById(id);
		return obj.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Subestacao não encontrada") );
	}
	
	public List<Subestacao> findAll() {
		List<Subestacao> obj = subEstacaoRepository.findAll();
		return obj;
	}

	public void delete(Integer id) {
		findId(id);
		subEstacaoRepository.deleteById(id);
		
	}

	public Subestacao update(Integer id, Subestacao obj) {
		Subestacao newObj = findId(id);
		newObj.setNome(obj.getNome());
		newObj.setLatitude(obj.getLatitude());
		newObj.setLongitude(obj.getLongitude());
		return subEstacaoRepository.save(newObj);
	}

	public Page<Subestacao> findPage(Integer page, Integer linesPerPage) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage);
		return subEstacaoRepository.findAll(pageRequest);
	}

}
