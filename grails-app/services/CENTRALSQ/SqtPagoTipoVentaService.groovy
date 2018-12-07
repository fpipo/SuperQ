package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtPagoTipoVenta)
interface SqtPagoTipoVentaService {

    SqtPagoTipoVenta get(Serializable id)

    List<SqtPagoTipoVenta> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtPagoTipoVenta save(SqtPagoTipoVenta sqtPagoTipoVenta)

}