package ch.fhnw.uieng.module04.mountainapp.service;

import java.util.List;

/**
 * @author Dieter Holz
 */
public interface PagingService<DTO> {
    int getCount();

    List<DTO> getPage(int start, int pageSize);
}
