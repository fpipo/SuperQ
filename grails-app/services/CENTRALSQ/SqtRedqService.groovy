package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtRedq)
interface SqtRedqService {

    SqtRedq get(Serializable id)

    List<SqtRedq> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtRedq save(SqtRedq sqtRedq)

}