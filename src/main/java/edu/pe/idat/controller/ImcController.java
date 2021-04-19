package edu.pe.idat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import edu.pe.idat.model.ImcForm;

@Controller
public class ImcController {

	@GetMapping("/calculoimc")
	public ModelAndView calculoimc() {
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("imcform", new ImcForm());
		modelView.addObject("visualizar", false);
		return modelView;
	}
	
	@PostMapping("/calculoimc")
	public String calculoimc(@ModelAttribute("imcform") ImcForm imcForm, 
			Model model) {
		Double tallam = imcForm.getTalla() / 100;
		Double valorImc = imcForm.getPeso() / (tallam * tallam);
		String resultadoImc = "";
		if(valorImc <= 18.5) {
			resultadoImc ="Por debajo del peso";
		}else if(valorImc <= 25) {
			resultadoImc ="Con peso normal";
		}else if(valorImc <= 30) {
			resultadoImc ="Con sobrepeso";
		}else if(valorImc <= 35) {
			resultadoImc ="Obesidad leve";
		}else if(valorImc <= 39) {
			resultadoImc ="Obesidad media";
		}else {
			resultadoImc ="Obesidad mórbida";
		}
		model.addAttribute("visualizar", true);
		model.addAttribute("resultado", "Su valor de IMC: "+ 
		String.format("%.2f", valorImc)+ ", usted se encuentra"+ 
				resultadoImc);
		return "calculoimc";
	}
}
