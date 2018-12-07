package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtVoucher)
interface SqtVoucherService {

    SqtVoucher get(Serializable id)

    List<SqtVoucher> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtVoucher save(SqtVoucher sqtVoucher)

}