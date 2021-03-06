/*
 *
 * clim  //  Command Line Interface Menu
 *       //  https://git.zza.hu/clim
 *
 * Copyright (C) 2020-2021 Szabó László András // hu-zza
 *
 * This file is part of clim.
 *
 * clim is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * clim is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package hu.zza.clim.menu.component.ui;

import static hu.zza.clim.menu.Message.MENU_HISTORY_SEPARATOR;
import static hu.zza.clim.menu.Message.MENU_POSITION_DECORATOR;
import static hu.zza.clim.menu.Message.MENU_POSITION_SPACER;

public class HistoryHeader implements HeaderService {

  @Override
  public void printHeaderForCurrentPositionAndHistory(
      String currentPosition, String[] positionHistory) {
    String header = MENU_POSITION_DECORATOR.getMessage(currentPosition);
    String separator = MENU_HISTORY_SEPARATOR.getMessage();
    int historyToShow = 2;

    for (int i = 0; i < positionHistory.length && i < historyToShow; i++) {
      header = String.format("%s %s %s", positionHistory[i], separator, header);
    }

    System.out.print(MENU_POSITION_SPACER.getMessage(header));
  }
}
