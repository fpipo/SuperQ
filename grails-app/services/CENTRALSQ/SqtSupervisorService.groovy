package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtSupervisor)
interface SqtSupervisorService {

    SqtSupervisor get(Serializable id)

    List<SqtSupervisor> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtSupervisor save(SqtSupervisor sqtSupervisor)

}