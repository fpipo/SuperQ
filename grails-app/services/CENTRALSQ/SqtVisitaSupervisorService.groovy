package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtVisitaSupervisor)
interface SqtVisitaSupervisorService {

    SqtVisitaSupervisor get(Serializable id)

    List<SqtVisitaSupervisor> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtVisitaSupervisor save(SqtVisitaSupervisor sqtVisitaSupervisor)

}