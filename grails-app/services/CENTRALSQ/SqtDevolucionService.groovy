package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtDevolucion)
interface SqtDevolucionService {

    SqtDevolucion get(Serializable id)

    List<SqtDevolucion> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDevolucion save(SqtDevolucion sqtDevolucion)

}