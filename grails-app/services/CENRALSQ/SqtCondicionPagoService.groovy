package CENRALSQ

import grails.gorm.services.Service

@Service(SqtCondicionPago)
interface SqtCondicionPagoService {

    SqtCondicionPago get(Serializable id)

    List<SqtCondicionPago> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCondicionPago save(SqtCondicionPago sqtCondicionPago)

}