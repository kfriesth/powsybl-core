/**
 * Copyright (c) 2016, All partners of the iTesla project (http://www.itesla-project.eu/consortium)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package cim1.model;

import cim1.exc.InterpretationException;
import cim1.exc.LinkageException;
import java.util.BitSet;
import java.util.Map;
import java.util.EnumMap;
import javax.xml.stream.XMLStreamException;
import cim1.CIMURI;
import javax.xml.stream.XMLStreamWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * This file has been automatically generated by CIMGateway
 *
 * Description :
 *
 * This class "Equipment.java" represents the
 * class Equipment extends IdentifiedObject
 *    + equivalent   0..1   boolean 
 *    + MemberOf_EquipmentContainer   0..1   EquipmentContainer 

 */
public class Equipment extends IdentifiedObject {

    private static Logger LOGGER = LoggerFactory.getLogger(Equipment.class);

    /**
     * Attribute "equivalent"
     *
     * Comment from profile:
     * All classes derived from Equipment are to include this attribute except for the TransformerWinding class.     For transformers the PowerTransformer class will be used to specify the real or equivalent status and the contained TransformerWinding class instances need not and should not specify this attribute.
     */
    public boolean equivalent;

    /**
     * Attribute "memberOf_EquipmentContainer"
     *
     * Comment from profile:
     * 
     */
    public EquipmentContainer memberOf_EquipmentContainer;

    /**
     * The id of the attribute "memberOf_EquipmentContainer"
     * This id is mainly used to resolve links after parsing an instance
     */

    public String idMemberOf_EquipmentContainer;

    /**
     * The current bitset describing the state of each CIM attribute of this
     * class
     */
    private BitSet currentBitset = new BitSet();

   /**
    * The bitset describing which CIM attributes of this class have to set to
    * be consistent within a "merged" context
    */
    private final BitSet minBitset = new BitSet();

   /**
    * The Map of subset<=>bitset describing which CIM attributes of this class
    * have to set to be consistent within a specific subset context
    */
    private final Map<Subset, BitSet> minBitsets
            = new EnumMap<Subset, BitSet>(Subset.class);

    
    /**
     * Utility to return the "equivalent" value
     *
     * @return the value of the attribute "equivalent"
     */
    public boolean isEquivalent() {
        return this.equivalent;
    }

    /**
     * Utility to set the "equivalent" value
     *
     * @param equivalentValue 
     *            value to set
     */
    public void setEquivalent(boolean equivalentValue) {
        this.equivalent = equivalentValue;
        this.currentBitset.set(0);
    }

    /**
     * Utility to test if the value of "equivalent" has been set
     *
     * @return boolean
     *            if true the attribute "equivalent" is already set
     *            if false isn't yet
     */
    public boolean equivalentIsSet() {
        return this.currentBitset.get(0);
     }
    
    /**
     * Utility to return the "memberOf_EquipmentContainer"
     *
     * @return the value of the attribute "memberOf_EquipmentContainer"
     */
    public EquipmentContainer getMemberOf_EquipmentContainer() {
        return this.memberOf_EquipmentContainer;
    }

    /**
     * Utility to test if the value of "memberOf_EquipmentContainer" has been set
     *
     * @return boolean
     *            if true the attribute "memberOf_EquipmentContainer" is already set
     *            if false it isn't yet
     */
    public boolean memberOf_EquipmentContainerIsSet() {
        return this.currentBitset.get(1);
    }

    /**
     * Utility to set the "memberOf_EquipmentContainerValue"
     *
     * @param memberOf_EquipmentContainerValue
     *            instance to set
     * @param setInverse
     *            boolean to specify whether to set the inverse association
     *            or not
     * @throws LinkageException
     */
    public void setMemberOf_EquipmentContainer(
            EquipmentContainer memberOf_EquipmentContainerValue,
            boolean setInverse) throws LinkageException {
        this.memberOf_EquipmentContainer = memberOf_EquipmentContainerValue;
        this.currentBitset.set(1);
        if (setInverse) {
            
            if (memberOf_EquipmentContainerValue != null) {
                memberOf_EquipmentContainerValue.addContains_Equipments(this, false);
            }
        }
    }


