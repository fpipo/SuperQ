package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtMovimientoContable)
interface SqtMovimientoContableService {

    SqtMovimientoContable get(Serializable id)

    List<SqtMovimientoContable> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtMovimientoContable save(SqtMovimientoContable sqtMovimientoContable)

}