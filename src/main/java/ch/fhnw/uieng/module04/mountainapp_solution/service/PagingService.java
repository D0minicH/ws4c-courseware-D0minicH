package ch.fhnw.uieng.module04.mountainapp_solution.service;

/**
 * @author Dieter Holz
 */
public interface PagingService<DTO> {
    Page<DTO> getPage(int start, int pageSize, String filter);

    int getFilteredCount(String filter);
}
