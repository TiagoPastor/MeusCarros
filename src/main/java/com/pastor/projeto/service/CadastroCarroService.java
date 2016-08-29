package com.pastor.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pastor.projeto.model.Carro;
import com.pastor.projeto.repository.Carros;
import com.pastor.projeto.storage.FotoStorage;

@Service
public class CadastroCarroService {
	
	@Autowired
	private Carros carros;
	
	@Autowired
	private FotoStorage fotoStorage;
	
	
	public void salvar(Carro carro){
		this.carros.save(carro);
		
	}
	
	public String salvarFoto(Long codigo, MultipartFile foto ){
		String nomeFoto = fotoStorage.salvar(foto);

		Carro carro = carros.findOne(codigo);
		carro.setFoto(nomeFoto); 
		carros.save(carro);
		
		return fotoStorage.getUrl(nomeFoto);
	}

}
