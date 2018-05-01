package ch.fhnw.uieng.module05.mountainform_attributebased_solution.service;

/**
 * @author Dieter Holz
 */
public interface MountainService {
    MountainDetailDTO findAny();

    void save(MountainDetailDTO dto);
}