    /**
     * Factory of the class
     *
     * @param id
     *            id of the class Equipment to create
     * @return the class created
     */
    public static Equipment create(final String id) {
        Equipment newEquipment = new Equipment();
        newEquipment.setId(id);
        return newEquipment;
    }

    /**
     * Utility to "clear" the content of a class when a subset is invalidated
     *
     * @param subset subset to clean
     */
    @Override
    public void clearContent(Subset subset) {

        // First of all, we clear the associations:
        this.clearAssociations(subset);


        // The function has been called by a concrete class :
        // the checking has already been done so we can clear everything !

        this.currentBitset.clear(0);
        // reset the Reference
        memberOf_EquipmentContainer = null;
        idMemberOf_EquipmentContainer = "";
        this.currentBitset.clear(1);

        super.clearContent(subset);
    }

    /**
     * Utility to read an attribute
     * This function is called by the CIMModel
     *
     * @param class_name
     *            the read name of class
     * @param attr_name
     *            the read name of attribute
     * @param value
     *            the read value of the attribute
     * @param model
     *            the interface to the model this class belongs to
     * @throws InterpretationException
     */
    @Override
    public void readAttribute(final String class_name, final String attr_name,
                              final String value, CIMModel model) throws InterpretationException {

        if (class_name.equals("Equipment")) {

        if (attr_name.equals("equivalent")) {
            boolean typedValue;
            if (!value.isEmpty()) {
                typedValue = Boolean
                        .parseBoolean(value);

                if (!value.equalsIgnoreCase("true")&&!value.equalsIgnoreCase("false")) {
                    StringBuilder warnMessage
                            = new StringBuilder("The boolean attribute \"");
                    warnMessage.append(attr_name);
                    warnMessage.append("\" in class \"");
                    warnMessage.append("Equipment");
                    warnMessage.append("whose field is equal to ");
                    warnMessage.append(value);
                    warnMessage.append(" has been interpreted as : false");
                    LOGGER.warn(warnMessage.toString());
                }

            } else {
                StringBuilder errorMessage
                        = new StringBuilder("The field of boolean");
                errorMessage
                        .append(" in Equipment was found empty ");
                LOGGER.error(errorMessage.toString());
                throw new InterpretationException(errorMessage.toString());
            }
            this.setEquivalent(typedValue);
            return;
        }
            StringBuilder errorMessage = new StringBuilder("The attribute \"");
            errorMessage.append(attr_name);
            errorMessage.append("\" in class \"");
            errorMessage.append(class_name);
            errorMessage.append("\" could not be found in the model !");
            throw new InterpretationException(errorMessage.toString());
        } else {
            super.readAttribute(class_name, attr_name, value, model);
        }
    }

    /**
     * Utility to read a reference to a resource
     * This function is called by the CIMModel
     *
     * @param class_name
     *            the read name of class
     * @param resource_name
     *            the read name of the associated resource
     * @param id
     *            the id of the associated resource
     * @param model
     *            the model this class belongs to
     * @throws InterpretationException
     */
    @Override
    public void readResource(final String class_name,
            final String resource_name, final String id, CIMModel model)
            throws InterpretationException, LinkageException {
        if (class_name.equals("Equipment")) {
        if (resource_name.equals("MemberOf_EquipmentContainer")) {
            idMemberOf_EquipmentContainer = id.substring(1);

            if (!super.isAddedToUnresolved()) {
                model.addUnresolved();
                super.addToUnresolved();
            }
        }
        } else {
            super.readResource(class_name, resource_name, id, model);
        }
    }

    /**
     * Utility to write the content into the CIM XML format
     *
     * @param writeID
     *            specifies whether to write the XML "id" attribute (this is used for describing concrete class)
     * @param xmlsw
     *            XMLStreamWriter where are stored the elements to write
     */
    @Override
    public void write(XMLStreamWriter xmlsw, boolean writeID) {

        /*
         * In previous versions, we used to check the consistency
         * of the instance in the context but this task is now
         * performed by the model before attempting to write.
         * Therefore each instance can now be written even if
         * it is not consistent !
         */

        writeClass(xmlsw);
        super.write(xmlsw, false);
        return;
    }

