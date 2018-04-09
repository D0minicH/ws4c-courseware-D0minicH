package ch.fhnw.uieng.module03.lazyloading_lazylistbased_zolution.service;

import java.util.List;

/**
 * @author Dieter Holz
 */
public interface PagingService<DTO> {
    int getCount();

    List<DTO> getPage(int start, int pageSize);
}
