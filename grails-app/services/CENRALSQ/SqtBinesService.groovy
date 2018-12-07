package CENRALSQ

import grails.gorm.services.Service

@Service(SqtBines)
interface SqtBinesService {

    SqtBines get(Serializable id)

    List<SqtBines> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtBines save(SqtBines sqtBines)

}