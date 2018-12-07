package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtPais)
interface SqtPaisService {

    SqtPais get(Serializable id)

    List<SqtPais> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtPais save(SqtPais sqtPais)

}