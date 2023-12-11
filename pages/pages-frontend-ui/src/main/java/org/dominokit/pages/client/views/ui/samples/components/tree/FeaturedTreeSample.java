package org.dominokit.pages.client.views.ui.samples.components.tree;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_accent_d_2;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_full;
import static org.dominokit.pages.shared.model.Countries.COUNTRIES;

import elemental2.dom.HTMLDivElement;
import java.util.List;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItem;
import org.dominokit.domino.ui.tree.TreeItemIcon;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.pages.shared.model.Countries;
import org.dominokit.pages.shared.model.Country;

public class FeaturedTreeSample extends BaseDominoElement<HTMLDivElement, FeaturedTreeSample> {
    private DivElement element;

    public static FeaturedTreeSample create() {
        return new FeaturedTreeSample();
    }

    public FeaturedTreeSample() {

        List<Country> countries = Countries.MAPPER.read(COUNTRIES).getCountries();

        Tree<String> citiesTree = Tree.<String>create("CITIES")
                .setFilter((treeItem, searchToken) -> {
                            boolean result = treeItem.getTitle().toLowerCase().contains(searchToken.toLowerCase());
                            if (treeItem.getParent().isPresent()) {
                                result = result || treeItem.getParent()
                                        .map(parent -> nonNull(parent.getValue()) && parent.getValue().toLowerCase().contains(searchToken.toLowerCase()))
                                        .orElse(false);
                            }
                            return result;
                        }
                )
                .setAutoCollapse(false)
                .setFoldable(true)
                .setSearchable(true)
                .setAutoExpandFound(true)
                .apply(tree -> {
                    countries.forEach(country -> {
                        tree
                                .appendChild(TreeItem.<String>create(Icons.map(), country.getName())
                                        .apply(countryItem -> {
                                                    countryItem
                                                            .appendChild(PostfixAddOn.of(Badge.create(String.valueOf(country.getCities().size()))
                                                                            .addCss(dui_bg_accent_d_2, dui_rounded_full)
                                                                    )
                                                            )
                                                            .appendChild(PostfixAddOn.of(ToggleMdiIcon.create(Icons.plus(), Icons.minus())
                                                                    .apply(icon -> {
                                                                        countryItem
                                                                                .addBeforeCollapseListener(icon::toggle)
                                                                                .addBeforeExpandListener(icon::toggle);
                                                                    })
                                                            ));

                                                    country.getCities().forEach(city -> countryItem.appendChild(TreeItem.create(Icons.city(), city)));
                                                }
                                        )
                                );
                    })
                    ;
                });


        Tree<String> foldersExpand = Tree.<String>create("FILES")
                .setAutoCollapse(false)
                .setFoldable(true)
                .setSearchable(true)
                .setTreeItemIconSupplier((item) -> TreeItemIcon.of(Icons.folder(), Icons.folder_open(), Icons.file(), Icons.file_check_outline()))
                .appendChild(TreeItem.create("Folder 1")
                        .appendChild(TreeItem.create("Folder 1-1")
                                .appendChild(TreeItem.create("File 1"))
                                .appendChild(TreeItem.create("File 2"))
                                .appendChild(TreeItem.create("File 3"))
                                .appendChild(TreeItem.create("File 4"))
                        ).appendChild(TreeItem.create("Folder 1-2")
                                .appendChild(TreeItem.create("File 1"))
                                .appendChild(TreeItem.create("File 2"))
                                .appendChild(TreeItem.create("File 3"))
                                .appendChild(TreeItem.create("File 4"))
                        )
                ).appendChild(TreeItem.create("Folder 2")
                        .appendChild(TreeItem.create("Folder 2-1")
                                .appendChild(TreeItem.create("File 1"))
                                .appendChild(TreeItem.create("File 2"))
                                .appendChild(TreeItem.create("File 3"))
                                .appendChild(TreeItem.create("File 4"))
                        )
                        .appendChild(TreeItem.create("Folder 2-2")
                                .appendChild(TreeItem.create("File 1"))
                                .appendChild(TreeItem.create("File 2"))
                                .appendChild(TreeItem.create("File 3"))
                                .appendChild(TreeItem.create("File 4"))
                        )
                )
                .appendChild(TreeItem.create("Folder 3")
                        .appendChild(TreeItem.create("Folder 3-1")
                                .appendChild(TreeItem.create("File 1"))
                                .appendChild(TreeItem.create("File 2"))
                                .appendChild(TreeItem.create("File 3"))
                                .appendChild(TreeItem.create("File 4"))
                                .expand()
                        ).appendChild(TreeItem.create("Folder 3-2")
                                .expand()
                                .appendChild(TreeItem.create("File 1"))
                                .appendChild(TreeItem.create("File 2"))
                                .appendChild(TreeItem.create("File 3"))
                                .appendChild(TreeItem.create("File 4"))
                                .expand()
                        ).expand()
                );

        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(BlockHeader.create("Active icon"))
                                .appendChild(citiesTree))
                        .appendChild(Column.span6()
                                .appendChild(BlockHeader.create("Expand icon"))
                                .appendChild(foldersExpand))
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
