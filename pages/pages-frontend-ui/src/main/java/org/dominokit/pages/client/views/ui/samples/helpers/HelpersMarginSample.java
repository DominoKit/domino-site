package org.dominokit.pages.client.views.ui.samples.helpers;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_border;
import static org.dominokit.domino.ui.utils.Domino.dui_border_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_border_solid;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_h_12;
import static org.dominokit.domino.ui.utils.Domino.dui_h_fit;
import static org.dominokit.domino.ui.utils.Domino.dui_m_0;
import static org.dominokit.domino.ui.utils.Domino.dui_m_0_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_1;
import static org.dominokit.domino.ui.utils.Domino.dui_m_10;
import static org.dominokit.domino.ui.utils.Domino.dui_m_11;
import static org.dominokit.domino.ui.utils.Domino.dui_m_12;
import static org.dominokit.domino.ui.utils.Domino.dui_m_14;
import static org.dominokit.domino.ui.utils.Domino.dui_m_16;
import static org.dominokit.domino.ui.utils.Domino.dui_m_1_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_2;
import static org.dominokit.domino.ui.utils.Domino.dui_m_20;
import static org.dominokit.domino.ui.utils.Domino.dui_m_24;
import static org.dominokit.domino.ui.utils.Domino.dui_m_28;
import static org.dominokit.domino.ui.utils.Domino.dui_m_2_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_2px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_3;
import static org.dominokit.domino.ui.utils.Domino.dui_m_32;
import static org.dominokit.domino.ui.utils.Domino.dui_m_36;
import static org.dominokit.domino.ui.utils.Domino.dui_m_3_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_4;
import static org.dominokit.domino.ui.utils.Domino.dui_m_40;
import static org.dominokit.domino.ui.utils.Domino.dui_m_44;
import static org.dominokit.domino.ui.utils.Domino.dui_m_48;
import static org.dominokit.domino.ui.utils.Domino.dui_m_4px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_52;
import static org.dominokit.domino.ui.utils.Domino.dui_m_56;
import static org.dominokit.domino.ui.utils.Domino.dui_m_6;
import static org.dominokit.domino.ui.utils.Domino.dui_m_60;
import static org.dominokit.domino.ui.utils.Domino.dui_m_64;
import static org.dominokit.domino.ui.utils.Domino.dui_m_7;
import static org.dominokit.domino.ui.utils.Domino.dui_m_72;
import static org.dominokit.domino.ui.utils.Domino.dui_m_8;
import static org.dominokit.domino.ui.utils.Domino.dui_m_80;
import static org.dominokit.domino.ui.utils.Domino.dui_m_8px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_9;
import static org.dominokit.domino.ui.utils.Domino.dui_m_96;
import static org.dominokit.domino.ui.utils.Domino.dui_m_auto;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_0;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_0_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_1;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_10;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_11;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_12;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_14;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_16;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_1_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_2;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_20;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_24;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_28;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_2_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_2px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_3;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_32;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_36;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_3_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_4;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_40;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_44;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_48;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_4px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_52;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_56;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_6;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_60;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_64;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_7;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_72;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_8;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_80;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_8px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_9;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_96;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_auto;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_0;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_0_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_1;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_10;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_11;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_12;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_14;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_16;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_1_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_2;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_20;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_24;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_28;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_2_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_2px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_3;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_32;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_36;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_3_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_4;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_40;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_44;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_48;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_4px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_52;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_56;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_6;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_60;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_64;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_7;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_72;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_8;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_80;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_8px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_9;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_96;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_auto;
import static org.dominokit.domino.ui.utils.Domino.dui_m_l_px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_0;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_0_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_1;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_10;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_11;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_12;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_14;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_16;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_1_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_2;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_20;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_24;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_28;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_2_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_2px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_3;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_32;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_36;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_3_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_4;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_40;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_44;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_48;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_4px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_52;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_56;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_6;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_60;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_64;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_7;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_72;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_8;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_80;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_8px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_9;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_96;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_auto;
import static org.dominokit.domino.ui.utils.Domino.dui_m_r_px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_0;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_0_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_1;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_10;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_11;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_12;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_14;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_16;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_1_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_2;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_20;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_24;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_28;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_2_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_2px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_3;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_32;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_36;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_3_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_4;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_40;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_44;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_48;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_4px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_52;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_56;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_6;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_60;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_64;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_7;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_72;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_8;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_80;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_8px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_9;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_96;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_auto;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_0;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_0_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_1;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_10;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_11;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_12;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_14;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_16;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_1_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_2;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_20;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_24;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_28;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_2_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_2px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_3;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_32;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_36;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_3_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_4;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_40;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_44;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_48;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_4px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_52;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_56;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_6;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_60;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_64;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_7;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_72;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_8;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_80;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_8px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_9;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_96;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_auto;
import static org.dominokit.domino.ui.utils.Domino.dui_m_x_px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_0;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_0_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_1;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_10;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_11;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_12;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_14;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_16;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_1_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_2;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_20;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_24;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_28;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_2_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_2px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_3;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_32;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_36;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_3_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_4;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_40;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_44;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_48;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_4px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_5;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_52;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_56;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_6;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_60;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_64;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_7;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_72;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_8;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_80;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_8px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_9;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_96;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_auto;
import static org.dominokit.domino.ui.utils.Domino.dui_m_y_px;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_w_12;
import static org.dominokit.domino.ui.utils.Domino.dui_w_fit;
import static org.dominokit.domino.ui.utils.Domino.span;

