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
import org.eclipse.lsp4j.FileCreate;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;
import org.eclipse.lsp4j.util.Preconditions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * The parameters sent in notifications/requests for user-initiated creation
 * of files.
 * 
 * Since 3.16.0
 */
@SuppressWarnings("all")
public class CreateFilesParams {
  /**
   * An array of all files/folders created in this operation.
   */
  @NonNull
  private List<FileCreate> files = new ArrayList<FileCreate>();
  
  public CreateFilesParams() {
  }
  
  public CreateFilesParams(@NonNull final List<FileCreate> files) {
    this.files = Preconditions.<List<FileCreate>>checkNotNull(files, "files");
  }
  
  /**
   * An array of all files/folders created in this operation.
   */
  @Pure
  @NonNull
  public List<FileCreate> getFiles() {
    return this.files;
  }
  
  /**
   * An array of all files/folders created in this operation.
   */
  public void setFiles(@NonNull final List<FileCreate> files) {
    this.files = Preconditions.checkNotNull(files, "files");
  }
  
  @Override
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("files", this.files);
    return b.toString();
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
    CreateFilesParams other = (CreateFilesParams) obj;
    if (this.files == null) {
      if (other.files != null)
        return false;
    } else if (!this.files.equals(other.files))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    return 31 * 1 + ((this.files== null) ? 0 : this.files.hashCode());
  }
}
