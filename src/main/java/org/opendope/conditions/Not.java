//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.27 at 07:26:00 PM EST 
//


package org.opendope.conditions;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.CustomXmlPart;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://opendope.org/conditions}xpathref"/>
 *         &lt;element ref="{http://opendope.org/conditions}and"/>
 *         &lt;element ref="{http://opendope.org/conditions}or"/>
 *         &lt;element ref="{http://opendope.org/conditions}not"/>
 *         &lt;element ref="{http://opendope.org/conditions}conditionref"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "particle"
})
@XmlRootElement(name = "not")
public class Not implements Evaluable {

    @XmlElements({
        @XmlElement(name = "xpathref", type = Xpathref.class),
        @XmlElement(name = "and", type = And.class),
        @XmlElement(name = "or", type = Or.class),
        @XmlElement(name = "not", type = Not.class),
        @XmlElement(name = "conditionref", type = Conditionref.class)
    })
    protected Evaluable particle;

    /**
     * Gets the value of the particle property.
     * 
     * @return
     *     possible object is
     *     {@link Xpathref }
     *     {@link And }
     *     {@link Or }
     *     {@link Not }
     *     {@link Conditionref }
     *     
     */
    public Evaluable getParticle() {
        return particle;
    }

	public boolean evaluate(WordprocessingMLPackage pkg, 
			Map<String, CustomXmlPart> customXmlDataStorageParts,
			Conditions conditions,
			org.opendope.xpaths.Xpaths xPaths) {

		return !particle.evaluate(pkg, customXmlDataStorageParts, conditions, xPaths);
    }
	
	public void listXPaths( List<org.opendope.xpaths.Xpaths.Xpath> theList, 
			Conditions conditions,
			org.opendope.xpaths.Xpaths xPaths) {
		
    	particle.listXPaths(theList, conditions, xPaths);
		
	}

	public String toString(Conditions conditions,
			org.opendope.xpaths.Xpaths xPaths) {
		
		return "not(" + particle.toString(conditions, xPaths) + ")";
	}
    
    /**
     * Sets the value of the particle property.
     * 
     * @param value
     *     allowed object is
     *     {@link Xpathref }
     *     {@link And }
     *     {@link Or }
     *     {@link Not }
     *     {@link Conditionref }
     *     
     */
    public void setParticle(Evaluable value) {
        this.particle = value;
    }

	public Condition repeat(String xpathBase,
			int index,
			Conditions conditions,
			org.opendope.xpaths.Xpaths xPaths)	{

    	particle.repeat(xpathBase, index, conditions, xPaths);
		return null;
	}	
    
}
