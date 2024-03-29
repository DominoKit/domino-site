package org.dominokit.pages.client.views.ui.samples.helpers;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_white;
import static org.dominokit.domino.ui.utils.Domino.dui_border;
import static org.dominokit.domino.ui.utils.Domino.dui_border_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_border_solid;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_h_12;
import static org.dominokit.domino.ui.utils.Domino.dui_h_fit;
import static org.dominokit.domino.ui.utils.Domino.dui_p_0;
import static org.dominokit.domino.ui.utils.Domino.dui_p_0_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_1;
import static org.dominokit.domino.ui.utils.Domino.dui_p_10;
import static org.dominokit.domino.ui.utils.Domino.dui_p_11;
import static org.dominokit.domino.ui.utils.Domino.dui_p_12;
import static org.dominokit.domino.ui.utils.Domino.dui_p_14;
import static org.dominokit.domino.ui.utils.Domino.dui_p_16;
import static org.dominokit.domino.ui.utils.Domino.dui_p_1_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_p_20;
import static org.dominokit.domino.ui.utils.Domino.dui_p_24;
import static org.dominokit.domino.ui.utils.Domino.dui_p_28;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_3;
import static org.dominokit.domino.ui.utils.Domino.dui_p_32;
import static org.dominokit.domino.ui.utils.Domino.dui_p_36;
import static org.dominokit.domino.ui.utils.Domino.dui_p_3_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_40;
import static org.dominokit.domino.ui.utils.Domino.dui_p_44;
import static org.dominokit.domino.ui.utils.Domino.dui_p_48;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_52;
import static org.dominokit.domino.ui.utils.Domino.dui_p_56;
import static org.dominokit.domino.ui.utils.Domino.dui_p_6;
import static org.dominokit.domino.ui.utils.Domino.dui_p_60;
import static org.dominokit.domino.ui.utils.Domino.dui_p_64;
import static org.dominokit.domino.ui.utils.Domino.dui_p_7;
import static org.dominokit.domino.ui.utils.Domino.dui_p_72;
import static org.dominokit.domino.ui.utils.Domino.dui_p_8;
import static org.dominokit.domino.ui.utils.Domino.dui_p_80;
import static org.dominokit.domino.ui.utils.Domino.dui_p_8px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_9;
import static org.dominokit.domino.ui.utils.Domino.dui_p_96;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_0;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_0_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_1;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_10;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_11;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_12;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_14;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_16;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_1_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_2;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_20;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_24;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_28;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_2_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_2px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_3;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_32;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_36;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_3_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_40;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_44;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_48;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_4px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_52;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_56;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_6;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_60;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_64;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_7;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_72;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_8;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_80;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_8px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_9;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_96;
import static org.dominokit.domino.ui.utils.Domino.dui_p_b_px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_0;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_0_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_1;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_10;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_11;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_12;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_14;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_16;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_1_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_2;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_20;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_24;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_28;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_2_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_2px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_3;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_32;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_36;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_3_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_40;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_44;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_48;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_4px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_52;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_56;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_6;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_60;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_64;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_7;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_72;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_8;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_80;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_8px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_9;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_96;
import static org.dominokit.domino.ui.utils.Domino.dui_p_l_px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_0;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_0_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_1;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_10;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_11;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_12;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_14;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_16;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_1_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_2;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_20;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_24;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_28;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_2_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_2px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_3;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_32;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_36;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_3_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_40;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_44;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_48;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_4px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_52;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_56;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_6;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_60;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_64;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_7;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_72;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_8;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_80;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_8px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_9;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_96;
import static org.dominokit.domino.ui.utils.Domino.dui_p_r_px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_0;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_0_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_1;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_10;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_11;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_12;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_14;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_16;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_1_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_2;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_20;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_24;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_28;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_2_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_2px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_3;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_32;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_36;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_3_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_40;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_44;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_48;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_4px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_52;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_56;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_6;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_60;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_64;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_7;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_72;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_8;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_80;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_8px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_9;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_96;
import static org.dominokit.domino.ui.utils.Domino.dui_p_t_px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_0;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_0_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_1;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_10;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_11;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_12;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_14;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_16;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_1_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_2;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_20;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_24;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_28;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_2_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_2px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_3;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_32;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_36;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_3_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_40;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_44;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_48;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_4px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_52;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_56;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_6;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_60;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_64;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_7;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_72;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_8;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_80;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_8px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_9;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_96;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_0;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_0_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_1;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_10;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_11;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_12;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_14;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_16;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_1_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_2;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_20;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_24;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_28;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_2_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_2px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_3;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_32;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_36;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_3_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_40;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_44;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_48;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_4px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_5;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_52;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_56;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_6;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_60;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_64;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_7;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_72;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_8;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_80;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_8px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_9;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_96;
import static org.dominokit.domino.ui.utils.Domino.dui_p_y_px;
import static org.dominokit.domino.ui.utils.Domino.dui_w_12;
import static org.dominokit.domino.ui.utils.Domino.dui_w_fit;
import static org.dominokit.domino.ui.utils.Domino.span;

