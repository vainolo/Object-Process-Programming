/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package opm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link opm.OPMProcess#getName <em>Name</em>}</li>
 *   <li>{@link opm.OPMProcess#getOpd <em>Opd</em>}</li>
 * </ul>
 * </p>
 *
 * @see opm.OPMPackage#getOPMProcess()
 * @model
 * @generated
 */
public interface OPMProcess extends OPMThing {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see opm.OPMPackage#getOPMProcess_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link opm.OPMProcess#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Opd</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link opm.ObjectProcessDiagram#getProcesses <em>Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opd</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opd</em>' container reference.
	 * @see #setOpd(ObjectProcessDiagram)
	 * @see opm.OPMPackage#getOPMProcess_Opd()
	 * @see opm.ObjectProcessDiagram#getProcesses
	 * @model opposite="processes" transient="false"
	 * @generated
	 */
	ObjectProcessDiagram getOpd();

	/**
	 * Sets the value of the '{@link opm.OPMProcess#getOpd <em>Opd</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opd</em>' container reference.
	 * @see #getOpd()
	 * @generated
	 */
	void setOpd(ObjectProcessDiagram value);

} // OPMProcess
