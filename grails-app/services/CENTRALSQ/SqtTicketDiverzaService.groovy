package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtTicketDiverza)
interface SqtTicketDiverzaService {

    SqtTicketDiverza get(Serializable id)

    List<SqtTicketDiverza> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtTicketDiverza save(SqtTicketDiverza sqtTicketDiverza)

}