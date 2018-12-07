package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtFuncion)
interface SqtFuncionService {

    SqtFuncion get(Serializable id)

    List<SqtFuncion> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtFuncion save(SqtFuncion sqtFuncion)

}