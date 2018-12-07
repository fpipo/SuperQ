package CENRALSQ

import grails.gorm.services.Service

@Service(SqtCaja)
interface SqtCajaService {

    SqtCaja get(Serializable id)

    List<SqtCaja> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCaja save(SqtCaja sqtCaja)

}