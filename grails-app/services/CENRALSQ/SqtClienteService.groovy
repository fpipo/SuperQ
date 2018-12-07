package CENRALSQ

import grails.gorm.services.Service

@Service(SqtCliente)
interface SqtClienteService {

    SqtCliente get(Serializable id)

    List<SqtCliente> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCliente save(SqtCliente sqtCliente)

}