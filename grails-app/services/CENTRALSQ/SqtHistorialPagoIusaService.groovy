package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtHistorialPagoIusa)
interface SqtHistorialPagoIusaService {

    SqtHistorialPagoIusa get(Serializable id)

    List<SqtHistorialPagoIusa> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtHistorialPagoIusa save(SqtHistorialPagoIusa sqtHistorialPagoIusa)

}