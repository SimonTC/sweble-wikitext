package org.example;

import org.sweble.wikitext.parser.nodes.WtNode;

import de.fau.cs.osr.ptk.common.AstVisitor;
import de.fau.cs.osr.ptk.common.ast.AstLocation;

public final class StripAstVisitor
		extends
			AstVisitor
{
	private boolean stripAllAttributes;
	
	private boolean stripRtdAttributes;
	
	private boolean stripLocations;
	
	// =========================================================================
	
	public StripAstVisitor(
			boolean stripAllAttributes,
			boolean stripRtdAttributes,
			boolean stripLocations)
	{
		this.stripAllAttributes = stripAllAttributes;
		this.stripRtdAttributes = stripRtdAttributes;
		this.stripLocations = stripLocations;
	}
	
	// =========================================================================
	
	public void visit(WtNode n)
	{
		if (stripAllAttributes)
		{
			n.clearAttributes();
		}
		else if (stripRtdAttributes)
		{
			n.removeAttribute("RTD");
		}
		
		if (stripLocations)
			n.setNativeLocation((AstLocation) null);
		
		iterate(n);
	}
}