    /**
     * Utility to write the content this class into the CIM/XML format according
     * to a subset
     *
     * @param subset
     *            the subset defining the context in which to write this class
     * @param writeID
     *            specifies whether to write the XML "id" attribute (this is used for describing concrete class)
     * @param xmlsw
     *            the stream in which are stored the elements to write
     */
    @Override
    public void write(XMLStreamWriter xmlsw, final Subset subset,
            boolean writeID) {

        /*
         * In previous versions, we used to check the consistency
         * of the instance in the context but this task is now
         * performed by the model before attempting to write.
         * Therefore each instance can now be written even if
         * it is not consistent !
         */

        // abstract class
        writeClass(xmlsw);
        super.write(xmlsw, subset, false);
        return;
    }

    /**
     * Utility to resolve the links at the end of parsing
     *
     * @param model
     *            the model this class belongs to
     * @param boundaryModel
     *            the model that gather data about the boundarySet, used
     *            as a resource force links resolving
     * @throws Linkage Exception
     */
    @Override
    public void resolveLinks(CIMModel model, CIMModel boundaryModel) throws LinkageException {
        if (idMemberOf_EquipmentContainer != null) {
            EquipmentContainer attributeToSet =
                    model.searchEquipmentContainer
                    (idMemberOf_EquipmentContainer);

            if (attributeToSet != null) {
                boolean setInverse = true;

                try {
                    this.setMemberOf_EquipmentContainer(attributeToSet, setInverse);
                } catch(LinkageException e) {
                   LOGGER.error(e.toString(), e);
                    throw new LinkageException(e.getMessage());
                }
            } else if (boundaryModel != null) {
                EquipmentContainer attributeToSetFromBoundary = boundaryModel.searchEquipmentContainer(idMemberOf_EquipmentContainer);
                if(attributeToSetFromBoundary != null) {
                    attributeToSetFromBoundary.setFromBoundary(true);
                    boolean setInverse = true;
                    try {
                        this.setMemberOf_EquipmentContainer(attributeToSetFromBoundary, setInverse);
                    } catch(LinkageException e) {
                       LOGGER.error(e.toString(), e);
                        throw new LinkageException(e.getMessage());
                    }
                    attributeToSetFromBoundary.resolveLinks(model, boundaryModel);
                } else {
                    StringBuilder errorMessage = new StringBuilder(
                            "Could not find the reference to object of type \"EquipmentContainer\" and id \"");
                    errorMessage.append(idMemberOf_EquipmentContainer);
                    errorMessage.append("\" in \"Equipment\" of id \"");
                    errorMessage.append(this.getId());
                    errorMessage.append("\" !");
                    throw new LinkageException(errorMessage.toString());
                }
            } else {
                StringBuilder errorMessage = new StringBuilder(
                        "Could not find the reference to object of type \"EquipmentContainer\" and id \"");
                errorMessage.append(idMemberOf_EquipmentContainer);
                errorMessage.append("\" in \"Equipment\" of id \"");
                errorMessage.append(this.getId());
                errorMessage.append("\" !");
                throw new LinkageException(errorMessage.toString());
            }
        }


        super.resolveLinks(model, boundaryModel);
        removeFromUnresolved();
    }

    /**
     * Utility to check whether this class is consistent according to a subset
     *
     * @param subset
     *            the subset defining the context in which to check whether this class is consistent
     * @return a ConsistencyCheck instance whose boolean attribute (consistent)
     *         indicates if this class is consistent and whose String attribute
     *         (message)
     *         indicates why this class is not consistent if it is not
     */
    @Override
    public ConsistencyCheck modelConsistency(final Subset subset) {
        BitSet intersection = new BitSet(this.minBitsets.get(subset).length());
        intersection.or(this.minBitsets.get(subset));
        // we create a copy of minBitsets.get(subset)
        intersection.and(this.currentBitset);
        boolean consistent = (this.minBitsets.get(subset).equals(intersection));
        StringBuilder message = new StringBuilder("");

        if (!consistent) {
            message.append(getMessageForConsistency(this.minBitsets.get(subset)));
        }
        // consistent = (super.modelConsistency().getLeft()) ? (consistent &&
        // (true)):(consistent && (false))
        // message.append((super.modelConsistency(subset)).getRight());

        if (super.modelConsistency().isConsistent()) {
            consistent = consistent && (true);
            message.append((super.modelConsistency(subset)).getMessage());
        } else {
            consistent = consistent && (false);
            message.append((super.modelConsistency(subset)).getMessage());
        }

        return new ConsistencyCheck(consistent, message.toString());
    }

