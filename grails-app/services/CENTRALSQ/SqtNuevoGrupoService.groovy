package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtNuevoGrupo)
interface SqtNuevoGrupoService {

    SqtNuevoGrupo get(Serializable id)

    List<SqtNuevoGrupo> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtNuevoGrupo save(SqtNuevoGrupo sqtNuevoGrupo)

}