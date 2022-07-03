package org.nedid.corona.vargas.controller;

import java.util.List;

import org.nedid.corona.vargas.model.Categoria;
import org.nedid.corona.vargas.model.Vacante;
import org.nedid.corona.vargas.service.IntCategorias;
import org.nedid.corona.vargas.service.IntVacantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller	
public class HomeController {
	
	@Autowired
	private IntVacantes serviceVacantes;
	
	@Autowired
	private IntCategorias serviceCategorias;
	
	
	@GetMapping ("/home")
	public String mostrarHome(Model model) {
		List<Vacante>lista =serviceVacantes.obtenerTodas();
		List<Categoria> categorias=serviceCategorias.obtenerTodas();
		model.addAttribute("vacantes", lista);  
		model.addAttribute("categorias", categorias);
		return "home";
	}
}
