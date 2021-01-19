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

import com.google.gson.annotations.JsonAdapter;
import org.eclipse.lsp4j.WorkDoneProgressNotification;
import org.eclipse.lsp4j.adapters.WorkDoneProgressNotificationAdapter;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;
import org.eclipse.lsp4j.util.Preconditions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * The base protocol offers also support to report progress in a generic fashion.
 * This mechanism can be used to report any kind of progress including work done progress
 * (usually used to report progress in the user interface using a progress bar)
 * and partial result progress to support streaming of results.
 * A progress notification has the following properties:
 * 
 * Since 3.15.0
 */
@SuppressWarnings("all")
public class ProgressParams {
  /**
   * The progress token provided by the client or server.
   */
  @NonNull
  private Either<String, Integer> token;
  
  /**
   * The progress data.
   */
  @NonNull
  @JsonAdapter(WorkDoneProgressNotificationAdapter.Factory.class)
  private WorkDoneProgressNotification value;
  
  public ProgressParams() {
  }
  
  public ProgressParams(@NonNull final Either<String, Integer> token, @NonNull final WorkDoneProgressNotification value) {
    this.token = Preconditions.<Either<String, Integer>>checkNotNull(token, "token");
    this.value = Preconditions.<WorkDoneProgressNotification>checkNotNull(value, "value");
  }
  
  /**
   * The progress token provided by the client or server.
   */
  @Pure
  @NonNull
  public Either<String, Integer> getToken() {
    return this.token;
  }
  
  /**
   * The progress token provided by the client or server.
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
  
  /**
   * The progress data.
   */
  @Pure
  @NonNull
  public WorkDoneProgressNotification getValue() {
    return this.value;
  }
  
  /**
   * The progress data.
   */
  public void setValue(@NonNull final WorkDoneProgressNotification value) {
    this.value = Preconditions.checkNotNull(value, "value");
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
    ProgressParams other = (ProgressParams) obj;
    if (this.token == null) {
      if (other.token != null)
        return false;
    } else if (!this.token.equals(other.token))
      return false;
    if (this.value == null) {
      if (other.value != null)
        return false;
    } else if (!this.value.equals(other.value))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.token== null) ? 0 : this.token.hashCode());
    return prime * result + ((this.value== null) ? 0 : this.value.hashCode());
  }
}
