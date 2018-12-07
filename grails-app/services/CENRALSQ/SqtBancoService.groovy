package CENRALSQ

import grails.gorm.services.Service

@Service(SqtBanco)
interface SqtBancoService {

    SqtBanco get(Serializable id)

    List<SqtBanco> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtBanco save(SqtBanco sqtBanco)

}