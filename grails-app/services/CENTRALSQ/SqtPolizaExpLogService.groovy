package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtPolizaExpLog)
interface SqtPolizaExpLogService {

    SqtPolizaExpLog get(Serializable id)

    List<SqtPolizaExpLog> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtPolizaExpLog save(SqtPolizaExpLog sqtPolizaExpLog)

}