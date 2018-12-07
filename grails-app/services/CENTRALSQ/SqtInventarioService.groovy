package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtInventario)
interface SqtInventarioService {

    SqtInventario get(Serializable id)

    List<SqtInventario> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtInventario save(SqtInventario sqtInventario)

}