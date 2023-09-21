package org.dominokit.pages.client.presenters;

import org.dominokit.domino.history.HistoryToken;
import org.dominokit.pages.client.views.PagesView;
import org.dominokit.pages.shared.service.LoadContentServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

public interface ContentLoader {

    Logger LOGGER = LoggerFactory.getLogger(ContentLoader.class);
    boolean canLoad(HistoryToken token);
    void loadContent(HistoryToken token, PagesView view);

    default void getContent(String path, String page, boolean docsContent, Consumer<String> consumer){
        LoadContentServiceFactory.INSTANCE.getPageContent(path, page, docsContent)
                .onSuccess(consumer::accept)
                .onFailed(failedResponseBean -> {
                    LOGGER.error(failedResponseBean.getBody());
                })
                .onComplete(() -> {
                    LOGGER.info("Completed");
                })
                .send();
    }
}
