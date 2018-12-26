package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtTransaccionTel)
interface SqtTransaccionTelService {

    SqtTransaccionTel get(Serializable id)

    List<SqtTransaccionTel> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtTransaccionTel save(SqtTransaccionTel sqtTransaccionTel)

}