package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtFormaPago)
interface SqtFormaPagoService {

    SqtFormaPago get(Serializable id)

    List<SqtFormaPago> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtFormaPago save(SqtFormaPago sqtFormaPago)

}