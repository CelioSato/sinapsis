package com.sinapsis.basico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.sinapsis.basico.domain.RedeMT;
import com.sinapsis.basico.domain.Subestacao;
import com.sinapsis.basico.dto.RedeMTDTO;
import com.sinapsis.basico.repositories.RedeMTRepository;

@Service
public class RedeMTService {

	@Autowired
	private RedeMTRepository redeRepository;
	
	@Autowired
	private SubestacaoService service;
	
	@Transactional
	public RedeMT insert(RedeMT obj) {
		obj.setId(null);
		obj = redeRepository.save(obj);
		return obj;
	}

	public RedeMT findId(Integer id) {
		Optional<RedeMT> obj = redeRepository.findById(id);
		return obj.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "RedeMT não encontrada") );
	}
	
	public List<RedeMT> findRede(String nome) {
		List<RedeMT> obj = redeRepository.findByNomeRede("%"+nome);
		return obj;
	}
	
	public void delete(Integer id) {
		findId(id);
		redeRepository.deleteById(id);
	}

	public RedeMT update(Integer id, RedeMT obj) {
		RedeMT newObj = findId(id);
		newObj.setNome(obj.getNome());
		newObj.setTensao_nominal(obj.getTensao_nominal());
		return redeRepository.save(newObj);
	}

	public Page<RedeMT> findPage(Integer page, Integer linesPerPage) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage);
		return redeRepository.findAll(pageRequest);
	}
	
	public RedeMT fromDto(RedeMTDTO objDto) {
		double tensao = Double.parseDouble(objDto.getTensao_nominal().replaceAll(",", "."));
		Subestacao newObj = service.findId(objDto.getId());
		return new RedeMT(objDto.getId(), objDto.getCodigo(), objDto.getNome(), tensao, newObj);
	}

}
