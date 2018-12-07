package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtDireccion)
interface SqtDireccionService {

    SqtDireccion get(Serializable id)

    List<SqtDireccion> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDireccion save(SqtDireccion sqtDireccion)

}