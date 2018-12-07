package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtProductoServicio)
interface SqtProductoServicioService {

    SqtProductoServicio get(Serializable id)

    List<SqtProductoServicio> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtProductoServicio save(SqtProductoServicio sqtProductoServicio)

}