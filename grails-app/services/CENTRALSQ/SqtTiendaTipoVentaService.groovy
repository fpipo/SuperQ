package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtTiendaTipoVenta)
interface SqtTiendaTipoVentaService {

    SqtTiendaTipoVenta get(Serializable id)

    List<SqtTiendaTipoVenta> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtTiendaTipoVenta save(SqtTiendaTipoVenta sqtTiendaTipoVenta)

}