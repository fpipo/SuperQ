package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtMotivoDevolucion)
interface SqtMotivoDevolucionService {

    SqtMotivoDevolucion get(Serializable id)

    List<SqtMotivoDevolucion> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtMotivoDevolucion save(SqtMotivoDevolucion sqtMotivoDevolucion)

}