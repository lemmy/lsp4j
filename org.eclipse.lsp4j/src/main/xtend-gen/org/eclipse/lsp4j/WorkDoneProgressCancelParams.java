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

import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;
import org.eclipse.lsp4j.util.Preconditions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * The {@code window/workDoneProgress/cancel} notification is sent from the client to the server to cancel a progress initiated on the server side using the
 * {@code window/workDoneProgress/create}.
 */
@SuppressWarnings("all")
public class WorkDoneProgressCancelParams {
  /**
   * The token to be used to report progress.
   */
  @NonNull
  private Either<String, Integer> token;
  
  public WorkDoneProgressCancelParams() {
  }
  
  public WorkDoneProgressCancelParams(@NonNull final Either<String, Integer> token) {
    this.token = Preconditions.<Either<String, Integer>>checkNotNull(token, "token");
  }
  
  /**
   * The token to be used to report progress.
   */
  @Pure
  @NonNull
  public Either<String, Integer> getToken() {
    return this.token;
  }
  
  /**
   * The token to be used to report progress.
   */
  public void setToken(@NonNull final Either<String, Integer> token) {
    this.token = Preconditions.checkNotNull(token, "token");
  }
  
  public void setToken(final String token) {
    if (token == null) {
      Preconditions.checkNotNull(token, "token");
      this.token = null;
      return;
    }
    this.token = Either.forLeft(token);
  }
  
  public void setToken(final Integer token) {
    if (token == null) {
      Preconditions.checkNotNull(token, "token");
      this.token = null;
      return;
    }
    this.token = Either.forRight(token);
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
    WorkDoneProgressCancelParams other = (WorkDoneProgressCancelParams) obj;
    if (this.token == null) {
      if (other.token != null)
        return false;
    } else if (!this.token.equals(other.token))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    return 31 * 1 + ((this.token== null) ? 0 : this.token.hashCode());
  }
}
