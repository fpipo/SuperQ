package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtListaPrecios)
interface SqtListaPreciosService {

    SqtListaPrecios get(Serializable id)

    List<SqtListaPrecios> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtListaPrecios save(SqtListaPrecios sqtListaPrecios)

}