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
import org.eclipse.lsp4j.CompletionItemInsertTextModeSupportCapabilities;
import org.eclipse.lsp4j.CompletionItemResolveSupportCapabilities;
import org.eclipse.lsp4j.CompletionItemTagSupportCapabilities;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * The client supports the following `CompletionItem` specific capabilities.
 */
@SuppressWarnings("all")
public class CompletionItemCapabilities {
  /**
   * Client supports snippets as insert text.
   * 
   * A snippet can define tab stops and placeholders with `$1`, `$2`
   * and `${3:foo}`. `$0` defines the final tab stop, it defaults to
   * the end of the snippet. Placeholders with equal identifiers are linked,
   * that is typing in one will update others too.
   */
  private Boolean snippetSupport;
  
  /**
   * Client supports commit characters on a completion item.
   */
  private Boolean commitCharactersSupport;
  
  /**
   * Client supports the following content formats for the documentation
   * property. The order describes the preferred format of the client.
   */
  private List<String> documentationFormat;
  
  /**
   * Client supports the deprecated property on a completion item.
   */
  private Boolean deprecatedSupport;
  
  /**
   * Client supports the preselect property on a completion item.
   */
  private Boolean preselectSupport;
  
  /**
   * Client supports the tag property on a completion item. Clients supporting
   * tags have to handle unknown tags gracefully. Clients especially need to
   * preserve unknown tags when sending a completion item back to the server in
   * a resolve call.
   * 
   * Since 3.15.0
   */
  private CompletionItemTagSupportCapabilities tagSupport;
  
  /**
   * Client support insert replace edit to control different behavior if a
   * completion item is inserted in the text or should replace text.
   * 
   * Since 3.16.0
   */
  private Boolean insertReplaceSupport;
  
  /**
   * Indicates which properties a client can resolve lazily on a completion
   * item. Before version 3.16.0 only the predefined properties `documentation`
   * and `details` could be resolved lazily.
   * 
   * Since 3.16.0
   */
  private CompletionItemResolveSupportCapabilities resolveSupport;
  
  /**
   * The client supports the {@link CompletionItem#insertTextMode} property on
   * a completion item to override the whitespace handling mode
   * as defined by the client.
   * 
   * Since 3.16.0
   */
  private CompletionItemInsertTextModeSupportCapabilities insertTextModeSupport;
  
  public CompletionItemCapabilities() {
  }
  
  public CompletionItemCapabilities(final Boolean snippetSupport) {
    this.snippetSupport = snippetSupport;
  }
  
  /**
   * Client supports snippets as insert text.
   * 
   * A snippet can define tab stops and placeholders with `$1`, `$2`
   * and `${3:foo}`. `$0` defines the final tab stop, it defaults to
   * the end of the snippet. Placeholders with equal identifiers are linked,
   * that is typing in one will update others too.
   */
  @Pure
  public Boolean getSnippetSupport() {
    return this.snippetSupport;
  }
  
  /**
   * Client supports snippets as insert text.
   * 
   * A snippet can define tab stops and placeholders with `$1`, `$2`
   * and `${3:foo}`. `$0` defines the final tab stop, it defaults to
   * the end of the snippet. Placeholders with equal identifiers are linked,
   * that is typing in one will update others too.
   */
  public void setSnippetSupport(final Boolean snippetSupport) {
    this.snippetSupport = snippetSupport;
  }
  
  /**
   * Client supports commit characters on a completion item.
   */
  @Pure
  public Boolean getCommitCharactersSupport() {
    return this.commitCharactersSupport;
  }
  
  /**
   * Client supports commit characters on a completion item.
   */
  public void setCommitCharactersSupport(final Boolean commitCharactersSupport) {
    this.commitCharactersSupport = commitCharactersSupport;
  }
  
  /**
   * Client supports the following content formats for the documentation
   * property. The order describes the preferred format of the client.
   */
  @Pure
  public List<String> getDocumentationFormat() {
    return this.documentationFormat;
  }
  
  /**
   * Client supports the following content formats for the documentation
   * property. The order describes the preferred format of the client.
   */
  public void setDocumentationFormat(final List<String> documentationFormat) {
    this.documentationFormat = documentationFormat;
  }
  
  /**
   * Client supports the deprecated property on a completion item.
   */
  @Pure
  public Boolean getDeprecatedSupport() {
    return this.deprecatedSupport;
  }
  
  /**
   * Client supports the deprecated property on a completion item.
   */
  public void setDeprecatedSupport(final Boolean deprecatedSupport) {
    this.deprecatedSupport = deprecatedSupport;
  }
  
  /**
   * Client supports the preselect property on a completion item.
   */
  @Pure
  public Boolean getPreselectSupport() {
    return this.preselectSupport;
  }
  
  /**
   * Client supports the preselect property on a completion item.
   */
  public void setPreselectSupport(final Boolean preselectSupport) {
    this.preselectSupport = preselectSupport;
  }
  
  /**
   * Client supports the tag property on a completion item. Clients supporting
   * tags have to handle unknown tags gracefully. Clients especially need to
   * preserve unknown tags when sending a completion item back to the server in
   * a resolve call.
   * 
   * Since 3.15.0
   */
  @Pure
  public CompletionItemTagSupportCapabilities getTagSupport() {
    return this.tagSupport;
  }
  
