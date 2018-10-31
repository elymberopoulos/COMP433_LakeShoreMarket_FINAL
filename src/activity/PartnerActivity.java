package activity;

import representations.PartnerRepresentation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import serviceUsers.Partner;
import databaseConnector.BookManagerFacade;
import databaseConnector.PartnerManagerFacade;


public class PartnerActivity {
	private static PartnerManagerFacade manager = new PartnerManagerFacade();
	
	public Set<PartnerRepresentation> getPartner() {
		
		List<Partner> partners = new ArrayList<Partner>();
		Set<PartnerRepresentation> partnerRepresentations = new HashSet<PartnerRepresentation>();
		//employees = dao.getAllEmployees();
		partners = manager.getPartner();
		
		Iterator<Partner> it = partners.iterator();
		while(it.hasNext()) {
          Partner targetPartner = (Partner)it.next();
          PartnerRepresentation partnerRepresentation = new PartnerRepresentation();
          partnerRepresentation.setUserID(targetPartner.getUserID());
          partnerRepresentation.setFirstName(targetPartner.getFirstName());
          partnerRepresentation.setLastName(targetPartner.getLastName());
          
          //now add this representation in the list
          partnerRepresentations.add(partnerRepresentation);
        }
		return partnerRepresentations;
	}
	
	public PartnerRepresentation getSpecificPartner(String id) {
        PartnerRepresentation partnerRepresentation = new PartnerRepresentation();

		//Employee emp = dao.getEmployee(id);
		List<Partner> partner = manager.getPartner();
		for(Partner targetPartner: partner){
			if(id == targetPartner.getUserID()){
		          partnerRepresentation.setUserID(targetPartner.getUserID());
		          partnerRepresentation.setFirstName(targetPartner.getFirstName());
		          partnerRepresentation.setLastName(targetPartner.getLastName());
								
			}
		}
		return partnerRepresentation;
		
	}
	
	public PartnerRepresentation createPartner(String firstName, String lastName, String companyName, String address,
			int phoneNumber, String email, int numberOfOrders, String userID, int bankAccountNumber) {
		
		Partner partner = manager.postPartner(firstName, lastName, companyName, address, phoneNumber, email, numberOfOrders, userID, bankAccountNumber);
		
		PartnerRepresentation partnerRepresentation = new PartnerRepresentation();
		partnerRepresentation.setFirstName(partner.getFirstName());
		partnerRepresentation.setLastName(partner.getLastName());
		partnerRepresentation.setUserID(partner.getUserID());
		partnerRepresentation.setCompanyName(partner.getCompanyName());
		partnerRepresentation.setAddress(partner.getAddress());
		partnerRepresentation.setPhoneNumber(partner.getPhoneNumber());
		partnerRepresentation.setEmail(partner.getEmail());
		partnerRepresentation.setNumberOfOrders(partner.getNumberOfOrders());
		partnerRepresentation.setBankAccountNumber(partner.getBankAccountNumber());

		
		
		return partnerRepresentation;
	}
	
	public String deletePartner(String id) {
		
		//dao.deleteEmployee(id);
		manager.deletePartner(id);
		
		return "OK";
	}

	public PartnerRepresentation getPartner(String id) {
		PartnerRepresentation partnerRepresentation = new PartnerRepresentation();
		for(Partner partner: manager.getPartner()){
			if(partner.getUserID() == id){
				partnerRepresentation.setFirstName(partner.getFirstName());
				partnerRepresentation.setLastName(partner.getLastName());
				partnerRepresentation.setUserID(partner.getUserID());
				partnerRepresentation.setCompanyName(partner.getCompanyName());
				partnerRepresentation.setAddress(partner.getAddress());
				partnerRepresentation.setPhoneNumber(partner.getPhoneNumber());
				partnerRepresentation.setEmail(partner.getEmail());
				partnerRepresentation.setNumberOfOrders(partner.getNumberOfOrders());
				partnerRepresentation.setBankAccountNumber(partner.getBankAccountNumber());
			}
		}
		return partnerRepresentation;
	}
}
