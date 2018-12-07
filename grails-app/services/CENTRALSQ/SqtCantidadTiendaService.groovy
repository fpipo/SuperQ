package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtCantidadTienda)
interface SqtCantidadTiendaService {

    SqtCantidadTienda get(Serializable id)

    List<SqtCantidadTienda> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCantidadTienda save(SqtCantidadTienda sqtCantidadTienda)

}