package ch.fhnw.uieng.module03.lazyloading_lazylistbased_zolution.view.util;


import javafx.scene.control.Skin;
import javafx.scene.control.TableView;
import javafx.scene.control.skin.TableViewSkinBase;
import javafx.scene.control.skin.VirtualFlow;

import ch.fhnw.uieng.module03.lazyloading_lazylistbased_zolution.presentationmodel.PMBase;
import ch.fhnw.uieng.module03.lazyloading_lazylistbased_zolution.presentationmodel.util.PagingList;

/**
 * @author Dieter Holz
 */
public class FHNWTableView<PM extends PMBase<?>> extends TableView<PM> {

    public FHNWTableView(PagingList items) {
        super(items);
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        Skin<?> defaultSkin = super.createDefaultSkin();

        getPagingList().setFirstIndexShown(0);

        VirtualFlow flow = getVirtualFlow((TableViewSkinBase)defaultSkin);

        flow.heightProperty().addListener((observable, oldValue, newValue) -> {
            if (flow.getFirstVisibleCell() != null) {
                getPagingList().setVisibleRows(visibleRows(flow));
                getPagingList().setFirstIndexShown(flow.getFirstVisibleCell().getIndex());
            }
        });

        flow.positionProperty().addListener((observable, oldValue, newPosition) -> {
            PagingList ll    = getPagingList();
            int        size  = ll.size();
            int        first = (int) (newPosition.doubleValue() * (size - visibleRows(flow)));
            ll.setFirstIndexShown(first);
        });

        return defaultSkin;
    }

    private int visibleRows(VirtualFlow flow) {
        return (flow.getLastVisibleCell() == null || flow.getFirstVisibleCell() == null) ?
               0 :
               flow.getLastVisibleCell().getIndex() - flow.getFirstVisibleCell().getIndex() + 1;
    }

    private VirtualFlow getVirtualFlow(TableViewSkinBase skin) {
        return (VirtualFlow) skin.getChildren().stream()
                                 .filter(VirtualFlow.class::isInstance)
                                 .findAny()
                                 .orElse(null);
    }

    private PagingList getPagingList() {
        return (PagingList) getItems();
    }
}