package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtProveedorGrupoTienda)
interface SqtProveedorGrupoTiendaService {

    SqtProveedorGrupoTienda get(Serializable id)

    List<SqtProveedorGrupoTienda> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtProveedorGrupoTienda save(SqtProveedorGrupoTienda sqtProveedorGrupoTienda)

}