/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.PlasticFactoryOutletTransportationOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.PlasticFactoryOutletTransportationRole.PlasticFactoryOutletTransportationJPanel;


/**
 *
 * @author pranalinarkar
 */
public class PlasticFactoryOutletTransportationRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
return new PlasticFactoryOutletTransportationJPanel(userProcessContainer, account, (PlasticFactoryOutletTransportationOrganization)organization, enterprise);     }
    
}
