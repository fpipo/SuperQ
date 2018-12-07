package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtProductoPaquete)
interface SqtProductoPaqueteService {

    SqtProductoPaquete get(Serializable id)

    List<SqtProductoPaquete> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtProductoPaquete save(SqtProductoPaquete sqtProductoPaquete)

}