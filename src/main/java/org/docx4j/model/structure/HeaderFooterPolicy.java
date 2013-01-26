package org.docx4j.model.structure;

/*
 * Inspired/converted from org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy,
 *  which
 *  
 *  ====================================================================
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==================================================================== */


import java.util.List;

import org.docx4j.openpackaging.parts.Part;
import org.docx4j.openpackaging.parts.WordprocessingML.FooterPart;
import org.docx4j.openpackaging.parts.WordprocessingML.HeaderPart;
import org.docx4j.openpackaging.parts.relationships.RelationshipsPart;
import org.docx4j.wml.BooleanDefaultTrue;
import org.docx4j.wml.CTRel;
import org.docx4j.wml.FooterReference;
import org.docx4j.wml.HdrFtrRef;
import org.docx4j.wml.HeaderReference;
import org.docx4j.wml.SectPr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeaderFooterPolicy {

	protected static Logger log = LoggerFactory.getLogger(HeaderFooterPolicy.class);	
	
	private HeaderPart firstHeaderActive;
	private HeaderPart firstHeaderActual;  // Need this so it can be copied in next section, even if not used in this one
	private FooterPart firstFooterActive;
	private FooterPart firstFooterActual;
	
	private HeaderPart evenHeader;
	private FooterPart evenFooter;
	
	private HeaderPart defaultHeader;
	private FooterPart defaultFooter;
	
	/* "same as previous" functionality:
	 * 
	 * When "same as previous" is set, the sectPr Word emits contains 
	 * no w:headerReference at all. Absence of such implies settings 
	 * are inherited from the previous sectPr.
	 * 
	 * In the Word UI, you can change headers in either section, and
	 * see them reflected in the other.
	 * 
	 * This does not apply to a first page header.  That remains 
	 * independent! 
	 * 
	 * If you say you want no header in a sectPr, Word inserts something like:
	 * 
	 *   <w:sectPr><w:headerReference w:type="default" r:id="rId8"/>
	 *   
	 * with that w:hdr containing an empty paragraph. 
	 * 
	 * Note that "same as previous" in header behaves independently from 
	 * footer.
	 * 
	 * 
	 */
	
	private HeaderFooterPolicy() {}
	
	/**
	 * Figures out the policy for the given section,
	 *  and creates any header and footer objects
	 *  as required.
	 */
	public HeaderFooterPolicy(SectPr sectPr, HeaderFooterPolicy previousHF,
			RelationshipsPart rels) 
//		throws Exception
		{
		// Grab what headers and footers have been defined		
		if (sectPr == null) {
			log.debug("No headers/footers in this sectPr");
			return;
		}
		
		if (previousHF==null) previousHF= new HeaderFooterPolicy();
		
		List<CTRel> hdrFtrRefs = sectPr.getEGHdrFtrReferences();
		BooleanDefaultTrue titlePage = sectPr.getTitlePg();
		
		// Headers. Does this sectPr have any?
		if (hasHdrRef(hdrFtrRefs) ) {
			setHeaderReferences(hdrFtrRefs, rels, titlePage );
		} else {
			// If not, get them from previousHF
			firstHeaderActual   = previousHF.firstHeaderActual;
			if (titlePage!=null && titlePage.isVal() ) {
				firstHeaderActive   = previousHF.firstHeaderActual;
			}
			defaultHeader = previousHF.defaultHeader;
			evenHeader    =  previousHF.evenHeader; 
		}
		
		// Now, same for Footers. 
		if (hasFtrRef(hdrFtrRefs) ) {
			setFooterReferences(hdrFtrRefs, rels, titlePage );
		} else {
			// If not, get them from previousHF
			firstFooterActual   = previousHF.firstFooterActual;
			if (titlePage!=null && titlePage.isVal() ) {
				firstFooterActive   = previousHF.firstFooterActual;
			}
			defaultFooter = previousHF.defaultFooter;
			evenFooter    =  previousHF.evenFooter; 
		}
		
		/* If there is an even and odd(default) Header but only a default Footer
		 * then let the even Footer reference the default Footer.
		 * Or if there is an even and odd(default) Footer but only a default Header
		 * then let the even Header reference the default Header.
		 * In Word the headers and footers are independent, but the xslfo-structure 
		 * only knows about a simple page (with only default Header/Footers) or an 
		 * even/odd page (with an even and an odd Header and Footer).
		 */
		
		if ((evenHeader != null) && (defaultHeader != null) && (evenFooter == null)) {
			evenFooter = defaultFooter;
		}
		else if ((evenFooter != null) && (defaultFooter != null) && (evenHeader == null)) {
			evenHeader = defaultHeader;
		}
	}

	private boolean hasHdrRef(List<CTRel> hdrFtrRefs) {
		
		if (hdrFtrRefs==null) return false;
		for (CTRel rel : hdrFtrRefs) {
			if (rel instanceof HeaderReference ) return true; 
		}
		return false;
	}
	private boolean hasFtrRef(List<CTRel> hdrFtrRefs) {
		
		if (hdrFtrRefs==null) return false;
		for (CTRel rel : hdrFtrRefs) {
			if (rel instanceof FooterReference ) return true; 
		}
		return false;
	}

	private void setHeaderReferences(List<CTRel> hdrFtrRefs, RelationshipsPart rels,
			BooleanDefaultTrue titlePage) {
		
		for (CTRel rel : hdrFtrRefs) {
			String relId = rel.getId();
			log.debug("for h|f relId: " + relId);
			
			Part part = rels.getPart(relId);
			if (rel instanceof HeaderReference  ) {
				
				HeaderReference headerReference = (HeaderReference)rel;
				
				if (headerReference.getType() == HdrFtrRef.FIRST) {
					firstHeaderActual = (HeaderPart)part;
					if (titlePage!=null && titlePage.isVal()) {
						log.debug("setting first page header");
						firstHeaderActive = (HeaderPart)part;
					} 
				} else if (headerReference.getType() == HdrFtrRef.EVEN) {
					log.debug("setting even page header");
					evenHeader =  (HeaderPart)part; 
				}  else {
					log.debug("setting default page header");
					defaultHeader = (HeaderPart)part;
				}
			}
		}
	}
	
	private void setFooterReferences(List<CTRel> hdrFtrRefs, RelationshipsPart rels,
			BooleanDefaultTrue titlePage) {
		
		for (CTRel rel : hdrFtrRefs) {
			String relId = rel.getId();
			log.debug("for h|f relId: " + relId);
			
			Part part = rels.getPart(relId);
			if (rel instanceof FooterReference  ) {
				
				FooterReference footerReference = (FooterReference)rel;
				
				if (footerReference.getType() == HdrFtrRef.FIRST) {
					firstFooterActual = (FooterPart)part;
					if (titlePage!=null && titlePage.isVal()) {								
						log.debug("setting first page footer");
						firstFooterActive = (FooterPart)part;
					}
				} else if (footerReference.getType() == HdrFtrRef.EVEN) {
					log.debug("setting even page footer");
					evenFooter =  (FooterPart)part; 
				}  else {
					log.debug("setting default page footer");
					defaultFooter = (FooterPart)part;
				}
			}
		}
	}
	
	public HeaderPart getFirstHeader() {
		return firstHeaderActive;
	}
	public FooterPart getFirstFooter() {
		return firstFooterActive;
	}
	public HeaderPart getEvenHeader() {
		return evenHeader;
	}
	public FooterPart getEvenFooter() {
		return evenFooter;
	}
	/** If an even header is present this is the odd header 
	 *  otherwise it is both, even and odd header
	 */
	public HeaderPart getDefaultHeader() {
		return defaultHeader;
	}
	/** If an even footer is present this is the odd footer 
	 *  otherwise it is both, even and odd footer
	 */
	public FooterPart getDefaultFooter() {
		return defaultFooter;
	}

	/**
	 * Get the header that applies to the given
	 *  (1 based) page.
	 * @param pageNumber The one based page number
	 */
	public HeaderPart getHeader(int pageNumber) {
		if(pageNumber == 1 && firstHeaderActive != null) {
			return firstHeaderActive;
		}
		if(pageNumber % 2 == 0 && evenHeader != null) {
			return evenHeader;
		}
		return defaultHeader;
	}
	/**
	 * Get the footer that applies to the given
	 *  (1 based) page.
	 * @param pageNumber The one based page number
	 */
	public FooterPart getFooter(int pageNumber) {
		if(pageNumber == 1 && firstFooterActive != null) {
			return firstFooterActive;
		}
		if(pageNumber % 2 == 0 && evenFooter != null) {
			return evenFooter;
		}
		return defaultFooter;
	}
	
}
