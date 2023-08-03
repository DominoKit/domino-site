package org.dominokit.pages.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoNavigator;

public class DemoCode extends BaseDominoElement<HTMLDivElement, DemoCode> {

    /*
    <div class="dui dui-relative dui-bg-black-l-3 dui-rounded dui-overflow-hidden dui-m-y-4" th:fragment="content (code)">
        <div class="dui dui-flex dui-site-code dui-overflow-auto">
            <pre class="dui dui-site-pre">
                <code class="dui dui-site-code" th:text="${code}">

                </code>
            </pre>
        </div>
        <div class="dui dui-site-copy-icon">
            <i class="dui mdi mdi-content-copy dui-fg-white dui-clickable" th:attr="onclick=|copyCode(`${code}`)|"></i>
        </div>
    </div>
     */
    private final DivElement root;

    public static DemoCode create(String code) {
        return new DemoCode(code);
    }

    public DemoCode(String code) {
        this.root = div()
                .addCss(dui_relative, dui_bg_black_l_3, dui_rounded, dui_overflow_hidden, dui_m_y_4)
                .appendChild(div()
                        .addCss(dui_flex, ()->"dui-site-code", dui_overflow_auto)
                        .appendChild(pre()
                                .addCss(()->"dui-site-pre")
                                .appendChild(code()
                                        .addCss(()->"dui-site-code")
                                        .setInnerHtml(PR.prettyPrintOne(code.replace("<", "&lt;").replace(">", "&gt;"), null, false))
                                )
                        )
                )
                .appendChild(div()
                        .addCss(()->"dui-site-copy-code")
                        .appendChild(Icons.content_copy()
                                .clickable()
                                .addClickListener(evt -> {
                                    Js.<DominoNavigator>uncheckedCast(DomGlobal.window.navigator).clipboard.writeText(code);
                                })
                        )
                );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }
}