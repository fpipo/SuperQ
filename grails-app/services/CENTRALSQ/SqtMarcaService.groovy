package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtMarca)
interface SqtMarcaService {

    SqtMarca get(Serializable id)

    List<SqtMarca> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtMarca save(SqtMarca sqtMarca)

}