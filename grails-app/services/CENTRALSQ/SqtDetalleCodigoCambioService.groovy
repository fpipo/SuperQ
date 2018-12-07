package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtDetalleCodigoCambio)
interface SqtDetalleCodigoCambioService {

    SqtDetalleCodigoCambio get(Serializable id)

    List<SqtDetalleCodigoCambio> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDetalleCodigoCambio save(SqtDetalleCodigoCambio sqtDetalleCodigoCambio)

}