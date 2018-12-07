package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtTienda)
interface SqtTiendaService {

    SqtTienda get(Serializable id)

    List<SqtTienda> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtTienda save(SqtTienda sqtTienda)

}