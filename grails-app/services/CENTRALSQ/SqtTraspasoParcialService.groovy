package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtTraspasoParcial)
interface SqtTraspasoParcialService {

    SqtTraspasoParcial get(Serializable id)

    List<SqtTraspasoParcial> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtTraspasoParcial save(SqtTraspasoParcial sqtTraspasoParcial)

}