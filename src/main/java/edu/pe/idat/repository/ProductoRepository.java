package edu.pe.idat.repository;

import java.util.List;

import edu.pe.idat.model.Producto;
import edu.pe.idat.model.VentaProducto;

public interface ProductoRepository {
	
	List<Producto> listarProductos();
	
	Producto buscarProducto(String codproducto);
	
	List<VentaProducto> agregarProducto(VentaProducto objVentaProd, 
			List<VentaProducto> listVentaProd); 
	

}
