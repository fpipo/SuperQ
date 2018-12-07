package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtNuevaCategoria)
interface SqtNuevaCategoriaService {

    SqtNuevaCategoria get(Serializable id)

    List<SqtNuevaCategoria> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtNuevaCategoria save(SqtNuevaCategoria sqtNuevaCategoria)

}