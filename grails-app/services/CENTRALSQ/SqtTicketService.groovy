package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtTicket)
interface SqtTicketService {

    SqtTicket get(Serializable id)

    List<SqtTicket> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtTicket save(SqtTicket sqtTicket)

}