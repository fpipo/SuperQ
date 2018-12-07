package CENRALSQ

import grails.gorm.services.Service

@Service(SqtComisionRango)
interface SqtComisionRangoService {

    SqtComisionRango get(Serializable id)

    List<SqtComisionRango> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtComisionRango save(SqtComisionRango sqtComisionRango)

}