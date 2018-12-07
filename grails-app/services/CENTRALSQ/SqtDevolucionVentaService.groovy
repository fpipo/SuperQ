package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtDevolucionVenta)
interface SqtDevolucionVentaService {

    SqtDevolucionVenta get(Serializable id)

    List<SqtDevolucionVenta> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDevolucionVenta save(SqtDevolucionVenta sqtDevolucionVenta)

}