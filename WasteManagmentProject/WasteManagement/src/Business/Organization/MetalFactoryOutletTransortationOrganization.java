/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.MetalFactoryOutletTransportationRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author pranalinarkar
 */
public class MetalFactoryOutletTransortationOrganization extends Organization{

    public MetalFactoryOutletTransortationOrganization() {
        super(Organization.Type.MetalFactoryOutletTransportationService.getValue());
    }

    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new MetalFactoryOutletTransportationRole());
        return roles;
    }
    
}
