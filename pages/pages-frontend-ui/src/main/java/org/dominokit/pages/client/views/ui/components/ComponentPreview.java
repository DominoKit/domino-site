package org.dominokit.pages.client.views.ui.components;

import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLPreElement;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.grid.flex.FlexDirection;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.pages.client.views.ui.PR;
import org.jboss.elemento.Elements;
import org.jboss.elemento.IsElement;

public class ComponentPreview extends BaseDominoElement<HTMLElement, ComponentPreview> {

    private final MdiIcon codeIcon = Icons.ALL.code_tags_mdi()
            .css("component-code-icon");
    private final FlexItem<HTMLDivElement> componentContent = FlexItem.create().addCss("component-content");
    private final DominoElement<HTMLDivElement> componentContainer = DominoElement.div().css("component-container");
    private final DominoElement<HTMLPreElement> codeElement = DominoElement.of(Elements.pre()).css("prettyprint").hide();
    private final DominoElement<HTMLDivElement> root = DominoElement.div();
    private final DominoElement<? extends HTMLElement> component;

    public static ComponentPreview of(String title, ExternalTextResource code, IsElement<? extends HTMLElement> component) {
        return new ComponentPreview(title, code, component);
    }

    private ComponentPreview(String title, ExternalTextResource code, IsElement<? extends HTMLElement> element) {
        root.addCss("component-preview");
        component = DominoElement.of(element);
        try {
            code.getText(new ResourceCallback<>() {
                @Override
                public void onError(ResourceException e) {
                    DomGlobal.console.error("could not load code from external resource", e);
                }

                @Override
                public void onSuccess(TextResource resource) {
                    codeElement.setInnerHtml(PR.prettyPrintOne(resource.getText().replace("<", "&lt;").replace(">", "&gt;"), null, false));
                }
            });
        } catch (ResourceException e) {
            e.printStackTrace();
        }
        codeIcon.addClickListener(evt -> {
            if (codeIcon.containsCss("active")) {
                codeIcon.removeCss("active");
            } else {
                codeIcon.addCss("active");
            }
            if (codeElement.isCollapsed()) {
                codeElement.show();
                componentContainer.hide();
            } else {
                codeElement.hide();
                componentContainer.show();
            }
        });
        root.appendChild(FlexLayout.create()
                .setDirection(FlexDirection.TOP_TO_BOTTOM)
                .appendChild(FlexItem.create()
                        .appendChild(FlexLayout.create()
                                .setDirection(FlexDirection.LEFT_TO_RIGHT)
                                .appendChild(FlexItem.create()
                                        .setFlexGrow(1)
                                        .appendChild(Paragraph.create(title).addCss("component-title"))
                                )
                                .appendChild(FlexItem.create()
                                        .appendChild(codeIcon)
                                )
                        )
                )
                .appendChild(componentContent
                        .appendChild(componentContainer.appendChild(component))
                        .appendChild(codeElement)
                )
        );
    }

    @Override
    public HTMLElement element() {
        return root.element();
    }
}
