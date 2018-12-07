package CENRALSQ

import grails.gorm.services.Service

@Service(SqtCuentaContable)
interface SqtCuentaContableService {

    SqtCuentaContable get(Serializable id)

    List<SqtCuentaContable> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCuentaContable save(SqtCuentaContable sqtCuentaContable)

}