package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtImpuestoProducto)
interface SqtImpuestoProductoService {

    SqtImpuestoProducto get(Serializable id)

    List<SqtImpuestoProducto> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtImpuestoProducto save(SqtImpuestoProducto sqtImpuestoProducto)

}