  /**
   * Client supports the tag property on a completion item. Clients supporting
   * tags have to handle unknown tags gracefully. Clients especially need to
   * preserve unknown tags when sending a completion item back to the server in
   * a resolve call.
   * 
   * Since 3.15.0
   */
  public void setTagSupport(final CompletionItemTagSupportCapabilities tagSupport) {
    this.tagSupport = tagSupport;
  }
  
  /**
   * Client support insert replace edit to control different behavior if a
   * completion item is inserted in the text or should replace text.
   * 
   * Since 3.16.0
   */
  @Pure
  public Boolean getInsertReplaceSupport() {
    return this.insertReplaceSupport;
  }
  
  /**
   * Client support insert replace edit to control different behavior if a
   * completion item is inserted in the text or should replace text.
   * 
   * Since 3.16.0
   */
  public void setInsertReplaceSupport(final Boolean insertReplaceSupport) {
    this.insertReplaceSupport = insertReplaceSupport;
  }
  
  /**
   * Indicates which properties a client can resolve lazily on a completion
   * item. Before version 3.16.0 only the predefined properties `documentation`
   * and `details` could be resolved lazily.
   * 
   * Since 3.16.0
   */
  @Pure
  public CompletionItemResolveSupportCapabilities getResolveSupport() {
    return this.resolveSupport;
  }
  
  /**
   * Indicates which properties a client can resolve lazily on a completion
   * item. Before version 3.16.0 only the predefined properties `documentation`
   * and `details` could be resolved lazily.
   * 
   * Since 3.16.0
   */
  public void setResolveSupport(final CompletionItemResolveSupportCapabilities resolveSupport) {
    this.resolveSupport = resolveSupport;
  }
  
  /**
   * The client supports the {@link CompletionItem#insertTextMode} property on
   * a completion item to override the whitespace handling mode
   * as defined by the client.
   * 
   * Since 3.16.0
   */
  @Pure
  public CompletionItemInsertTextModeSupportCapabilities getInsertTextModeSupport() {
    return this.insertTextModeSupport;
  }
  
  /**
   * The client supports the {@link CompletionItem#insertTextMode} property on
   * a completion item to override the whitespace handling mode
   * as defined by the client.
   * 
   * Since 3.16.0
   */
  public void setInsertTextModeSupport(final CompletionItemInsertTextModeSupportCapabilities insertTextModeSupport) {
    this.insertTextModeSupport = insertTextModeSupport;
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
    CompletionItemCapabilities other = (CompletionItemCapabilities) obj;
    if (this.snippetSupport == null) {
      if (other.snippetSupport != null)
        return false;
    } else if (!this.snippetSupport.equals(other.snippetSupport))
      return false;
    if (this.commitCharactersSupport == null) {
      if (other.commitCharactersSupport != null)
        return false;
    } else if (!this.commitCharactersSupport.equals(other.commitCharactersSupport))
      return false;
    if (this.documentationFormat == null) {
      if (other.documentationFormat != null)
        return false;
    } else if (!this.documentationFormat.equals(other.documentationFormat))
      return false;
    if (this.deprecatedSupport == null) {
      if (other.deprecatedSupport != null)
        return false;
    } else if (!this.deprecatedSupport.equals(other.deprecatedSupport))
      return false;
    if (this.preselectSupport == null) {
      if (other.preselectSupport != null)
        return false;
    } else if (!this.preselectSupport.equals(other.preselectSupport))
      return false;
    if (this.tagSupport == null) {
      if (other.tagSupport != null)
        return false;
    } else if (!this.tagSupport.equals(other.tagSupport))
      return false;
    if (this.insertReplaceSupport == null) {
      if (other.insertReplaceSupport != null)
        return false;
    } else if (!this.insertReplaceSupport.equals(other.insertReplaceSupport))
      return false;
    if (this.resolveSupport == null) {
      if (other.resolveSupport != null)
        return false;
    } else if (!this.resolveSupport.equals(other.resolveSupport))
      return false;
    if (this.insertTextModeSupport == null) {
      if (other.insertTextModeSupport != null)
        return false;
    } else if (!this.insertTextModeSupport.equals(other.insertTextModeSupport))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.snippetSupport== null) ? 0 : this.snippetSupport.hashCode());
    result = prime * result + ((this.commitCharactersSupport== null) ? 0 : this.commitCharactersSupport.hashCode());
    result = prime * result + ((this.documentationFormat== null) ? 0 : this.documentationFormat.hashCode());
    result = prime * result + ((this.deprecatedSupport== null) ? 0 : this.deprecatedSupport.hashCode());
    result = prime * result + ((this.preselectSupport== null) ? 0 : this.preselectSupport.hashCode());
    result = prime * result + ((this.tagSupport== null) ? 0 : this.tagSupport.hashCode());
    result = prime * result + ((this.insertReplaceSupport== null) ? 0 : this.insertReplaceSupport.hashCode());
    result = prime * result + ((this.resolveSupport== null) ? 0 : this.resolveSupport.hashCode());
    return prime * result + ((this.insertTextModeSupport== null) ? 0 : this.insertTextModeSupport.hashCode());
  }
}
