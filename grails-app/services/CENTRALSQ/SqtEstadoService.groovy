package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtEstado)
interface SqtEstadoService {

    SqtEstado get(Serializable id)

    List<SqtEstado> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtEstado save(SqtEstado sqtEstado)

}