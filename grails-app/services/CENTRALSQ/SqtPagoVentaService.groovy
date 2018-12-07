package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtPagoVenta)
interface SqtPagoVentaService {

    SqtPagoVenta get(Serializable id)

    List<SqtPagoVenta> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtPagoVenta save(SqtPagoVenta sqtPagoVenta)

}