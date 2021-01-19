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

import java.util.ArrayList;
import java.util.List;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;
import org.eclipse.lsp4j.util.Preconditions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Whether the client supports resolving additional code action
 * properties via a separate `codeAction/resolve` request.
 * 
 * Since 3.16.0
 */
@SuppressWarnings("all")
public class CodeActionResolveSupportCapabilities {
  /**
   * The properties that a client can resolve lazily.
   */
  @NonNull
  private List<String> properties;
  
  public CodeActionResolveSupportCapabilities() {
    ArrayList<String> _arrayList = new ArrayList<String>();
    this.properties = _arrayList;
  }
  
  public CodeActionResolveSupportCapabilities(@NonNull final List<String> properties) {
    this.properties = Preconditions.<List<String>>checkNotNull(properties, "properties");
  }
  
  /**
   * The properties that a client can resolve lazily.
   */
  @Pure
  @NonNull
  public List<String> getProperties() {
    return this.properties;
  }
  
  /**
   * The properties that a client can resolve lazily.
   */
  public void setProperties(@NonNull final List<String> properties) {
    this.properties = Preconditions.checkNotNull(properties, "properties");
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CodeActionResolveSupportCapabilities other = (CodeActionResolveSupportCapabilities) obj;
    if (this.properties == null) {
      if (other.properties != null)
        return false;
    } else if (!this.properties.equals(other.properties))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    return 31 * 1 + ((this.properties== null) ? 0 : this.properties.hashCode());
  }
}
