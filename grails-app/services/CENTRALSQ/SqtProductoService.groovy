package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtProducto)
interface SqtProductoService {

    SqtProducto get(Serializable id)

    List<SqtProducto> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtProducto save(SqtProducto sqtProducto)

}