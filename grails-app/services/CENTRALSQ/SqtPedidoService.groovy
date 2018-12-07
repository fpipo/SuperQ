package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtPedido)
interface SqtPedidoService {

    SqtPedido get(Serializable id)

    List<SqtPedido> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtPedido save(SqtPedido sqtPedido)

}