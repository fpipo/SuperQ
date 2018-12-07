package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtRemesas)
interface SqtRemesasService {

    SqtRemesas get(Serializable id)

    List<SqtRemesas> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtRemesas save(SqtRemesas sqtRemesas)

}