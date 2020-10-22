package com.sinapsis.basico;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sinapsis.basico.domain.RedeMT;
import com.sinapsis.basico.domain.Subestacao;
import com.sinapsis.basico.repositories.RedeMTRepository;
import com.sinapsis.basico.repositories.SubestacaoRepository;

@SpringBootApplication
public class SinapsisApplication implements CommandLineRunner{

	@Autowired
	private SubestacaoRepository subEstacaoRepository;
	
	@Autowired
	private RedeMTRepository redeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SinapsisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Subestacao sub  = new Subestacao(null, "AML", "Subestacao A", -3.073663, -60.038825);
		Subestacao sub1 = new Subestacao(null, "MKP", "Subestacao B", -23.664032, -46.458707);
		Subestacao sub2 = new Subestacao(null, "ZFA", "Subestacao C", -3.073663, -60.038825);
		Subestacao sub3  = new Subestacao(null, "NJI", "Subestacao D", -23.664032, -46.458707);
		
		
	
		RedeMT rede = new RedeMT(null, "ZFA01", "Alimentador Principal 1", 321.59, sub);
		RedeMT rede1 = new RedeMT(null, "ZFA02", "Alimentador Principal 1", 321.59, sub);
		RedeMT rede2 = new RedeMT(null, "ZFA03", "Alimentador Principal 1", 321.59, sub);
		
		RedeMT rede3 = new RedeMT(null, "ZFA04", "Alimentador Principal 1", 321.59, sub1);
		RedeMT rede4 = new RedeMT(null, "ZFA05", "Alimentador Principal 1", 321.59, sub2);
		RedeMT rede5 = new RedeMT(null, "ZFA06", "Alimentador Principal 1", 321.59, sub3);
		
		sub.getRedes().addAll(Arrays.asList(rede, rede1, rede2));
		sub1.getRedes().addAll(Arrays.asList(rede3));
		sub2.getRedes().addAll(Arrays.asList(rede4));
		sub3.getRedes().addAll(Arrays.asList(rede5));
	
		subEstacaoRepository.saveAll(Arrays.asList(sub, sub1, sub2, sub3));
		redeRepository.saveAll(Arrays.asList(rede, rede1, rede2, rede3, rede4, rede5));
	
	}
		

}
