package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtUsuarioTienda)
interface SqtUsuarioTiendaService {

    SqtUsuarioTienda get(Serializable id)

    List<SqtUsuarioTienda> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtUsuarioTienda save(SqtUsuarioTienda sqtUsuarioTienda)

}