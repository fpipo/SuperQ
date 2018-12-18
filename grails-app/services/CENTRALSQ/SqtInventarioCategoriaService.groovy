package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtInventarioCategoria)
interface SqtInventarioCategoriaService {

    SqtInventarioCategoria get(Serializable id)

    List<SqtInventarioCategoria> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtInventarioCategoria save(SqtInventarioCategoria sqtInventarioCategoria)

}