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

import java.util.List;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;
import org.eclipse.lsp4j.util.Preconditions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Represents a reference to a command. Provides a title which will be used to represent a command in the UI and,
 * optionally, an array of arguments which will be passed to the command handler function when invoked.
 */
@SuppressWarnings("all")
public class Command {
  /**
   * Title of the command, like `save`.
   */
  @NonNull
  private String title;
  
  /**
   * The identifier of the actual command handler.
   */
  @NonNull
  private String command;
  
  /**
   * Arguments that the command handler should be invoked with.
   */
  private List<Object> arguments;
  
  public Command() {
  }
  
  public Command(@NonNull final String title, @NonNull final String command) {
    this.title = Preconditions.<String>checkNotNull(title, "title");
    this.command = Preconditions.<String>checkNotNull(command, "command");
  }
  
  public Command(@NonNull final String title, @NonNull final String command, final List<Object> arguments) {
    this(title, command);
    this.arguments = arguments;
  }
  
  /**
   * Title of the command, like `save`.
   */
  @Pure
  @NonNull
  public String getTitle() {
    return this.title;
  }
  
  /**
   * Title of the command, like `save`.
   */
  public void setTitle(@NonNull final String title) {
    this.title = Preconditions.checkNotNull(title, "title");
  }
  
  /**
   * The identifier of the actual command handler.
   */
  @Pure
  @NonNull
  public String getCommand() {
    return this.command;
  }
  
  /**
   * The identifier of the actual command handler.
   */
  public void setCommand(@NonNull final String command) {
    this.command = Preconditions.checkNotNull(command, "command");
  }
  
  /**
   * Arguments that the command handler should be invoked with.
   */
  @Pure
  public List<Object> getArguments() {
    return this.arguments;
  }
  
  /**
   * Arguments that the command handler should be invoked with.
   */
  public void setArguments(final List<Object> arguments) {
    this.arguments = arguments;
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
    Command other = (Command) obj;
    if (this.title == null) {
      if (other.title != null)
        return false;
    } else if (!this.title.equals(other.title))
      return false;
    if (this.command == null) {
      if (other.command != null)
        return false;
    } else if (!this.command.equals(other.command))
      return false;
    if (this.arguments == null) {
      if (other.arguments != null)
        return false;
    } else if (!this.arguments.equals(other.arguments))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.title== null) ? 0 : this.title.hashCode());
    result = prime * result + ((this.command== null) ? 0 : this.command.hashCode());
    return prime * result + ((this.arguments== null) ? 0 : this.arguments.hashCode());
  }
}
