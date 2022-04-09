package com.unidade12.projetopi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.unidade12.projetopi.models.Evento;
import com.unidade12.projetopi.repository.EventoRepository;

@Controller
public class EventoController {
	
	@Autowired
	private EventoRepository er;
	
	
	@RequestMapping(value="/cadastrarEvento", method = RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}
	
	
	@RequestMapping(value="/cadastrarEvento", method = RequestMethod.POST)
	public String form(Evento evento) {
		
		er.save(evento);
		return "redirect:/cadastrarEvento";
	}
	
	//Método para link do evento Busca “após o ultimo método”
		@RequestMapping("/{codigo}")
		public ModelAndView detalhesEvento(@PathVariable("codigo")long codigo) {
			Evento evento=er.findByCodigo(codigo);
			ModelAndView mv =new ModelAndView("evento/detalhesEvento");
			mv.addObject("evento", evento);
			return mv;
		}

		// Método para Listar “Inserir no final do código”
		@RequestMapping("/eventos")
		public ModelAndView ListaEventos() {
			ModelAndView mv =new ModelAndView("index");
			Iterable<Evento> eventos = er.findAll();
			mv.addObject("eventos",eventos);
			return mv;
		}
		
		// Método para Excluir registro
		@RequestMapping("/deletarEvento")
		public String deletarEvento(long codigo) {
			Evento evento = er.findByCodigo(codigo);
			er.delete(evento);
			return "redirect:/eventos";
		}

}

