package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtFormaPagoSat)
interface SqtFormaPagoSatService {

    SqtFormaPagoSat get(Serializable id)

    List<SqtFormaPagoSat> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtFormaPagoSat save(SqtFormaPagoSat sqtFormaPagoSat)

}