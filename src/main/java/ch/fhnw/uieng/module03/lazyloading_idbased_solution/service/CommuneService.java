package ch.fhnw.uieng.module03.lazyloading_idbased_solution.service;

import java.util.List;

/**
 * @author Dieter Holz
 */
public interface CommuneService {

    List<Long> findAllIds();

    CommuneDTO get(long id);
}
