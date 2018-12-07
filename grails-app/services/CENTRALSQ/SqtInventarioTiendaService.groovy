package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtInventarioTienda)
interface SqtInventarioTiendaService {

    SqtInventarioTienda get(Serializable id)

    List<SqtInventarioTienda> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtInventarioTienda save(SqtInventarioTienda sqtInventarioTienda)

}