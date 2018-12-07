package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtAlmacen)
interface SqtAlmacenService {

    SqtAlmacen get(Serializable id)

    List<SqtAlmacen> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtAlmacen save(SqtAlmacen sqtAlmacen)

}