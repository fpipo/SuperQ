package CENRALSQ

import grails.gorm.services.Service

@Service(SqtDetallePoliza)
interface SqtDetallePolizaService {

    SqtDetallePoliza get(Serializable id)

    List<SqtDetallePoliza> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDetallePoliza save(SqtDetallePoliza sqtDetallePoliza)

}