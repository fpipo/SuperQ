package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtRetiroCaja)
interface SqtRetiroCajaService {

    SqtRetiroCaja get(Serializable id)

    List<SqtRetiroCaja> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtRetiroCaja save(SqtRetiroCaja sqtRetiroCaja)

}