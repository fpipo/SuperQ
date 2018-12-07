package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtDetalleVentaProducto)
interface SqtDetalleVentaProductoService {

    SqtDetalleVentaProducto get(Serializable id)

    List<SqtDetalleVentaProducto> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDetalleVentaProducto save(SqtDetalleVentaProducto sqtDetalleVentaProducto)

}