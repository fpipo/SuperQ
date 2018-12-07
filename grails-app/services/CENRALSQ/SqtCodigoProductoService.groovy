package CENRALSQ

import grails.gorm.services.Service

@Service(SqtCodigoProducto)
interface SqtCodigoProductoService {

    SqtCodigoProducto get(Serializable id)

    List<SqtCodigoProducto> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCodigoProducto save(SqtCodigoProducto sqtCodigoProducto)

}