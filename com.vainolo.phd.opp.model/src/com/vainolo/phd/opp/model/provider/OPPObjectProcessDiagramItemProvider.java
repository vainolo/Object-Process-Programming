/**
 */
package com.vainolo.phd.opp.model.provider;


import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link com.vainolo.phd.opp.model.OPPObjectProcessDiagram} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class OPPObjectProcessDiagramItemProvider extends OPPContainerItemProvider {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPObjectProcessDiagramItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
    if (itemPropertyDescriptors == null) {
      super.getPropertyDescriptors(object);

      addNamePropertyDescriptor(object);
      addAlignmentPropertyDescriptor(object);
      addLastKnownUsedIdPropertyDescriptor(object);
      addKindPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Name feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addNamePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_OPPNamedElement_name_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_OPPNamedElement_name_feature", "_UI_OPPNamedElement_type"),
         OPPPackage.Literals.OPP_NAMED_ELEMENT__NAME,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Alignment feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addAlignmentPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_OPPNamedElement_alignment_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_OPPNamedElement_alignment_feature", "_UI_OPPNamedElement_type"),
         OPPPackage.Literals.OPP_NAMED_ELEMENT__ALIGNMENT,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Last Known Used Id feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addLastKnownUsedIdPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_OPPObjectProcessDiagram_lastKnownUsedId_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_OPPObjectProcessDiagram_lastKnownUsedId_feature", "_UI_OPPObjectProcessDiagram_type"),
         OPPPackage.Literals.OPP_OBJECT_PROCESS_DIAGRAM__LAST_KNOWN_USED_ID,
         true,
         false,
         false,
         ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Kind feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addKindPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_OPPObjectProcessDiagram_kind_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_OPPObjectProcessDiagram_kind_feature", "_UI_OPPObjectProcessDiagram_type"),
         OPPPackage.Literals.OPP_OBJECT_PROCESS_DIAGRAM__KIND,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
   * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
   * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
    if (childrenFeatures == null) {
      super.getChildrenFeatures(object);
      childrenFeatures.add(OPPPackage.Literals.OPP_OBJECT_PROCESS_DIAGRAM__LINKS);
    }
    return childrenFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child) {
    // Check the type of the specified child object and return the proper feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

  /**
   * This returns OPPObjectProcessDiagram.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/OPPObjectProcessDiagram"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    String label = ((OPPObjectProcessDiagram)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_OPPObjectProcessDiagram_type") :
      getString("_UI_OPPObjectProcessDiagram_type") + " " + label;
  }
  

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification) {
    updateChildren(notification);

    switch (notification.getFeatureID(OPPObjectProcessDiagram.class)) {
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__NAME:
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__ALIGNMENT:
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__LAST_KNOWN_USED_ID:
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__KIND:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__LINKS:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
        return;
    }
    super.notifyChanged(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
   * that can be created under this object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
    super.collectNewChildDescriptors(newChildDescriptors, object);

    newChildDescriptors.add
      (createChildParameter
        (OPPPackage.Literals.OPP_OBJECT_PROCESS_DIAGRAM__LINKS,
         OPPFactory.eINSTANCE.createOPPLink()));

    newChildDescriptors.add
      (createChildParameter
        (OPPPackage.Literals.OPP_OBJECT_PROCESS_DIAGRAM__LINKS,
         OPPFactory.eINSTANCE.createOPPProceduralLink()));

    newChildDescriptors.add
      (createChildParameter
        (OPPPackage.Literals.OPP_OBJECT_PROCESS_DIAGRAM__LINKS,
         OPPFactory.eINSTANCE.createOPPStructuralLinkPart()));
  }

}
