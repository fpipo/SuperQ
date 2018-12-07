package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtReembolso)
interface SqtReembolsoService {

    SqtReembolso get(Serializable id)

    List<SqtReembolso> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtReembolso save(SqtReembolso sqtReembolso)

}