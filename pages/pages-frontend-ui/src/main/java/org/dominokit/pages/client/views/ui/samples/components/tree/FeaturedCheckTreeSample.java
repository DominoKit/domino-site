package org.dominokit.pages.client.views.ui.samples.components.tree;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.tree.TreeItemIcon;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.pages.shared.model.Countries;
import org.dominokit.pages.shared.model.Country;
import org.dominokit.pro.domino.ui.tree.CheckTree;
import org.dominokit.pro.domino.ui.tree.CheckTreeItem;

import java.util.List;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.pages.shared.model.Countries.COUNTRIES;

public class FeaturedCheckTreeSample extends BaseDominoElement<HTMLDivElement, FeaturedCheckTreeSample> {
    private DivElement element;

    public static FeaturedCheckTreeSample create() {
        return new FeaturedCheckTreeSample();
    }

    public FeaturedCheckTreeSample() {

        List<Country> countries = Countries.MAPPER.read(COUNTRIES).getCountries();

        CheckTree<String> citiesTree = CheckTree.<String>create("CITIES")
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
                                .appendChild(CheckTreeItem.<String>create(Icons.map(), country.getName())
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

                                                    country.getCities().forEach(city -> countryItem.appendChild(CheckTreeItem.create(Icons.city(), city)));
                                                }
                                        )
                                );
                    })
                    ;
                });


        CheckTree<String> foldersExpand = CheckTree.<String>create("FILES")
                .setAutoCollapse(false)
                .setFoldable(true)
                .setSearchable(true)
                .setNodeIconSupplier((item) -> TreeItemIcon.of(Icons.folder(), Icons.folder_open(), Icons.file(), Icons.file_check_outline()))
                .appendChild(CheckTreeItem.create("Folder 1")
                        .appendChild(CheckTreeItem.create("Folder 1-1")
                                .appendChild(CheckTreeItem.create("File 1"))
                                .appendChild(CheckTreeItem.create("File 2"))
                                .appendChild(CheckTreeItem.create("File 3"))
                                .appendChild(CheckTreeItem.create("File 4"))
                        ).appendChild(CheckTreeItem.create("Folder 1-2")
                                .appendChild(CheckTreeItem.create("File 1"))
                                .appendChild(CheckTreeItem.create("File 2"))
                                .appendChild(CheckTreeItem.create("File 3"))
                                .appendChild(CheckTreeItem.create("File 4"))
                        )
                ).appendChild(CheckTreeItem.create("Folder 2")
                        .appendChild(CheckTreeItem.create("Folder 2-1")
                                .appendChild(CheckTreeItem.create("File 1"))
                                .appendChild(CheckTreeItem.create("File 2"))
                                .appendChild(CheckTreeItem.create("File 3"))
                                .appendChild(CheckTreeItem.create("File 4"))
                        )
                        .appendChild(CheckTreeItem.create("Folder 2-2")
                                .appendChild(CheckTreeItem.create("File 1"))
                                .appendChild(CheckTreeItem.create("File 2"))
                                .appendChild(CheckTreeItem.create("File 3"))
                                .appendChild(CheckTreeItem.create("File 4"))
                        )
                )
                .appendChild(CheckTreeItem.create("Folder 3")
                        .appendChild(CheckTreeItem.create("Folder 3-1")
                                .appendChild(CheckTreeItem.create("File 1"))
                                .appendChild(CheckTreeItem.create("File 2"))
                                .appendChild(CheckTreeItem.create("File 3"))
                                .appendChild(CheckTreeItem.create("File 4"))
                                .expand()
                        ).appendChild(CheckTreeItem.create("Folder 3-2")
                                .expand()
                                .appendChild(CheckTreeItem.create("File 1"))
                                .appendChild(CheckTreeItem.create("File 2"))
                                .appendChild(CheckTreeItem.create("File 3"))
                                .appendChild(CheckTreeItem.create("File 4"))
                                .expand()
                        )
                        .expand()
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
