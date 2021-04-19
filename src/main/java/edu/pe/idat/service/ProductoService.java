package edu.pe.idat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.pe.idat.model.Producto;
import edu.pe.idat.model.VentaProducto;
import edu.pe.idat.repository.ProductoRepository;

@Service
public class ProductoService implements ProductoRepository {

	@Override
	public List<Producto> listarProductos() {
		List<Producto> lstproducto = new ArrayList<>();
		lstproducto.add(new Producto("P001", "Arroz", 3.5));
		lstproducto.add(new Producto("P002", "Azucar", 2.5));
		lstproducto.add(new Producto("P003", "Mantequilla", 5.5));
		lstproducto.add(new Producto("P004", "Yogurt", 7.5));
		lstproducto.add(new Producto("P005", "Leche", 3.0));
		lstproducto.add(new Producto("P006", "Galletas", 4.5));
		return lstproducto;
	}



	@Override
	public List<VentaProducto> agregarProducto(VentaProducto objVentaProd, 
			List<VentaProducto> listVentaProd) {
		Boolean nuevoActualizado = false;
		Boolean agregarNuevo = false;
		List<VentaProducto> nuevaListVentaProducto = new ArrayList<VentaProducto>();
		if(listVentaProd.size() == 0) {
			nuevaListVentaProducto.add(objVentaProd);
		}else {
			for(VentaProducto objVenta : listVentaProd) {
				if(objVenta.getCodProducto().equals(objVentaProd.getCodProducto())) {
					nuevaListVentaProducto.add(
							new VentaProducto(objVentaProd.getCodProducto(),
									objVentaProd.getNomProducto(),
									objVenta.getCantidadTotal() + objVentaProd.getCantidadTotal(), 
									objVenta.getPrecioTotal() + objVentaProd.getPrecioTotal())
							);
					nuevoActualizado = true; agregarNuevo = false;
				}else {
					nuevaListVentaProducto.add(objVentaProd);
					if(nuevoActualizado) {
						agregarNuevo = false;
					}else
						agregarNuevo = true;
				}
			}
			if(agregarNuevo) {
				nuevaListVentaProducto.add(objVentaProd);
			}
			
		}
		return nuevaListVentaProducto;
	}



	@Override
	public Producto buscarProducto(String codproducto) {
		List<Producto> lstproducto = listarProductos();
		Producto productoEncontrado = null;
		for(Producto objProducto : lstproducto) {
			if(objProducto.getCodProducto().equals(codproducto)) {
				productoEncontrado = objProducto; 
				break;
			}
		}
		return productoEncontrado;
	}

}
