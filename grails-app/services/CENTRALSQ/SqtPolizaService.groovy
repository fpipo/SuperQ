package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtPoliza)
interface SqtPolizaService {

    SqtPoliza get(Serializable id)

    List<SqtPoliza> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtPoliza save(SqtPoliza sqtPoliza)

}