package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtTipo)
interface SqtTipoService {

    SqtTipo get(Serializable id)

    List<SqtTipo> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtTipo save(SqtTipo sqtTipo)

}