import elemental2.dom.HTMLDivElement;
import java.util.Arrays;
import java.util.List;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class HelpersPaddingSample extends BaseDominoElement<HTMLDivElement, HelpersPaddingSample> {

    private DivElement element;

    public static HelpersPaddingSample create() {
        return new HelpersPaddingSample();
    }

    public HelpersPaddingSample() {
        List<CssClass> heightClasses = Arrays.asList(dui_p_0,
                dui_p_px,
                dui_p_2px,
                dui_p_4px,
                dui_p_8px,
                dui_p_0_5,
                dui_p_1,
                dui_p_1_5,
                dui_p_2,
                dui_p_2_5,
                dui_p_3,
                dui_p_3_5,
                dui_p_4,
                dui_p_5,
                dui_p_6,
                dui_p_7,
                dui_p_8,
                dui_p_9,
                dui_p_10,
                dui_p_11,
                dui_p_12,
                dui_p_14,
                dui_p_16,
                dui_p_20,
                dui_p_24,
                dui_p_28,
                dui_p_32,
                dui_p_36,
                dui_p_40,
                dui_p_44,
                dui_p_48,
                dui_p_52,
                dui_p_56,
                dui_p_60,
                dui_p_64,
                dui_p_72,
                dui_p_80,
                dui_p_96,

                dui_p_b_0,
                dui_p_b_px,
                dui_p_b_2px,
                dui_p_b_4px,
                dui_p_b_8px,
                dui_p_b_0_5,
                dui_p_b_1,
                dui_p_b_1_5,
                dui_p_b_2,
                dui_p_b_2_5,
                dui_p_b_3,
                dui_p_b_3_5,
                dui_p_b_4,
                dui_p_b_5,
                dui_p_b_6,
                dui_p_b_7,
                dui_p_b_8,
                dui_p_b_9,
                dui_p_b_10,
                dui_p_b_11,
                dui_p_b_12,
                dui_p_b_14,
                dui_p_b_16,
                dui_p_b_20,
                dui_p_b_24,
                dui_p_b_28,
                dui_p_b_32,
                dui_p_b_36,
                dui_p_b_40,
                dui_p_b_44,
                dui_p_b_48,
                dui_p_b_52,
                dui_p_b_56,
                dui_p_b_60,
                dui_p_b_64,
                dui_p_b_72,
                dui_p_b_80,
                dui_p_b_96,

                dui_p_l_0,
                dui_p_l_px,
                dui_p_l_2px,
                dui_p_l_4px,
                dui_p_l_8px,
                dui_p_l_0_5,
                dui_p_l_1,
                dui_p_l_1_5,
                dui_p_l_2,
                dui_p_l_2_5,
                dui_p_l_3,
                dui_p_l_3_5,
                dui_p_l_4,
                dui_p_l_5,
                dui_p_l_6,
                dui_p_l_7,
                dui_p_l_8,
                dui_p_l_9,
                dui_p_l_10,
                dui_p_l_11,
                dui_p_l_12,
                dui_p_l_14,
                dui_p_l_16,
                dui_p_l_20,
                dui_p_l_24,
                dui_p_l_28,
                dui_p_l_32,
                dui_p_l_36,
                dui_p_l_40,
                dui_p_l_44,
                dui_p_l_48,
                dui_p_l_52,
                dui_p_l_56,
                dui_p_l_60,
                dui_p_l_64,
                dui_p_l_72,
                dui_p_l_80,
                dui_p_l_96,

                dui_p_r_0,
                dui_p_r_px,
                dui_p_r_2px,
                dui_p_r_4px,
                dui_p_r_8px,
                dui_p_r_0_5,
                dui_p_r_1,
                dui_p_r_1_5,
                dui_p_r_2,
                dui_p_r_2_5,
                dui_p_r_3,
                dui_p_r_3_5,
                dui_p_r_4,
                dui_p_r_5,
                dui_p_r_6,
                dui_p_r_7,
                dui_p_r_8,
                dui_p_r_9,
                dui_p_r_10,
                dui_p_r_11,
                dui_p_r_12,
                dui_p_r_14,
                dui_p_r_16,
                dui_p_r_20,
                dui_p_r_24,
                dui_p_r_28,
                dui_p_r_32,
                dui_p_r_36,
                dui_p_r_40,
                dui_p_r_44,
                dui_p_r_48,
                dui_p_r_52,
                dui_p_r_56,
                dui_p_r_60,
                dui_p_r_64,
                dui_p_r_72,
                dui_p_r_80,
                dui_p_r_96,

                dui_p_t_0,
                dui_p_t_px,
                dui_p_t_2px,
                dui_p_t_4px,
                dui_p_t_8px,
                dui_p_t_0_5,
                dui_p_t_1,
                dui_p_t_1_5,
                dui_p_t_2,
                dui_p_t_2_5,
                dui_p_t_3,
                dui_p_t_3_5,
                dui_p_t_4,
                dui_p_t_5,
                dui_p_t_6,
                dui_p_t_7,
                dui_p_t_8,
                dui_p_t_9,
                dui_p_t_10,
                dui_p_t_11,
                dui_p_t_12,
                dui_p_t_14,
                dui_p_t_16,
                dui_p_t_20,
                dui_p_t_24,
                dui_p_t_28,
                dui_p_t_32,
                dui_p_t_36,
                dui_p_t_40,
                dui_p_t_44,
                dui_p_t_48,
                dui_p_t_52,
                dui_p_t_56,
                dui_p_t_60,
                dui_p_t_64,
                dui_p_t_72,
                dui_p_t_80,
                dui_p_t_96,

                dui_p_x_0,
                dui_p_x_px,
                dui_p_x_2px,
                dui_p_x_4px,
                dui_p_x_8px,
                dui_p_x_0_5,
                dui_p_x_1,
                dui_p_x_1_5,
                dui_p_x_2,
                dui_p_x_2_5,
                dui_p_x_3,
                dui_p_x_3_5,
                dui_p_x_4,
                dui_p_x_5,
                dui_p_x_6,
                dui_p_x_7,
                dui_p_x_8,
                dui_p_x_9,
                dui_p_x_10,
                dui_p_x_11,
                dui_p_x_12,
                dui_p_x_14,
                dui_p_x_16,
                dui_p_x_20,
                dui_p_x_24,
                dui_p_x_28,
                dui_p_x_32,
                dui_p_x_36,
                dui_p_x_40,
                dui_p_x_44,
                dui_p_x_48,
                dui_p_x_52,
                dui_p_x_56,
                dui_p_x_60,
                dui_p_x_64,
                dui_p_x_72,
                dui_p_x_80,
                dui_p_x_96,

                dui_p_y_0,
                dui_p_y_px,
                dui_p_y_2px,
                dui_p_y_4px,
                dui_p_y_8px,
                dui_p_y_0_5,
                dui_p_y_1,
                dui_p_y_1_5,
                dui_p_y_2,
                dui_p_y_2_5,
                dui_p_y_3,
                dui_p_y_3_5,
                dui_p_y_4,
                dui_p_y_5,
                dui_p_y_6,
                dui_p_y_7,
                dui_p_y_8,
                dui_p_y_9,
                dui_p_y_10,
                dui_p_y_11,
                dui_p_y_12,
                dui_p_y_14,
                dui_p_y_16,
                dui_p_y_20,
                dui_p_y_24,
                dui_p_y_28,
                dui_p_y_32,
                dui_p_y_36,
                dui_p_y_40,
                dui_p_y_44,
                dui_p_y_48,
                dui_p_y_52,
                dui_p_y_56,
                dui_p_y_60,
                dui_p_y_64,
                dui_p_y_72,
                dui_p_y_80,
                dui_p_y_96);

        this.element = div().addCss(dui_p_2)
                .appendChild(div().addCss(dui_flex, dui_gap_4, dui_flex_col)
                        .apply(self -> {
                            heightClasses.forEach(cssClass -> {
                                self
                                        .appendChild(span().textContent(cssClass.getCssClass()))
                                        .appendChild(div().addCss(dui_border, dui_border_solid, dui_border_accent, dui_bg_accent, cssClass)
                                                .addCss(dui_w_fit, dui_h_fit)
                                                .appendChild(div().addCss(dui_bg_white, dui_h_12, dui_w_12))
                                        );
                            });
                        })
                );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
