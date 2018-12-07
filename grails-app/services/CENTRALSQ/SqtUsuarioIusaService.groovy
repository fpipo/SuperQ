package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtUsuarioIusa)
interface SqtUsuarioIusaService {

    SqtUsuarioIusa get(Serializable id)

    List<SqtUsuarioIusa> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtUsuarioIusa save(SqtUsuarioIusa sqtUsuarioIusa)

}