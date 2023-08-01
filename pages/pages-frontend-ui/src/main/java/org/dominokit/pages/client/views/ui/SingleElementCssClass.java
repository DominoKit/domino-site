package org.dominokit.pages.client.views.ui;

import elemental2.dom.Element;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.HasCssClass;

import static java.util.Objects.nonNull;

public class SingleElementCssClass implements CssClass {

    private final CssClass cssClass;
    private Element currentElement;

    /**
     * of.
     *
     * @param cssClass a {@link CssClass} object.
     * @return a {@link org.dominokit.domino.ui.style.ToggleCssClass} object.
     */
    public static SingleElementCssClass of(CssClass cssClass) {
        return new SingleElementCssClass(cssClass);
    }

    /**
     * of.
     *
     * @param cssClass a {@link HasCssClass} object.
     * @return a {@link org.dominokit.domino.ui.style.ToggleCssClass} object.
     */
    public static SingleElementCssClass of(HasCssClass cssClass) {
        return new SingleElementCssClass(cssClass.getCssClass());
    }

    /**
     * of.
     *
     * @param cssClass a {@link String} object.
     * @return a {@link org.dominokit.domino.ui.style.ToggleCssClass} object.
     */
    public static SingleElementCssClass of(String cssClass) {
        return new SingleElementCssClass(() -> cssClass);
    }

    /**
     * Constructor for SingleElementCssClass.
     *
     * @param cssClass a {@link CssClass} object.
     */
    public SingleElementCssClass(CssClass cssClass) {
        this.cssClass = cssClass;
    }

    /** {@inheritDoc} */
    @Override
    public void apply(Element element) {
        if(nonNull(currentElement)){
            if(currentElement.classList.contains(getCssClass())){
                currentElement.classList.remove(getCssClass());
            }
        }
        this.currentElement = element;
        this.currentElement.classList.add(getCssClass());
    }

    public Element getCurrentElement() {
        return currentElement;
    }

    /** {@inheritDoc} */
    @Override
    public String getCssClass() {
        return cssClass.getCssClass();
    }
}
