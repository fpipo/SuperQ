package CENRALSQ

import grails.gorm.services.Service

@Service(SqtCajaProducto)
interface SqtCajaProductoService {

    SqtCajaProducto get(Serializable id)

    List<SqtCajaProducto> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCajaProducto save(SqtCajaProducto sqtCajaProducto)

}