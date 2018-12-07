package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtAjusteProducto)
interface SqtAjusteProductoService {

    SqtAjusteProducto get(Serializable id)

    List<SqtAjusteProducto> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtAjusteProducto save(SqtAjusteProducto sqtAjusteProducto)

}