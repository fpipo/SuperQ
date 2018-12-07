package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtMapeoProducto)
interface SqtMapeoProductoService {

    SqtMapeoProducto get(Serializable id)

    List<SqtMapeoProducto> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtMapeoProducto save(SqtMapeoProducto sqtMapeoProducto)

}