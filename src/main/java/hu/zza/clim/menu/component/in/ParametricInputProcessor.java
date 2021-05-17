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

package hu.zza.clim.menu.component.in;

import hu.zza.clim.menu.Position;
import hu.zza.clim.menu.ProcessedInput;
import hu.zza.clim.parameter.ParameterMatcher;

public final class ParametricInputProcessor implements InputProcessorService {
  private final ParameterMatcher parameterMatcher;

  public ParametricInputProcessor(ParameterMatcher parameterMatcher) {
    this.parameterMatcher = parameterMatcher;
  }

  @Override
  public ProcessedInput process(String input, Position[] options) {
    return parameterMatcher.processText(input);
  }
}