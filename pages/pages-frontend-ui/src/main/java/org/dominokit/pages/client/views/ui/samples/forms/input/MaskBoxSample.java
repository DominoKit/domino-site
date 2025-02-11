package org.dominokit.pages.client.views.ui.samples.forms.input;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.pro.domino.ui.inputmask.*;

import static org.dominokit.domino.ui.utils.Domino.*;

public class MaskBoxSample extends BaseDominoElement<HTMLDivElement, MaskBoxSample> {

    private DivElement element;

    public static MaskBoxSample create() {
        return new MaskBoxSample();
    }

    public MaskBoxSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(BlockHeader.create("Basic masking"))
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(BlockHeader.create("Numbers mask"))
                                .appendChild(new MaskBox("####")
                                        .setHelperText("#### : Accept only digits.")
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(BlockHeader.create("Letters mask"))
                                .appendChild(new MaskBox("AAAA")
                                        .setHelperText("AAAA : Accepts letters only.")
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(BlockHeader.create("Numbers and Letters mask"))
                                .appendChild(new MaskBox("###AAAA")
                                        .setHelperText("###AAAA : 3 digits followed by 4 letters")
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(BlockHeader.create("Number or Letter"))
                                .appendChild(new MaskBox("####AA??")
                                        .setHelperText("####AA?? : 2 digits then 2 letters then 2 mix digits/letters")
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(BlockHeader.create("Fixed characters"))
                                .appendChild(new MaskBox("(####)")
                                        .setHelperText("(###) : The () are fixed")
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(BlockHeader.create("Fixed characters"))
                                .appendChild(new MaskBox("(AA)-####.##")
                                        .setHelperText("(AA)-####.## : The ()-. are all fixed characters")
                                )
                        )
                )
                .appendChild(BlockHeader.create("Use different characters for the mask"))
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(BlockHeader.create("Number or Letter"))
                                .appendChild(new MaskBox("(NNNN)-*-LLLNNN.NNN", MaskOptions.create()
                                                .addMaskCharacter(new MaskChar('N', '_', MaskType.DIGIT))
                                                .addMaskCharacter(new MaskChar('L', '_', MaskType.LETTER))
                                                .addMaskCharacter(new MaskChar('*', '_', MaskType.DIGIT_LETTER))
                                        )
                                                .setHelperText("(NNNN)-*-LLLNNN.NNN : Use different chars for the mask")
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(BlockHeader.create("Custom placeholders"))
                                .appendChild(new MaskBox("(####)-AA**.##", MaskOptions.create()
                                                .addMaskCharacter(new MaskChar('#', '#', MaskType.DIGIT))
                                                .addMaskCharacter(new MaskChar('A', 'C', MaskType.LETTER))
                                                .addMaskCharacter(new MaskChar('*', '?', MaskType.DIGIT_LETTER))
                                        )
                                                .setHelperText("Use different mask placeholders")
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(BlockHeader.create("Different masks and placeholders"))
                                .appendChild(new MaskBox("(AA)-NNN.N*", MaskOptions.create()
                                        .addMaskCharacter(new MaskChar('N', '#', MaskType.DIGIT))
                                        .addMaskCharacter(new MaskChar('A', 'C', MaskType.LETTER))
                                        .addMaskCharacter(new MaskChar('*', '?', MaskType.DIGIT_LETTER)))
                                        .setHelperText("(AA)-NNN.N* : You customize the masks and the placeholders")
                                )
                        )
                )
                .appendChild(BlockHeader.create("Navigation, home/end keys, Copy/Paste, delete and backspace support"))
                .appendChild(Row.create()
                        .apply(self -> {
                            DivElement maskedValue = div();
                            DivElement unmaskedValue = div();
                            self
                                    .appendChild(Column.span4()
                                            .appendChild(BlockHeader.create("No fixed letters included"))
                                            .appendChild(new MaskBox("(####)-AAA-###.##?")
                                                    .setHelperText("(####)-AAA-###.##? : Try to navigate and use copy paste features")
                                                    .apply(box -> {
                                                        box.addChangeListener((oldValue, newValue) -> {
                                                            maskedValue.setTextContent(box.getMaskedValue());
                                                            unmaskedValue.setTextContent(box.getUnmaskedValue());
                                                        });
                                                    })
                                            )
                                    )
                                    .appendChild(Column.span4()
                                            .appendChild(BlockHeader.create("Masked value"))
                                            .appendChild(maskedValue)
                                    )
                                    .appendChild(Column.span4()
                                            .appendChild(BlockHeader.create("Unmasked value"))
                                            .appendChild(unmaskedValue)
                                    )
                            ;
                        })

                )
                .appendChild(Row.create()
                        .apply(self -> {
                            DivElement maskedValue = div();
                            DivElement unmaskedValue = div();
                            self
                                    .appendChild(Column.span4()
                                            .appendChild(BlockHeader.create("Programmatically include fixed letters"))
                                            .appendChild(new MaskBox("(####)-AAA/###.##?", MaskOptions.createDefault()
                                                            .setIncludeFixedChars(true)
                                                            .setIncludedFixedChars('.', '/')
                                                    )
                                                            .setHelperText("(####)-AAA/###.##? : . and / will be included in the value")
                                                            .apply(box -> {
                                                                box.addChangeListener((oldValue, newValue) -> {
                                                                    maskedValue.setTextContent(box.getMaskedValue());
                                                                    unmaskedValue.setTextContent(box.getUnmaskedValue());
                                                                });
                                                            })
                                            )
                                    )
                                    .appendChild(Column.span4()
                                            .appendChild(BlockHeader.create("Masked value"))
                                            .appendChild(maskedValue)
                                    )
                                    .appendChild(Column.span4()
                                            .appendChild(BlockHeader.create("Unmasked value"))
                                            .appendChild(unmaskedValue)
                                    )
                            ;
                        })

                )
                .appendChild(Row.create()
                        .apply(self -> {
                            DivElement maskedValue = div();
                            DivElement unmaskedValue = div();
                            self
                                    .appendChild(Column.span4()
                                            .appendChild(BlockHeader.create("Use expression pattern to include fixed characters"))
                                            .appendChild(new MaskBox("(####)-AAA{/}###{.}##?")
                                                    .setHelperText("(####)-AAA/###.##? : . and / included, - not included")
                                                    .apply(box -> {
                                                        box.addChangeListener((oldValue, newValue) -> {
                                                            maskedValue.setTextContent(box.getMaskedValue());
                                                            unmaskedValue.setTextContent(box.getUnmaskedValue());
                                                        });
                                                    })
                                            )
                                    )
                                    .appendChild(Column.span4()
                                            .appendChild(BlockHeader.create("Masked value"))
                                            .appendChild(maskedValue)
                                    )
                                    .appendChild(Column.span4()
                                            .appendChild(BlockHeader.create("Unmasked value"))
                                            .appendChild(unmaskedValue)
                                    )
                            ;
                        })

                )
                .appendChild(Row.create()
                        .apply(self -> {
                            DivElement maskedValue = div();
                            DivElement unmaskedValue = div();
                            self
                                    .appendChild(Column.span4()
                                            .appendChild(BlockHeader.create("Use expression pattern to specify digits range e.g : {#:0-5}#{.}{#:01}{A:LMN}"))
                                            .appendChild(new MaskBox("{#:0-5}#{.}{#:01}{A:LMN}")
                                                    .setHelperText("allowed range {#:0257} or {#:0,2,5,7} allowed digits/letters")
                                                    .apply(box -> {
                                                        box.addChangeListener((oldValue, newValue) -> {
                                                            maskedValue.setTextContent(box.getMaskedValue());
                                                            unmaskedValue.setTextContent(box.getUnmaskedValue());
                                                        });
                                                    })
                                            )
                                    )
                                    .appendChild(Column.span4()
                                            .appendChild(BlockHeader.create("Masked value"))
                                            .appendChild(maskedValue)
                                    )
                                    .appendChild(Column.span4()
                                            .appendChild(BlockHeader.create("Unmasked value"))
                                            .appendChild(unmaskedValue)
                                    )
                            ;
                        })

                )
                .appendChild(Row.create().span12(BlockHeader.create("Try your own mask, use # for digits, A for letters and ? for digits and letters")))
                .appendChild(Row.create()
                        .apply(self -> {
                            DivElement maskedValue = div();
                            DivElement unmaskedValue = div();
                            MaskBox maskBox = new MaskBox("AA##.##?")
                                    .apply(b -> {
                                        b.addChangeListener((oldValue, newValue) -> {
                                            maskedValue.setTextContent(b.getMaskedValue());
                                            unmaskedValue.setTextContent(b.getUnmaskedValue());
                                        });
                                    });
                            self
                                    .appendChild(Column.span3()

                                            .appendChild(TextBox.create()
                                                    .apply(textBox -> {
                                                        textBox
                                                                .withValue("AA##.##?")
                                                                .appendChild(PostfixAddOn.of(Button.create("Apply").addClickListener(evt -> {
                                                                    maskBox.setMask(textBox.getValue());
                                                                })));
                                                    })
                                            )
                                    )
                                    .appendChild(Column.span3().appendChild(maskBox))
                                    .appendChild(Column.span3()
                                            .appendChild(BlockHeader.create("Masked value"))
                                            .appendChild(maskedValue)
                                    )
                                    .appendChild(Column.span3()
                                            .appendChild(BlockHeader.create("Unmasked value"))
                                            .appendChild(unmaskedValue)
                                    )
                            ;
                        })

                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
