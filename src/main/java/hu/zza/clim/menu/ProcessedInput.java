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

import hu.zza.clim.parameter.Parameter;
import hu.zza.clim.parameter.ParameterName;
import java.util.HashMap;
import java.util.Map;

public final class ProcessedInput {

  public static final ProcessedInput NULL = new ProcessedInput(null);
  private final Position position;
  private final Map<ParameterName, Parameter> parameterMap = new HashMap<>();

  public ProcessedInput(Position position) {
    this.position = position;
  }

  public Position getPosition() {
    return position;
  }

  public void putParameter(ParameterName parameterName, Parameter parameter) {
    parameterMap.put(parameterName, parameter);
  }

  public boolean containsParameter(ParameterName parameterName) {
    return parameterMap.containsKey(parameterName);
  }

  public Parameter getParameter(ParameterName parameterName) {
    return parameterMap.getOrDefault(parameterName, Parameter.NULL);
  }
}
