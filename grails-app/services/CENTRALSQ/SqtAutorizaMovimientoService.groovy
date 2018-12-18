package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtAutorizaMovimiento)
interface SqtAutorizaMovimientoService {

    SqtAutorizaMovimiento get(Serializable id)

    List<SqtAutorizaMovimiento> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtAutorizaMovimiento save(SqtAutorizaMovimiento sqtAutorizaMovimiento)

}