    /**
     * Utility to check whether this class is consistent in a "merged" context
     *
     * @return a ConsistencyCheck instance whose boolean attribute (consistent)
     *         indicates if this class is consistent and whose String attribute
     *         (message)
     *         indicates why this class is not consistent if it is not
     */
    @Override
    public ConsistencyCheck modelConsistency() {
        BitSet intersection = new BitSet(this.minBitset.length());
        intersection.or(this.minBitset);
        // we create a copy of minBitSet
        intersection.and(this.currentBitset);
        boolean consistent = (this.minBitset.equals(intersection));
        StringBuilder message = new StringBuilder("");

        if (!consistent) {
        message.append(getMessageForConsistency(this.minBitset));
        }
        // consistent = (super.modelConsistency().getLeft()) ? (consistent &&
        // (true)):(consistent && (false))
        // message += (super.modelConsistency(subset)).getRight();

        if (super.modelConsistency().isConsistent()) {
            consistent = consistent && (true);
            message.append((super.modelConsistency()).getMessage());
        } else {
            consistent = consistent && (false);
            message.append((super.modelConsistency()).getMessage());
        }

        return new ConsistencyCheck(consistent, message.toString());
    }

    /**
     * Utility to copy the "base" of an other instance of the same class
     * This utility does not copy the associations with other instances from
     * the instance to copy
     *
     * @param otherEquipment
     *            the instance to copy
     */
    public void copyBase(final Equipment otherEquipment) {
        boolean newequivalent;
        // assigning primitive type :
        if (otherEquipment.currentBitset.get(0)) {
            newequivalent = otherEquipment.isEquivalent();
            this.setEquivalent(newequivalent);
          }

        // Memory allocation has done successfully !
        // Dropping "old" objects...
        // This part may change : we do nothing to allow the user to access
        // object by their id from the global model.

        if (otherEquipment.currentBitset.get(1)) {
            EquipmentContainer memberOf_EquipmentContainerAssociation = otherEquipment.getMemberOf_EquipmentContainer();

            //this.idMemberOf_EquipmentContainer = (memberOf_EquipmentContainerAssociation != null) ? memberOf_EquipmentContainerAssociation.getId() : "";
            if (memberOf_EquipmentContainerAssociation != null) {
                this.idMemberOf_EquipmentContainer = memberOf_EquipmentContainerAssociation.getId();
                // the proper bit will be set when the setter is called
            } else {
                this.idMemberOf_EquipmentContainer = "";
            }
        }

        // TODO : Call the parent copy constructor instead ?
        super.copyBase(otherEquipment);

    }

