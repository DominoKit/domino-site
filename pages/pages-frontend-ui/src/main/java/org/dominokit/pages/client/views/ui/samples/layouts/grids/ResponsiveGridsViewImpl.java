package org.dominokit.pages.client.views.ui.samples.layouts.grids;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.ui.style.ColorsCss;
import org.dominokit.domino.ui.style.DisplayCss;
import org.dominokit.pages.client.presenters.samples.layouts.ResponsiveGridsProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = ResponsiveGridsProxy.class)
public class ResponsiveGridsViewImpl extends SampleViewImpl {

    public ResponsiveGridsViewImpl() {
        register(DemoSample.of("responsive-grids-12-columns", Grid12ColumnsSample.class, LazyProvider.of(Grid12ColumnsSample::create))
                .onRender(demoComponent -> {
                    demoComponent
                            .withSampleContainer((demoComponent1, content) -> content.setCssProperty("max-height", "700px").addCss(DisplayCss.dui_overflow_y_auto, ColorsCss.dui_bg_dominant))
                    ;
                })
        );
        register(DemoSample.of("responsive-grids-16-columns", Grid16ColumnsSample.class, LazyProvider.of(Grid16ColumnsSample::create))
                .onRender(demoComponent -> {
                    demoComponent
                            .withSampleContainer((demoComponent1, content) -> content.setCssProperty("max-height", "700px").addCss(DisplayCss.dui_overflow_y_auto, ColorsCss.dui_bg_dominant))
                    ;
                })
        );
        register(DemoSample.of("responsive-grids-18-columns", Grid18ColumnsSample.class, LazyProvider.of(Grid18ColumnsSample::create))
                .onRender(demoComponent -> {
                    demoComponent
                            .withSampleContainer((demoComponent1, content) -> content.setCssProperty("max-height", "700px").addCss(DisplayCss.dui_overflow_y_auto, ColorsCss.dui_bg_dominant))
                    ;
                })
        );
        register(DemoSample.of("responsive-grids-24-columns", Grid24ColumnsSample.class, LazyProvider.of(Grid24ColumnsSample::create))
                .onRender(demoComponent -> {
                    demoComponent
                            .withSampleContainer((demoComponent1, content) -> content.setCssProperty("max-height", "700px").addCss(DisplayCss.dui_overflow_y_auto, ColorsCss.dui_bg_dominant))
                    ;
                })
        );
        register(DemoSample.of("responsive-grids-32-columns", Grid32ColumnsSample.class, LazyProvider.of(Grid32ColumnsSample::create))
                .onRender(demoComponent -> {
                    demoComponent
                            .withSampleContainer((demoComponent1, content) -> content.setCssProperty("max-height", "700px").addCss(DisplayCss.dui_overflow_y_auto, ColorsCss.dui_bg_dominant))
                    ;
                })
        );
    }
}