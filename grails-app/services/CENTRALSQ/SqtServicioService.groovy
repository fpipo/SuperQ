package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtServicio)
interface SqtServicioService {

    SqtServicio get(Serializable id)

    List<SqtServicio> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtServicio save(SqtServicio sqtServicio)

}