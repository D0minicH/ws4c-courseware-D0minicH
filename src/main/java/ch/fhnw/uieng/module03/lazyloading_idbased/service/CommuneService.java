package ch.fhnw.uieng.module03.lazyloading_idbased.service;

import java.util.List;

/**
 * @author Dieter Holz
 */
public interface CommuneService {

    List<Long> getAllIds();

    CommuneDTO getCommuneById(long id);
}
