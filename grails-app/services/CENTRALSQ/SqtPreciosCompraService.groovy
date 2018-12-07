package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtPreciosCompra)
interface SqtPreciosCompraService {

    SqtPreciosCompra get(Serializable id)

    List<SqtPreciosCompra> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtPreciosCompra save(SqtPreciosCompra sqtPreciosCompra)

}