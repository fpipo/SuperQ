package CENRALSQ

import grails.gorm.services.Service

@Service(SqtDetalleDevolucionVenta)
interface SqtDetalleDevolucionVentaService {

    SqtDetalleDevolucionVenta get(Serializable id)

    List<SqtDetalleDevolucionVenta> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDetalleDevolucionVenta save(SqtDetalleDevolucionVenta sqtDetalleDevolucionVenta)

}