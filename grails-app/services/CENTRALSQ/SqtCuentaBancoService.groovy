package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtCuentaBanco)
interface SqtCuentaBancoService {

    SqtCuentaBanco get(Serializable id)

    List<SqtCuentaBanco> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCuentaBanco save(SqtCuentaBanco sqtCuentaBanco)

}