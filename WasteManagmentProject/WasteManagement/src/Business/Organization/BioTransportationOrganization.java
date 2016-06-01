/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.BioRecyclingServiceRole;
import Business.Role.BioTransportationServiceRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author pranalinarkar
 */
public class BioTransportationOrganization extends Organization {

    public BioTransportationOrganization() {
        super(Organization.Type.BioTransportationService.getValue());
    }

    @Override
   public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new BioTransportationServiceRole());
        return roles;
    }
    
}
