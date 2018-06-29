package com.ufc.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.br.model.Cliente;
import com.ufc.br.service.ClienteService;

import antlr.collections.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping("/cadastrarCliente")
	public ModelAndView formularioCliente() {
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("cliente", new Cliente());
		return mv;
	}
	@PostMapping("/salvar")
	public ModelAndView salvarCliente(Cliente cliente,@RequestParam(value= "imagem") MultipartFile imagem) {
		clienteService.adicionarCliente(cliente,imagem);
		
		
		ModelAndView mv = new ModelAndView("redirect:/cliente/listar");
		mv.addObject("mensagem", "Usuário cadastrado com sucesso");
		
		return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView listarCliente() {
		List<Cliente> clientes = clienteService.retornarTodasAsCliente();
		ModelAndView mv = new ModelAndView("pagina-listagem");
		
		mv.addObject("todasAsCliente", clientes);
		return mv;
	}
	@RequestMapping("/logar")
	public ModelAndView logar() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
}
	