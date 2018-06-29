package com.ufc.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ufc.br.model.Cliente;
//import com.ufc.br.model.Role;
import com.ufc.br.repository.ClienteRepository;
import com.ufc.br.util.AulaFileUtils;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public void adicionarCliente(Cliente cliente , MultipartFile imagem) {
		cliente.setSenha(new BCryptPasswordEncoder().encode(cliente.getSenha()));
		
		String caminho = "images/" + cliente.getNome() + ".jpg";
		AulaFileUtils.salvarImagem(caminho, imagem);

		clienteRepository.save(cliente);
	}

	public Cliente buscarPorId(Long id) {
		return clienteRepository.getOne(id);
	}

	public List<Cliente> retornarTodasAsCliente(){
		return clienteRepository.findAll();
	}
}
