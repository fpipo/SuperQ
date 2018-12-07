package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtTraspaso)
interface SqtTraspasoService {

    SqtTraspaso get(Serializable id)

    List<SqtTraspaso> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtTraspaso save(SqtTraspaso sqtTraspaso)

}