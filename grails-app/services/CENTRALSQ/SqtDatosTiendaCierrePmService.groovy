package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtDatosTiendaCierrePm)
interface SqtDatosTiendaCierrePmService {

    SqtDatosTiendaCierrePm get(Serializable id)

    List<SqtDatosTiendaCierrePm> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDatosTiendaCierrePm save(SqtDatosTiendaCierrePm sqtDatosTiendaCierrePm)

}