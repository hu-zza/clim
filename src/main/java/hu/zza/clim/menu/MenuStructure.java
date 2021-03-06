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

package hu.zza.clim.menu;

import hu.zza.clim.Menu;
import java.util.HashMap;

/** Represents the structure of a {@link Menu}. */
public final class MenuStructure {

  private final HashMap<Position, MenuEntry> menu = new HashMap<>();
  private NodePosition initialPosition;
  private boolean finalized;

  public void setInitialPosition(NodePosition initialPosition) {
    if (!finalized) {
      this.initialPosition = initialPosition;
    }
  }

  /**
   * Add the specified {@link MenuEntry} to the {@link MenuStructure}. If this structure contains a
   * {@link MenuEntry} with the same {@link Position}, it is replaced.
   *
   * @param menuEntry the {@link MenuEntry} object to be add to
   * @return the previous {@link MenuEntry} if the current overrides it, or {@code null} if there
   *     was no replacement. (A {@code null} return can also indicate that the structure is
   *     finalized.)
   */
  public MenuEntry put(MenuEntry menuEntry) {
    return finalized ? null : menu.put(menuEntry.getPosition(), menuEntry);
  }

  public boolean containsKey(Position position) {
    return menu.containsKey(position);
  }

  public MenuEntry get(Position position) {
    return menu.get(position);
  }

  public boolean isFinalized() {
    return finalized;
  }

  /**
   * Sets {@link MenuStructure} finalized, so {@link MenuStructure#put} will be disabled. This
   * method sets the initial (and fallback) position too.
   */
  public void setFinalized() {
    finalized = true;
    menu.put(null, menu.get(initialPosition));
  }

  public boolean isEmpty() {
    return menu.isEmpty();
  }

  public void clear() {
    if (!finalized) {
      menu.clear();
    }
  }
}
