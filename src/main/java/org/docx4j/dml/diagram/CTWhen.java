/*
 *  Copyright 2007-2008, Plutext Pty Ltd.
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


package org.docx4j.dml.diagram;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

import org.docx4j.dml.CTOfficeArtExtensionList;


/**
 * <p>Java class for CT_When complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CT_When">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="alg" type="{http://schemas.openxmlformats.org/drawingml/2006/diagram}CT_Algorithm" minOccurs="0"/>
 *         &lt;element name="shape" type="{http://schemas.openxmlformats.org/drawingml/2006/diagram}CT_Shape" minOccurs="0"/>
 *         &lt;element name="presOf" type="{http://schemas.openxmlformats.org/drawingml/2006/diagram}CT_PresentationOf" minOccurs="0"/>
 *         &lt;element name="constrLst" type="{http://schemas.openxmlformats.org/drawingml/2006/diagram}CT_Constraints" minOccurs="0"/>
 *         &lt;element name="ruleLst" type="{http://schemas.openxmlformats.org/drawingml/2006/diagram}CT_Rules" minOccurs="0"/>
 *         &lt;element name="forEach" type="{http://schemas.openxmlformats.org/drawingml/2006/diagram}CT_ForEach"/>
 *         &lt;element name="layoutNode" type="{http://schemas.openxmlformats.org/drawingml/2006/diagram}CT_LayoutNode"/>
 *         &lt;element name="choose" type="{http://schemas.openxmlformats.org/drawingml/2006/diagram}CT_Choose"/>
 *         &lt;element name="extLst" type="{http://schemas.openxmlformats.org/drawingml/2006/main}CT_OfficeArtExtensionList" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attGroup ref="{http://schemas.openxmlformats.org/drawingml/2006/diagram}AG_IteratorAttributes"/>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" default="" />
 *       &lt;attribute name="func" use="required" type="{http://schemas.openxmlformats.org/drawingml/2006/diagram}ST_FunctionType" />
 *       &lt;attribute name="arg" type="{http://schemas.openxmlformats.org/drawingml/2006/diagram}ST_FunctionArgument" default="none" />
 *       &lt;attribute name="op" use="required" type="{http://schemas.openxmlformats.org/drawingml/2006/diagram}ST_FunctionOperator" />
 *       &lt;attribute name="val" use="required" type="{http://schemas.openxmlformats.org/drawingml/2006/diagram}ST_FunctionValue" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_When", propOrder = {
    "algOrShapeOrPresOf"
})
public class CTWhen {

    @XmlElements({
        @XmlElement(name = "constrLst", type = CTConstraints.class),
        @XmlElement(name = "forEach", type = CTForEach.class),
        @XmlElement(name = "shape", type = CTShape.class),
        @XmlElement(name = "extLst", type = CTOfficeArtExtensionList.class),
        @XmlElement(name = "layoutNode", type = CTLayoutNode.class),
        @XmlElement(name = "choose", type = CTChoose.class),
        @XmlElement(name = "alg", type = CTAlgorithm.class),
        @XmlElement(name = "ruleLst", type = CTRules.class),
        @XmlElement(name = "presOf", type = CTPresentationOf.class)
    })
    protected List<Object> algOrShapeOrPresOf;
    @XmlAttribute
    protected String name;
    @XmlAttribute(required = true)
    protected STFunctionType func;
    @XmlAttribute
    protected String arg;
    @XmlAttribute(required = true)
    protected STFunctionOperator op;
    @XmlAttribute(required = true)
    protected String val;
    @XmlAttribute
    protected List<STAxisType> axis;
    @XmlAttribute
    protected List<STElementType> ptType;
    @XmlAttribute
    protected List<Boolean> hideLastTrans;
    @XmlAttribute
    protected List<Integer> st;
    @XmlAttribute
    protected List<Long> cnt;
    @XmlAttribute
    protected List<Integer> step;

    /**
     * Gets the value of the algOrShapeOrPresOf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the algOrShapeOrPresOf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlgOrShapeOrPresOf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CTConstraints }
     * {@link CTForEach }
     * {@link CTShape }
     * {@link CTOfficeArtExtensionList }
     * {@link CTLayoutNode }
     * {@link CTChoose }
     * {@link CTAlgorithm }
     * {@link CTRules }
     * {@link CTPresentationOf }
     * 
     * 
     */
    public List<Object> getAlgOrShapeOrPresOf() {
        if (algOrShapeOrPresOf == null) {
            algOrShapeOrPresOf = new ArrayList<Object>();
        }
        return this.algOrShapeOrPresOf;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        if (name == null) {
            return "";
        } else {
            return name;
        }
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the func property.
     * 
     * @return
     *     possible object is
     *     {@link STFunctionType }
     *     
     */
    public STFunctionType getFunc() {
        return func;
    }

    /**
     * Sets the value of the func property.
     * 
     * @param value
     *     allowed object is
     *     {@link STFunctionType }
     *     
     */
    public void setFunc(STFunctionType value) {
        this.func = value;
    }

    /**
     * Gets the value of the arg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArg() {
        if (arg == null) {
            return "none";
        } else {
            return arg;
        }
    }

    /**
     * Sets the value of the arg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArg(String value) {
        this.arg = value;
    }

    /**
     * Gets the value of the op property.
     * 
     * @return
     *     possible object is
     *     {@link STFunctionOperator }
     *     
     */
    public STFunctionOperator getOp() {
        return op;
    }

    /**
     * Sets the value of the op property.
     * 
     * @param value
     *     allowed object is
     *     {@link STFunctionOperator }
     *     
     */
    public void setOp(STFunctionOperator value) {
        this.op = value;
    }

    /**
     * Gets the value of the val property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVal() {
        return val;
    }

    /**
     * Sets the value of the val property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVal(String value) {
        this.val = value;
    }

    /**
     * Gets the value of the axis property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the axis property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAxis().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link STAxisType }
     * 
     * 
     */
    public List<STAxisType> getAxis() {
        if (axis == null) {
            axis = new ArrayList<STAxisType>();
        }
        return this.axis;
    }

    /**
     * Gets the value of the ptType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ptType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPtType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link STElementType }
     * 
     * 
     */
    public List<STElementType> getPtType() {
        if (ptType == null) {
            ptType = new ArrayList<STElementType>();
        }
        return this.ptType;
    }

    /**
     * Gets the value of the hideLastTrans property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hideLastTrans property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHideLastTrans().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Boolean }
     * 
     * 
     */
    public List<Boolean> getHideLastTrans() {
        if (hideLastTrans == null) {
            hideLastTrans = new ArrayList<Boolean>();
        }
        return this.hideLastTrans;
    }

    /**
     * Gets the value of the st property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the st property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getSt() {
        if (st == null) {
            st = new ArrayList<Integer>();
        }
        return this.st;
    }

    /**
     * Gets the value of the cnt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cnt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCnt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getCnt() {
        if (cnt == null) {
            cnt = new ArrayList<Long>();
        }
        return this.cnt;
    }

    /**
     * Gets the value of the step property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the step property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStep().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getStep() {
        if (step == null) {
            step = new ArrayList<Integer>();
        }
        return this.step;
    }

}
