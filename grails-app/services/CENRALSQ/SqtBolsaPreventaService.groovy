package CENRALSQ

import grails.gorm.services.Service

@Service(SqtBolsaPreventa)
interface SqtBolsaPreventaService {

    SqtBolsaPreventa get(Serializable id)

    List<SqtBolsaPreventa> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtBolsaPreventa save(SqtBolsaPreventa sqtBolsaPreventa)

}