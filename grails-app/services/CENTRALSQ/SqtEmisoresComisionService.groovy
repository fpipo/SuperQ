package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtEmisoresComision)
interface SqtEmisoresComisionService {

    SqtEmisoresComision get(Serializable id)

    List<SqtEmisoresComision> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtEmisoresComision save(SqtEmisoresComision sqtEmisoresComision)

}