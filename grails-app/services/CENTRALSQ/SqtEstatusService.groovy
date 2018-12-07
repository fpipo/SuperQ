package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtEstatus)
interface SqtEstatusService {

    SqtEstatus get(Serializable id)

    List<SqtEstatus> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtEstatus save(SqtEstatus sqtEstatus)

}