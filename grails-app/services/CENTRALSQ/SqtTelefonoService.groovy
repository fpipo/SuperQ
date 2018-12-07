package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtTelefono)
interface SqtTelefonoService {

    SqtTelefono get(Serializable id)

    List<SqtTelefono> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtTelefono save(SqtTelefono sqtTelefono)

}