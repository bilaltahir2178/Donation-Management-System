package system;

import java.util.ArrayList;
import organization.Organization;

public class DonationManagementSystem {
    private String name;
    private ArrayList<Organization> organizations;
    
    DonationManagementSystem(String name){
        this.name=name;
        this.organizations=new ArrayList<>();
    }
    
    public void addOrganization(Organization organization){
        this.organizations.add(organization);
    }
}
