/*
 * Copyright (C) 2017 skydoves
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home;

import android.content.Context;

import androidx.appcompat.view.ContextThemeWrapper;
import androidx.lifecycle.LifecycleOwner;

import com.justforentrepreneurs.j4eapp.R;
import com.poup.newpowemenu.MenuAnimation;
import com.poup.newpowemenu.OnMenuItemClickListener;
import com.poup.newpowemenu.PowerMenu;
import com.poup.newpowemenu.PowerMenuItem;

public class PowerMenuUtils {

    public static PowerMenu getIconPowerMenu(Context context, LifecycleOwner lifecycleOwner,
                                             OnMenuItemClickListener<PowerMenuItem> onMenuItemClickListener) {

        Context styledContext = new ContextThemeWrapper(context, R.style.PopupCardThemeOverlay);

        return new PowerMenu.Builder(styledContext)
                .addItem(new PowerMenuItem("Create Requirement", R.drawable.ic_plus_sign))
                .addItem(new PowerMenuItem("Create Event", R.drawable.ic_plus_sign))
                .addItem(new PowerMenuItem("Create Post", R.drawable.ic_plus_sign))
                .addItem(new PowerMenuItem("Create Deal & Discount", R.drawable.ic_plus_sign))
                .addItem(new PowerMenuItem(context.getResources().getString(R.string.create_buddy_meet), R.drawable.ic_plus_sign))
                .addItem(new PowerMenuItem(context.getResources().getString(R.string.create_offline), R.drawable.ic_plus_sign))
                .addItem(new PowerMenuItem("Create Referral",R.drawable.ic_plus_sign))
                .setLifecycleOwner(lifecycleOwner)
                .setIconSize(25)
                .setWidth(900)
                .setPadding(10)
                .setOnMenuItemClickListener(onMenuItemClickListener)
                .setAnimation(MenuAnimation.FADE)
                .setMenuRadius(context.getResources().getDimensionPixelSize(R.dimen.menu_corner_radius))
                .setMenuShadow(context.getResources().getDimensionPixelSize(R.dimen.menu_elevation))
                .setIsMaterial(true)
                .build();
    }

    public static PowerMenu getIconPowerMenu2(Context context, LifecycleOwner lifecycleOwner,
                                             OnMenuItemClickListener<PowerMenuItem> onMenuItemClickListener) {

        Context styledContext = new ContextThemeWrapper(context, R.style.PopupCardThemeOverlay);

        return new PowerMenu.Builder(styledContext)
                .addItem(new PowerMenuItem("Create Requirement", R.drawable.ic_plus_sign))
                .addItem(new PowerMenuItem("Create Post", R.drawable.ic_plus_sign))
                .addItem(new PowerMenuItem("Create Deal & Discount", R.drawable.ic_plus_sign))
                .addItem(new PowerMenuItem(context.getResources().getString(R.string.create_buddy_meet), R.drawable.ic_plus_sign))
                .addItem(new PowerMenuItem(context.getResources().getString(R.string.create_offline), R.drawable.ic_plus_sign))
                .addItem(new PowerMenuItem("Create Referral",R.drawable.ic_plus_sign))
                .setLifecycleOwner(lifecycleOwner)
                .setIconSize(25)
                .setWidth(900)
                .setPadding(10)
                .setOnMenuItemClickListener(onMenuItemClickListener)
                .setAnimation(MenuAnimation.FADE)
                .setMenuRadius(context.getResources().getDimensionPixelSize(R.dimen.menu_corner_radius))
                .setMenuShadow(context.getResources().getDimensionPixelSize(R.dimen.menu_elevation))
                .setIsMaterial(true)
                .build();
    }
}
