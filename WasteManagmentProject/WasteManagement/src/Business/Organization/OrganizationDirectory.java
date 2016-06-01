/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.GarbageCollectionManager.getValue())){
            organization = new GarbageCollectionManagerOrganization();
            organizationList.add(organization);
        }
       else if (type.getValue().equals(Type.GarbageCollector.getValue())){
            organization = new GarbageCollectorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.MetalTransportationSerive.getValue())){
            organization = new MetalTransportationOrganization();
            organizationList.add(organization);
        }
        
        else if (type.getValue().equals(Type.MetalRecyclingService.getValue())){
            organization = new MetalRecyclingOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.PlasticTransportationService.getValue())){
            organization = new PlasticTransportationOrganization();
            organizationList.add(organization);
        }
        
        else if (type.getValue().equals(Type.PlasticRecyclingService.getValue())){
            organization = new PlasticRecyclingOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.BioTransportationService.getValue())){
            organization = new BioTransportationOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.BioRecyclingService.getValue())){
            organization = new BioRecyclingOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.BioDegradableFactoryOutletTransportationService.getValue())){
            organization = new BioDegradableFactoryOutletTransportationOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.MetalFactoryOutletTransportationService.getValue())){
            organization = new MetalFactoryOutletTransortationOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.PlasticFactoryOutletTransportationService.getValue())){
            organization = new PlasticFactoryOutletTransportationOrganization();
            organizationList.add(organization);
        }
        return organization;
       
    }
    
    
    public boolean checkIfOrgIsUnique(Type orgType){
       Organization res = null;
       for(Organization org : organizationList){
            if(org.getName().equals(orgType.getValue())){
                res = org;
                return false;
            }
       }
      // res = new Organization(type);
       return true;
     }
}