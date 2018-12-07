package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtInventarioCompensacion)
interface SqtInventarioCompensacionService {

    SqtInventarioCompensacion get(Serializable id)

    List<SqtInventarioCompensacion> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtInventarioCompensacion save(SqtInventarioCompensacion sqtInventarioCompensacion)

}