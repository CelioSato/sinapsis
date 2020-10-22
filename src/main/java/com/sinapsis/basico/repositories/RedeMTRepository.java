package com.sinapsis.basico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sinapsis.basico.domain.RedeMT;

@Repository
public interface RedeMTRepository extends JpaRepository<RedeMT, Integer>{

	@Query("select r from RedeMT r join r.sub s where upper( s.nome ) like upper( :nome )")
	List<RedeMT> findByNomeRede(@Param("nome") String nome);
}
