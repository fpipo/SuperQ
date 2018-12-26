package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtMensajesTicket)
interface SqtMensajesTicketService {

    SqtMensajesTicket get(Serializable id)

    List<SqtMensajesTicket> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtMensajesTicket save(SqtMensajesTicket sqtMensajesTicket)

}