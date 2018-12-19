package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtPolizaCentral)
interface SqtPolizaCentralService {

    SqtPolizaCentral get(Serializable id)

    List<SqtPolizaCentral> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtPolizaCentral save(SqtPolizaCentral sqtPolizaCentral)

}