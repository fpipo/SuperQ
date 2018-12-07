package CENRALSQ

import grails.gorm.services.Service

@Service(SqtCierreTienda)
interface SqtCierreTiendaService {

    SqtCierreTienda get(Serializable id)

    List<SqtCierreTienda> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCierreTienda save(SqtCierreTienda sqtCierreTienda)

}