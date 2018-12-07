package CENRALSQ

import grails.gorm.services.Service

@Service(SqtDepositos)
interface SqtDepositosService {

    SqtDepositos get(Serializable id)

    List<SqtDepositos> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDepositos save(SqtDepositos sqtDepositos)

}