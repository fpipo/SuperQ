package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtAcciones)
interface SqtAccionesService {

    SqtAcciones get(Serializable id)

    List<SqtAcciones> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtAcciones save(SqtAcciones sqtAcciones)

}