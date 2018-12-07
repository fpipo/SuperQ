package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtReembolsoFormaPago)
interface SqtReembolsoFormaPagoService {

    SqtReembolsoFormaPago get(Serializable id)

    List<SqtReembolsoFormaPago> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtReembolsoFormaPago save(SqtReembolsoFormaPago sqtReembolsoFormaPago)

}