/*
 *  Copyright 2009, Plutext Pty Ltd.
 *   
 *  This file is part of docx4j.

    docx4j is licensed under the Apache License, Version 2.0 (the "License"); 
    you may not use this file except in compliance with the License. 

    You may obtain a copy of the License at 

        http://www.apache.org/licenses/LICENSE-2.0 

    Unless required by applicable law or agreed to in writing, software 
    distributed under the License is distributed on an "AS IS" BASIS, 
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
    See the License for the specific language governing permissions and 
    limitations under the License.

 */
package org.docx4j.model.properties.paragraph;

import org.docx4j.jaxb.Context;
import org.docx4j.wml.CTBorder;
import org.docx4j.wml.PPr;
import org.docx4j.wml.PPrBase.PBdr;
import org.w3c.dom.css.CSSValue;

public class PBorderRight extends AbstractPBorder {
	
	private final static String CSS_NAME_BASE = "border-right"; 	
	public final static String FO_NAME  = "border-right";
	
	/**
	 * @since 2.7.2
	 */	
	public String getCssName() {
		return CSS_NAME_BASE;
	}
	
	public PBorderRight(CTBorder val) {
		super(val, CSS_NAME_BASE);
	}
	
	public PBorderRight(CSSValue value) {	
		super(value, CSS_NAME_BASE);
		
		// TODO
//		if (value.getCssText().toLowerCase().equals("bold")) {
//			this.setObject( Context.getWmlObjectFactory().createBooleanDefaultTrue()  );
//		} else {
//			BooleanDefaultTrue bdt = Context.getWmlObjectFactory().createBooleanDefaultTrue();
//			bdt.setVal(Boolean.FALSE);
//		}
	}

	@Override
	public String getCssProperty() {
		return super.getCssProperty();
	}
	
	@Override
	public void set(PPr pPr) {
		PBdr pBdr = pPr.getPBdr();
		if (pBdr == null) {
			pBdr = Context.getWmlObjectFactory().createPPrBasePBdr();
			pPr.setPBdr(pBdr);
		}
		pBdr.setRight((CTBorder)this.getObject() );
	}
	
}
