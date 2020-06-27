package pe.com.pathOrder.pathOrder2.service;

import pe.com.pathOrder.pathOrder2.model.OrdenDespacho;

public interface OrdenDespachoService extends CrudService<OrdenDespacho, Integer>{
	OrdenDespacho saveWithCanal(OrdenDespacho orden) throws Exception;
}
