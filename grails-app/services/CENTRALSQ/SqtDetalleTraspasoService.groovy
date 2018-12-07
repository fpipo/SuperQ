package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtDetalleTraspaso)
interface SqtDetalleTraspasoService {

    SqtDetalleTraspaso get(Serializable id)

    List<SqtDetalleTraspaso> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDetalleTraspaso save(SqtDetalleTraspaso sqtDetalleTraspaso)

}