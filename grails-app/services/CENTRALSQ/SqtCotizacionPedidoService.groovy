package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtCotizacionPedido)
interface SqtCotizacionPedidoService {

    SqtCotizacionPedido get(Serializable id)

    List<SqtCotizacionPedido> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCotizacionPedido save(SqtCotizacionPedido sqtCotizacionPedido)

}