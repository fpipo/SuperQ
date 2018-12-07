package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtCantidadCaja)
interface SqtCantidadCajaService {

    SqtCantidadCaja get(Serializable id)

    List<SqtCantidadCaja> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCantidadCaja save(SqtCantidadCaja sqtCantidadCaja)

}