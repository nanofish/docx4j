/*
 *  Copyright 2010-2012, Plutext Pty Ltd.
 *   
 *  This file is part of pptx4j, a component of docx4j.

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
package org.pptx4j.pml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.docx4j.dml.CTColorMapping;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cSld" type="{http://schemas.openxmlformats.org/presentationml/2006/main}CT_CommonSlideData"/>
 *         &lt;group ref="{http://schemas.openxmlformats.org/presentationml/2006/main}EG_TopLevelSlide"/>
 *         &lt;element name="hf" type="{http://schemas.openxmlformats.org/presentationml/2006/main}CT_HeaderFooter" minOccurs="0"/>
 *         &lt;element name="extLst" type="{http://schemas.openxmlformats.org/presentationml/2006/main}CT_ExtensionListModify" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cSld",
    "clrMap",
    "hf",
    "extLst"
})
@XmlRootElement(name = "handoutMaster")
public class HandoutMaster {

    @XmlElement(required = true)
    protected CommonSlideData cSld;
    @XmlElement(required = true)
    protected CTColorMapping clrMap;
    protected CTHeaderFooter hf;
    protected CTExtensionListModify extLst;

    /**
     * Gets the value of the cSld property.
     * 
     * @return
     *     possible object is
     *     {@link CommonSlideData }
     *     
     */
    public CommonSlideData getCSld() {
        return cSld;
    }

    /**
     * Sets the value of the cSld property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommonSlideData }
     *     
     */
    public void setCSld(CommonSlideData value) {
        this.cSld = value;
    }

    /**
     * Gets the value of the clrMap property.
     * 
     * @return
     *     possible object is
     *     {@link CTColorMapping }
     *     
     */
    public CTColorMapping getClrMap() {
        return clrMap;
    }

    /**
     * Sets the value of the clrMap property.
     * 
     * @param value
     *     allowed object is
     *     {@link CTColorMapping }
     *     
     */
    public void setClrMap(CTColorMapping value) {
        this.clrMap = value;
    }

    /**
     * Gets the value of the hf property.
     * 
     * @return
     *     possible object is
     *     {@link CTHeaderFooter }
     *     
     */
    public CTHeaderFooter getHf() {
        return hf;
    }

    /**
     * Sets the value of the hf property.
     * 
     * @param value
     *     allowed object is
     *     {@link CTHeaderFooter }
     *     
     */
    public void setHf(CTHeaderFooter value) {
        this.hf = value;
    }

    /**
     * Gets the value of the extLst property.
     * 
     * @return
     *     possible object is
     *     {@link CTExtensionListModify }
     *     
     */
    public CTExtensionListModify getExtLst() {
        return extLst;
    }

    /**
     * Sets the value of the extLst property.
     * 
     * @param value
     *     allowed object is
     *     {@link CTExtensionListModify }
     *     
     */
    public void setExtLst(CTExtensionListModify value) {
        this.extLst = value;
    }

}
