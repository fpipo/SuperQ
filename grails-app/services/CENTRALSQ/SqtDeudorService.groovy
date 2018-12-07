package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtDeudor)
interface SqtDeudorService {

    SqtDeudor get(Serializable id)

    List<SqtDeudor> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDeudor save(SqtDeudor sqtDeudor)

}