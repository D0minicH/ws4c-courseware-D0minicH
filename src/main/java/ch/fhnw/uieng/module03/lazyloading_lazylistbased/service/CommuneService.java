package ch.fhnw.uieng.module03.lazyloading_lazylistbased.service;

import java.util.List;

/**
 * @author Dieter Holz
 */
public interface CommuneService {

    int getTotalCount();

    CommuneDTO getCommune(int rowIndex);

    List<CommuneDTO> findAll();
}
