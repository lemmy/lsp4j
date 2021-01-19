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

import org.eclipse.lsp4j.FormattingOptions;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.TextDocumentPositionParams;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;
import org.eclipse.lsp4j.util.Preconditions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * The document on type formatting request is sent from the client to the server to format parts of the document during typing.
 */
@SuppressWarnings("all")
public class DocumentOnTypeFormattingParams extends TextDocumentPositionParams {
  /**
   * The format options
   */
  @NonNull
  private FormattingOptions options;
  
  /**
   * The character that has been typed.
   */
  @NonNull
  private String ch;
  
  public DocumentOnTypeFormattingParams() {
  }
  
  public DocumentOnTypeFormattingParams(@NonNull final TextDocumentIdentifier textDocument, @NonNull final FormattingOptions options, @NonNull final Position position, @NonNull final String ch) {
    super(textDocument, position);
    this.options = Preconditions.<FormattingOptions>checkNotNull(options, "options");
    this.ch = Preconditions.<String>checkNotNull(ch, "ch");
  }
  
  @Deprecated
  public DocumentOnTypeFormattingParams(@NonNull final Position position, @NonNull final String ch) {
    super.setPosition(position);
    this.ch = Preconditions.<String>checkNotNull(ch, "ch");
  }
  
  /**
   * The format options
   */
  @Pure
  @NonNull
  public FormattingOptions getOptions() {
    return this.options;
  }
  
  /**
   * The format options
   */
  public void setOptions(@NonNull final FormattingOptions options) {
    this.options = Preconditions.checkNotNull(options, "options");
  }
  
  /**
   * The character that has been typed.
   */
  @Pure
  @NonNull
  public String getCh() {
    return this.ch;
  }
  
  /**
   * The character that has been typed.
   */
  public void setCh(@NonNull final String ch) {
    this.ch = Preconditions.checkNotNull(ch, "ch");
  }
  
  @Override
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("options", this.options);
    b.add("ch", this.ch);
    b.add("textDocument", getTextDocument());
    b.add("uri", getUri());
    b.add("position", getPosition());
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
    if (!super.equals(obj))
      return false;
    DocumentOnTypeFormattingParams other = (DocumentOnTypeFormattingParams) obj;
    if (this.options == null) {
      if (other.options != null)
        return false;
    } else if (!this.options.equals(other.options))
      return false;
    if (this.ch == null) {
      if (other.ch != null)
        return false;
    } else if (!this.ch.equals(other.ch))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.options== null) ? 0 : this.options.hashCode());
    return prime * result + ((this.ch== null) ? 0 : this.ch.hashCode());
  }
}
