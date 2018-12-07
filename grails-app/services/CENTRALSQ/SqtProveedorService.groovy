package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtProveedor)
interface SqtProveedorService {

    SqtProveedor get(Serializable id)

    List<SqtProveedor> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtProveedor save(SqtProveedor sqtProveedor)

}