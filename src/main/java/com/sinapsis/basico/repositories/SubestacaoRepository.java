package com.sinapsis.basico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sinapsis.basico.domain.Subestacao;

@Repository
public interface SubestacaoRepository extends JpaRepository<Subestacao, Integer>{

}
