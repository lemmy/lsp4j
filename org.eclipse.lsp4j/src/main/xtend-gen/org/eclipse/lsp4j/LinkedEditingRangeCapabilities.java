/**
 * Copyright (c) 2016-2018 TypeFox and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 * 
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */
package org.eclipse.lsp4j;

import org.eclipse.lsp4j.DynamicRegistrationCapabilities;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Capabilities specific to the {@code textDocument/linkedEditingRange} request.
 * 
 * Since 3.16.0
 */
@SuppressWarnings("all")
public class LinkedEditingRangeCapabilities extends DynamicRegistrationCapabilities {
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    if (!super.equals(obj))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    return super.hashCode();
  }
}
