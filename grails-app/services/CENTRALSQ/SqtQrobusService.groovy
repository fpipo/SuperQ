package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtQrobus)
interface SqtQrobusService {

    SqtQrobus get(Serializable id)

    List<SqtQrobus> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtQrobus save(SqtQrobus sqtQrobus)

}