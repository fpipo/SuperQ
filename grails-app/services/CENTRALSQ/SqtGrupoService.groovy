package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtGrupo)
interface SqtGrupoService {

    SqtGrupo get(Serializable id)

    List<SqtGrupo> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtGrupo save(SqtGrupo sqtGrupo)

}