import elemental2.dom.HTMLDivElement;
import java.util.Arrays;
import java.util.List;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class HelpersMarginSample extends BaseDominoElement<HTMLDivElement, HelpersMarginSample> {

    private DivElement element;

    public static HelpersMarginSample create() {
        return new HelpersMarginSample();
    }

    public HelpersMarginSample() {
        List<CssClass> heightClasses = Arrays.asList(dui_m_0,
                dui_m_px,
                dui_m_2px,
                dui_m_4px,
                dui_m_8px,
                dui_m_0_5,
                dui_m_1,
                dui_m_1_5,
                dui_m_2,
                dui_m_2_5,
                dui_m_3,
                dui_m_3_5,
                dui_m_4,
                dui_m_5,
                dui_m_6,
                dui_m_7,
                dui_m_8,
                dui_m_9,
                dui_m_10,
                dui_m_11,
                dui_m_12,
                dui_m_14,
                dui_m_16,
                dui_m_20,
                dui_m_24,
                dui_m_28,
                dui_m_32,
                dui_m_36,
                dui_m_40,
                dui_m_44,
                dui_m_48,
                dui_m_52,
                dui_m_56,
                dui_m_60,
                dui_m_64,
                dui_m_72,
                dui_m_80,
                dui_m_96,
                dui_m_auto,

                dui_m_b_0,
                dui_m_b_px,
                dui_m_b_2px,
                dui_m_b_4px,
                dui_m_b_8px,
                dui_m_b_0_5,
                dui_m_b_1,
                dui_m_b_1_5,
                dui_m_b_2,
                dui_m_b_2_5,
                dui_m_b_3,
                dui_m_b_3_5,
                dui_m_b_4,
                dui_m_b_5,
                dui_m_b_6,
                dui_m_b_7,
                dui_m_b_8,
                dui_m_b_9,
                dui_m_b_10,
                dui_m_b_11,
                dui_m_b_12,
                dui_m_b_14,
                dui_m_b_16,
                dui_m_b_20,
                dui_m_b_24,
                dui_m_b_28,
                dui_m_b_32,
                dui_m_b_36,
                dui_m_b_40,
                dui_m_b_44,
                dui_m_b_48,
                dui_m_b_52,
                dui_m_b_56,
                dui_m_b_60,
                dui_m_b_64,
                dui_m_b_72,
                dui_m_b_80,
                dui_m_b_96,
                dui_m_b_auto,

                dui_m_l_0,
                dui_m_l_px,
                dui_m_l_2px,
                dui_m_l_4px,
                dui_m_l_8px,
                dui_m_l_0_5,
                dui_m_l_1,
                dui_m_l_1_5,
                dui_m_l_2,
                dui_m_l_2_5,
                dui_m_l_3,
                dui_m_l_3_5,
                dui_m_l_4,
                dui_m_l_5,
                dui_m_l_6,
                dui_m_l_7,
                dui_m_l_8,
                dui_m_l_9,
                dui_m_l_10,
                dui_m_l_11,
                dui_m_l_12,
                dui_m_l_14,
                dui_m_l_16,
                dui_m_l_20,
                dui_m_l_24,
                dui_m_l_28,
                dui_m_l_32,
                dui_m_l_36,
                dui_m_l_40,
                dui_m_l_44,
                dui_m_l_48,
                dui_m_l_52,
                dui_m_l_56,
                dui_m_l_60,
                dui_m_l_64,
                dui_m_l_72,
                dui_m_l_80,
                dui_m_l_96,
                dui_m_l_auto,

                dui_m_r_0,
                dui_m_r_px,
                dui_m_r_2px,
                dui_m_r_4px,
                dui_m_r_8px,
                dui_m_r_0_5,
                dui_m_r_1,
                dui_m_r_1_5,
                dui_m_r_2,
                dui_m_r_2_5,
                dui_m_r_3,
                dui_m_r_3_5,
                dui_m_r_4,
                dui_m_r_5,
                dui_m_r_6,
                dui_m_r_7,
                dui_m_r_8,
                dui_m_r_9,
                dui_m_r_10,
                dui_m_r_11,
                dui_m_r_12,
                dui_m_r_14,
                dui_m_r_16,
                dui_m_r_20,
                dui_m_r_24,
                dui_m_r_28,
                dui_m_r_32,
                dui_m_r_36,
                dui_m_r_40,
                dui_m_r_44,
                dui_m_r_48,
                dui_m_r_52,
                dui_m_r_56,
                dui_m_r_60,
                dui_m_r_64,
                dui_m_r_72,
                dui_m_r_80,
                dui_m_r_96,
                dui_m_r_auto,

                dui_m_t_0,
                dui_m_t_px,
                dui_m_t_2px,
                dui_m_t_4px,
                dui_m_t_8px,
                dui_m_t_0_5,
                dui_m_t_1,
                dui_m_t_1_5,
                dui_m_t_2,
                dui_m_t_2_5,
                dui_m_t_3,
                dui_m_t_3_5,
                dui_m_t_4,
                dui_m_t_5,
                dui_m_t_6,
                dui_m_t_7,
                dui_m_t_8,
                dui_m_t_9,
                dui_m_t_10,
                dui_m_t_11,
                dui_m_t_12,
                dui_m_t_14,
                dui_m_t_16,
                dui_m_t_20,
                dui_m_t_24,
                dui_m_t_28,
                dui_m_t_32,
                dui_m_t_36,
                dui_m_t_40,
                dui_m_t_44,
                dui_m_t_48,
                dui_m_t_52,
                dui_m_t_56,
                dui_m_t_60,
                dui_m_t_64,
                dui_m_t_72,
                dui_m_t_80,
                dui_m_t_96,
                dui_m_t_auto,

                dui_m_x_0,
                dui_m_x_px,
                dui_m_x_2px,
                dui_m_x_4px,
                dui_m_x_8px,
                dui_m_x_0_5,
                dui_m_x_1,
                dui_m_x_1_5,
                dui_m_x_2,
                dui_m_x_2_5,
                dui_m_x_3,
                dui_m_x_3_5,
                dui_m_x_4,
                dui_m_x_5,
                dui_m_x_6,
                dui_m_x_7,
                dui_m_x_8,
                dui_m_x_9,
                dui_m_x_10,
                dui_m_x_11,
                dui_m_x_12,
                dui_m_x_14,
                dui_m_x_16,
                dui_m_x_20,
                dui_m_x_24,
                dui_m_x_28,
                dui_m_x_32,
                dui_m_x_36,
                dui_m_x_40,
                dui_m_x_44,
                dui_m_x_48,
                dui_m_x_52,
                dui_m_x_56,
                dui_m_x_60,
                dui_m_x_64,
                dui_m_x_72,
                dui_m_x_80,
                dui_m_x_96,
                dui_m_x_auto,

                dui_m_y_0,
                dui_m_y_px,
                dui_m_y_2px,
                dui_m_y_4px,
                dui_m_y_8px,
                dui_m_y_0_5,
                dui_m_y_1,
                dui_m_y_1_5,
                dui_m_y_2,
                dui_m_y_2_5,
                dui_m_y_3,
                dui_m_y_3_5,
                dui_m_y_4,
                dui_m_y_5,
                dui_m_y_6,
                dui_m_y_7,
                dui_m_y_8,
                dui_m_y_9,
                dui_m_y_10,
                dui_m_y_11,
                dui_m_y_12,
                dui_m_y_14,
                dui_m_y_16,
                dui_m_y_20,
                dui_m_y_24,
                dui_m_y_28,
                dui_m_y_32,
                dui_m_y_36,
                dui_m_y_40,
                dui_m_y_44,
                dui_m_y_48,
                dui_m_y_52,
                dui_m_y_56,
                dui_m_y_60,
                dui_m_y_64,
                dui_m_y_72,
                dui_m_y_80,
                dui_m_y_96,
                dui_m_y_auto);

        this.element = div().addCss(dui_p_2)
                .appendChild(div().addCss(dui_flex, dui_gap_4, dui_flex_col)
                        .apply(self -> {
                            heightClasses.forEach(cssClass -> {
                                self
                                        .appendChild(span().textContent(cssClass.getCssClass()))
                                        .appendChild(div()
                                                .addCss(dui_border, dui_border_accent, dui_border_solid, dui_w_fit, dui_h_fit)
                                                .appendChild(div().addCss(dui_bg_accent, dui_h_12, dui_w_12, cssClass))
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
