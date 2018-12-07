package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtSupervisorSq)
interface SqtSupervisorSqService {

    SqtSupervisorSq get(Serializable id)

    List<SqtSupervisorSq> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtSupervisorSq save(SqtSupervisorSq sqtSupervisorSq)

}