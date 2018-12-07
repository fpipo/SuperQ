package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtTipoCliente)
interface SqtTipoClienteService {

    SqtTipoCliente get(Serializable id)

    List<SqtTipoCliente> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtTipoCliente save(SqtTipoCliente sqtTipoCliente)

}