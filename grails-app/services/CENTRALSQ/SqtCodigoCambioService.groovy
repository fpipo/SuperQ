package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtCodigoCambio)
interface SqtCodigoCambioService {

    SqtCodigoCambio get(Serializable id)

    List<SqtCodigoCambio> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCodigoCambio save(SqtCodigoCambio sqtCodigoCambio)

}