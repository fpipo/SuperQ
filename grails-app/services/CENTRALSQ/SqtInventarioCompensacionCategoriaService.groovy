package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtInventarioCompensacionCategoria)
interface SqtInventarioCompensacionCategoriaService {

    SqtInventarioCompensacionCategoria get(Serializable id)

    List<SqtInventarioCompensacionCategoria> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtInventarioCompensacionCategoria save(SqtInventarioCompensacionCategoria sqtInventarioCompensacionCategoria)

}