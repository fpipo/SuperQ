package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtCategoriaProducto)
interface SqtCategoriaProductoService {

    SqtCategoriaProducto get(Serializable id)

    List<SqtCategoriaProducto> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCategoriaProducto save(SqtCategoriaProducto sqtCategoriaProducto)

}