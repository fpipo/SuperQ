package CENRALSQ

import grails.gorm.services.Service

@Service(SqtDepositoCierre)
interface SqtDepositoCierreService {

    SqtDepositoCierre get(Serializable id)

    List<SqtDepositoCierre> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDepositoCierre save(SqtDepositoCierre sqtDepositoCierre)

}