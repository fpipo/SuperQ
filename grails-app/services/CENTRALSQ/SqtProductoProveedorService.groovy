package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtProductoProveedor)
interface SqtProductoProveedorService {

    SqtProductoProveedor get(Serializable id)

    List<SqtProductoProveedor> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtProductoProveedor save(SqtProductoProveedor sqtProductoProveedor)

}