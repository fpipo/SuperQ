package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtMoviemientoContable)
interface SqtMoviemientoContableService {

    SqtMoviemientoContable get(Serializable id)

    List<SqtMoviemientoContable> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtMoviemientoContable save(SqtMoviemientoContable sqtMoviemientoContable)

}