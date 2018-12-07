package CENRALSQ

import grails.gorm.services.Service

@Service(SqtDetallePedido)
interface SqtDetallePedidoService {

    SqtDetallePedido get(Serializable id)

    List<SqtDetallePedido> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDetallePedido save(SqtDetallePedido sqtDetallePedido)

}