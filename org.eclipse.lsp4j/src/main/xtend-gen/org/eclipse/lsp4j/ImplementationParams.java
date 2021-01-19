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

import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.TextDocumentPositionAndWorkDoneProgressAndPartialResultParams;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * The go to implementation request is sent from the client to the server to resolve the implementation
 * location of a symbol at a given text document position.
 */
@SuppressWarnings("all")
public class ImplementationParams extends TextDocumentPositionAndWorkDoneProgressAndPartialResultParams {
  public ImplementationParams() {
  }
  
  public ImplementationParams(@NonNull final TextDocumentIdentifier textDocument, @NonNull final Position position) {
    super(textDocument, position);
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
