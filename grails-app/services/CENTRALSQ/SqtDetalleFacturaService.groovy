package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtDetalleFactura)
interface SqtDetalleFacturaService {

    SqtDetalleFactura get(Serializable id)

    List<SqtDetalleFactura> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDetalleFactura save(SqtDetalleFactura sqtDetalleFactura)

}