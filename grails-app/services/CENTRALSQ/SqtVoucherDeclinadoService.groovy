package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtVoucherDeclinado)
interface SqtVoucherDeclinadoService {

    SqtVoucherDeclinado get(Serializable id)

    List<SqtVoucherDeclinado> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtVoucherDeclinado save(SqtVoucherDeclinado sqtVoucherDeclinado)

}