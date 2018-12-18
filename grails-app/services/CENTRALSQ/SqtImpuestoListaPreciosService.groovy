package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtImpuestoListaPrecios)
interface SqtImpuestoListaPreciosService {

    SqtImpuestoListaPrecios get(Serializable id)

    List<SqtImpuestoListaPrecios> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtImpuestoListaPrecios save(SqtImpuestoListaPrecios sqtImpuestoListaPrecios)

}