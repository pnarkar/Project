/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.BioTransportationOrganization;
import Business.Organization.MetalRecyclingOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.BioTransportationRole.BioTransportationJPanel;

/**
 *
 * @author pranalinarkar
 */
public class BioTransportationServiceRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
       return new BioTransportationJPanel(userProcessContainer, account, (BioTransportationOrganization)organization, enterprise);
    }
    
}
