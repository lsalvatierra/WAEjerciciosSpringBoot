package edu.pe.idat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pe.idat.model.Producto;
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
	
	public String registrarProducto(
			@ModelAttribute("ventaproductoform") VentaProducto ventaProductoForm,
			final HttpServletRequest request,
			Model model
			) {
		List<VentaProducto> lstVentaProducto = (List<VentaProducto>)request.getSession()
				.getAttribute("lstproducto"); 
		if(CollectionUtils.isEmpty(lstVentaProducto)) {
			lstVentaProducto = new ArrayList<VentaProducto>();
		}
		Producto objproducto = productoService.buscarProducto(ventaProductoForm.getCodProducto());
		Double preciototal = ventaProductoForm.getCantidadTotal() 
				* objproducto.getPrecioProducto();
		String respuesta = "El precio unitario del producto: "+ 
				objproducto.getPrecioProducto().toString() +
				" el valor total de venta es: " + preciototal.toString();
		VentaProducto objventaproducto = new VentaProducto(
				objproducto.getCodProducto(),
				objproducto.getNomProducto(),
				ventaProductoForm.getCantidadTotal(),
				preciototal);
		List<VentaProducto> nuevaListaVentaProducto = productoService
				.agregarProducto(objventaproducto, lstVentaProducto);
		request.getSession().setAttribute("lstproducto", nuevaListaVentaProducto);
		model.addAttribute("visualizar", true);
		model.addAttribute("respuesta", respuesta);
		model.addAttribute("lstproductos", productoService.listarProductos());
		return "Producto/formventaproducto";
	}
	
	
	
}
