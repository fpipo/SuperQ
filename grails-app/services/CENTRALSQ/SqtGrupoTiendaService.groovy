package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtGrupoTienda)
interface SqtGrupoTiendaService {

    SqtGrupoTienda get(Serializable id)

    List<SqtGrupoTienda> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtGrupoTienda save(SqtGrupoTienda sqtGrupoTienda)

}