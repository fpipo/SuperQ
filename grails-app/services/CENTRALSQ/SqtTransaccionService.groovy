package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtTransaccion)
interface SqtTransaccionService {

    SqtTransaccion get(Serializable id)

    List<SqtTransaccion> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtTransaccion save(SqtTransaccion sqtTransaccion)

}