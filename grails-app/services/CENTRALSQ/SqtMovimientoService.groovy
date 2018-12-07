package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtMovimiento)
interface SqtMovimientoService {

    SqtMovimiento get(Serializable id)

    List<SqtMovimiento> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtMovimiento save(SqtMovimiento sqtMovimiento)

}