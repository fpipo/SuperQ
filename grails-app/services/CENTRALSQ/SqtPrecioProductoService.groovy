package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtPrecioProducto)
interface SqtPrecioProductoService {

    SqtPrecioProducto get(Serializable id)

    List<SqtPrecioProducto> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtPrecioProducto save(SqtPrecioProducto sqtPrecioProducto)

}