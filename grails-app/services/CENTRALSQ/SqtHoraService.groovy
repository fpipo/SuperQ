package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtHora)
interface SqtHoraService {

    SqtHora get(Serializable id)

    List<SqtHora> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtHora save(SqtHora sqtHora)

}