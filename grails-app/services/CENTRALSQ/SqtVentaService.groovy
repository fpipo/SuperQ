package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtVenta)
interface SqtVentaService {

    SqtVenta get(Serializable id)

    List<SqtVenta> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtVenta save(SqtVenta sqtVenta)

}