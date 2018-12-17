package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtProveedorLibreCompra)
interface SqtProveedorLibreCompraService {

    SqtProveedorLibreCompra get(Serializable id)

    List<SqtProveedorLibreCompra> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtProveedorLibreCompra save(SqtProveedorLibreCompra sqtProveedorLibreCompra)

}