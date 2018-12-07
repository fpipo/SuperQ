package CENRALSQ

import grails.gorm.services.Service

@Service(SqtArea)
interface SqtAreaService {

    SqtArea get(Serializable id)

    List<SqtArea> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtArea save(SqtArea sqtArea)

}