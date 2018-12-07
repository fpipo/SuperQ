package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtZona)
interface SqtZonaService {

    SqtZona get(Serializable id)

    List<SqtZona> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtZona save(SqtZona sqtZona)

}