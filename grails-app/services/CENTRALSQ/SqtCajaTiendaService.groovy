package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtCajaTienda)
interface SqtCajaTiendaService {

    SqtCajaTienda get(Serializable id)

    List<SqtCajaTienda> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCajaTienda save(SqtCajaTienda sqtCajaTienda)

}