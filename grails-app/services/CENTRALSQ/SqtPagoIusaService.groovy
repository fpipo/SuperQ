package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtPagoIusa)
interface SqtPagoIusaService {

    SqtPagoIusa get(Serializable id)

    List<SqtPagoIusa> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtPagoIusa save(SqtPagoIusa sqtPagoIusa)

}