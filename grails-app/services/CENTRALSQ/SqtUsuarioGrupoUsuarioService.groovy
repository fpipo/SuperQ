package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtUsuarioGrupoUsuario)
interface SqtUsuarioGrupoUsuarioService {

    SqtUsuarioGrupoUsuario get(Serializable id)

    List<SqtUsuarioGrupoUsuario> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtUsuarioGrupoUsuario save(SqtUsuarioGrupoUsuario sqtUsuarioGrupoUsuario)

}