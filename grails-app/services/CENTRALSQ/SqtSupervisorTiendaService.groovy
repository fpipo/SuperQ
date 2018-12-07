package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtSupervisorTienda)
interface SqtSupervisorTiendaService {

    SqtSupervisorTienda get(Serializable id)

    List<SqtSupervisorTienda> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtSupervisorTienda save(SqtSupervisorTienda sqtSupervisorTienda)

}