    /**
     * Utility to return the content of this class into the CIM XML format
     *
     * @param xmlsw
     *            the stream in which are stored the elements to write
     */
    private void writeClass(XMLStreamWriter xmlsw) {

        if (currentBitset.get(0)) {

        try {
            // xmlsw.writeCharacters("\t");
            xmlsw.writeStartElement(CIMURI.CIMURI,
                    "Equipment.equivalent");
            xmlsw.writeCharacters(String.valueOf(isEquivalent()));
            xmlsw.writeEndElement();
            // xmlsw.writeCharacters("\n");
        } catch(XMLStreamException e) {
            StringBuilder errorMessage = new StringBuilder(
                    "Error while trying to write the value of the attribute ");
            errorMessage.append("Equivalent");
            errorMessage.append(" in class ");
            errorMessage.append("Equipment ");
            errorMessage.append("which ID has been initialized to : ");
            errorMessage.append(getId());
            LOGGER.error(errorMessage.toString());
            LOGGER.error(e.toString(), e);
        }
        }

        if (currentBitset.get(1)) {
        if (idMemberOf_EquipmentContainer != null) {
            try {
                // xmlsw.writeCharacters("\t");
                xmlsw.writeEmptyElement(CIMURI.CIMURI,
                        "Equipment.MemberOf_EquipmentContainer");
                xmlsw.writeAttribute(CIMModel.rdfURI, "resource", "#"
                        + idMemberOf_EquipmentContainer);
                // xmlsw.writeCharacters("\n");
            } catch(XMLStreamException e) {
                StringBuilder errorMessage = new StringBuilder(
                        "Error while trying to write the resource attribute ");
                errorMessage.append("MemberOf_EquipmentContainer");
                errorMessage.append(" in class ");
                errorMessage.append("Equipment ");
                errorMessage.append("which ID has been initialized to : ");
                errorMessage.append(getId());
                LOGGER.error(errorMessage.toString());
                LOGGER.error(e.toString(), e);
            }
        }
        }

        return;
    }

    /**
     * Utility in charge of creating the message when the class is not
     * consistent within a specific context
     *
     * @param minBitset
     *            bitset describing which CIM attributes of this class have
     *            to be set so that it is consistent within a
     *            specific subset context
     * @return the message explaining what is not consistent
     */
    private String getMessageForConsistency(final BitSet minBitset) {

        StringBuilder message = new StringBuilder(
                "Instance of \"Equipment\" of id \"");
        message.append(this.getId());
        message.append("\" is not consistent in this context:\n");
        /*
         * XOR and then AND
         * The result is :
         * "1" : has not been set and need to be
         * "0" : has been set or is not mandatory
         */

        BitSet isNotSet = new BitSet(minBitset.length());
        isNotSet.or(minBitset);
        // we create a copy of minBitset
        isNotSet.xor(this.currentBitset);
        isNotSet.and(minBitset);

        if (isNotSet.get(0)) {
            message.append("\t\"equivalent\" needs to be set\n");
        }

        if (isNotSet.get(1)) {
            message.append("\t\"MemberOf_EquipmentContainer\" needs to be set\n");
        }
        return message.toString();
    }

    /**
     * Copy constructor
     * The associations with other objects are not copied
     *
     * @param Equipment
     *            the reference to the class to copy
     * @return the class constructed
     */
    private Equipment(final Equipment otherEquipment) {
        // TODO : check exception safe
        this.copyBase(otherEquipment);
    }

   /**
    * Constructor of the class Equipment
    */
    protected Equipment() {

         // This class is not "concrete" : it is not supposed to be instanciated directly
         // subset is not set : it will be set by subclass
        // attribute "equivalent" is optional :
        this.minBitset.clear(0);
        // attribute "MemberOf_EquipmentContainer" is optional :
        this.minBitset.clear(1);
        // every subset has the same minsubset :
        this.minBitsets.put(Subset.StateVariables, this.minBitset);
        // every subset has the same minsubset :
        this.minBitsets.put(Subset.Topology, this.minBitset);
        // every subset has the same minsubset :
        this.minBitsets.put(Subset.Equipment, this.minBitset);
    }



    /**
     * Utility to clear the associations of this class belonging to a
     * specific subset
     *
     * @param subset
     *            the subset from which to clear the associations of this class
     */
    @Override
    protected void clearAssociations(final Subset subset) {

        switch (subset) {
            case StateVariables: {
                super.clearAssociations(subset);
                break;
            }
            case Topology: {
                super.clearAssociations(subset);
                break;
            }
            case Equipment: {
                super.clearAssociations(subset);
                break;
            }
            default: // nothing to clear
        }
    }

    /**
     * Utility returning a copy of the "base" of this instance
     * This utility does not copy the associations with other instances
     *
     * @return a clone of this instance
     */
    public Equipment clone() {
        Equipment newInstance = new Equipment(this);
        Equipment newInstanceSP = newInstance;
        return newInstanceSP;
    }

}


