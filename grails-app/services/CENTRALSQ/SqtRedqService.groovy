package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtQroBus)
interface SqtRedqService {

    SqtQroBus get(Serializable id)

    List<SqtQroBus> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtQroBus save(SqtQroBus sqtRedq)

}