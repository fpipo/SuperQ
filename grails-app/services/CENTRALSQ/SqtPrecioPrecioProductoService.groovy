package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtPrecioPrecioProducto)
interface SqtPrecioPrecioProductoService {

    SqtPrecioPrecioProducto get(Serializable id)

    List<SqtPrecioPrecioProducto> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtPrecioPrecioProducto save(SqtPrecioPrecioProducto sqtPrecioPrecioProducto)

}