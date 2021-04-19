package edu.pe.idat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pe.idat.model.VentaProducto;
import edu.pe.idat.service.ProductoService;

@Controller
@RequestMapping("/Producto")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;

	@GetMapping("/formVentaProducto")
	public String formVentaProducto(Model model) {
		model.addAttribute("ventaproductoform", new VentaProducto());
		model.addAttribute("lstproductos", productoService.listarProductos());
		model.addAttribute("visualizar", false);
		return "Producto/formventaproducto";
	}
}
