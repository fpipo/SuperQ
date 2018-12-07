package CENRALSQ

import grails.gorm.services.Service

@Service(SqtCategoriaSq)
interface SqtCategoriaSqService {

    SqtCategoriaSq get(Serializable id)

    List<SqtCategoriaSq> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCategoriaSq save(SqtCategoriaSq sqtCategoriaSq)

}