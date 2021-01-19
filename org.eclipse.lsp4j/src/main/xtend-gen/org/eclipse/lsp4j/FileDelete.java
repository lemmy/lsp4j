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

import org.eclipse.lsp4j.jsonrpc.validation.NonNull;
import org.eclipse.lsp4j.util.Preconditions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Represents information on a file/folder delete.
 * 
 * Since 3.16.0
 */
@SuppressWarnings("all")
public class FileDelete {
  /**
   * A file:// URI for the location of the file/folder being deleted.
   */
  @NonNull
  private String uri;
  
  public FileDelete() {
  }
  
  public FileDelete(@NonNull final String uri) {
    this.uri = Preconditions.<String>checkNotNull(uri, "uri");
  }
  
  /**
   * A file:// URI for the location of the file/folder being deleted.
   */
  @Pure
  @NonNull
  public String getUri() {
    return this.uri;
  }
  
  /**
   * A file:// URI for the location of the file/folder being deleted.
   */
  public void setUri(@NonNull final String uri) {
    this.uri = Preconditions.checkNotNull(uri, "uri");
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
    FileDelete other = (FileDelete) obj;
    if (this.uri == null) {
      if (other.uri != null)
        return false;
    } else if (!this.uri.equals(other.uri))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    return 31 * 1 + ((this.uri== null) ? 0 : this.uri.hashCode());
  }
}
