package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtCategoria)
interface SqtCategoriaService {

    SqtCategoria get(Serializable id)

    List<SqtCategoria> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCategoria save(SqtCategoria sqtCategoria)

}