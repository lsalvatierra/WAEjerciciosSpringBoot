package edu.pe.idat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import edu.pe.idat.model.PromedioFinalForm;

@Controller
public class PromedioController {

	@GetMapping("/promedionotas")
	public ModelAndView promedionotas() {
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("promediofinalform", new PromedioFinalForm());
		modelView.addObject("visualizar", false);
		return modelView;
	}
	
	@PostMapping("/promedionotas")
	public String promedionotas(@ModelAttribute("promediofinalform") PromedioFinalForm promedioFinalForm, 
			Model model) {
		Double valorEc1 = promedioFinalForm.getEvacontinua1() * 0.04;
		Double valorEc2 = promedioFinalForm.getEvacontinua2() * 0.12;
		Double valorEc3 = promedioFinalForm.getEvacontinua3() * 0.24;
		Double valorEf = promedioFinalForm.getEvafinal() * 0.6;
		Double valorPromFinal = valorEc1 + valorEc2 + valorEc3 * valorEf;
		String resultadoPromedio = "DESAPROBADO";
		if(valorPromFinal >= 12.5) {
			resultadoPromedio = "APROBADO";
		}
		model.addAttribute("visualizar", true);
		model.addAttribute("resultado", "Su promedio final es: "+ 
		String.format("%.2f", valorPromFinal)+ ", usted se encuentra"+ 
		resultadoPromedio);
		return "promedionotas";
	}
}
