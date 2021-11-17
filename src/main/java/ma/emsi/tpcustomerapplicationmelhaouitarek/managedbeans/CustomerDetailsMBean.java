/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.emsi.tpcustomerapplicationmelhaouitarek.managedbeans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import ma.emsi.tpcustomerapplicationmelhaouitarek.entities.Customer;
import ma.emsi.tpcustomerapplicationmelhaouitarek.entities.DiscountCode;
import ma.emsi.tpcustomerapplicationmelhaouitarek.session.CustomerManager;
import ma.emsi.tpcustomerapplicationmelhaouitarek.session.DiscountCodeManager;

/**
 *
 * @author Xune
 */
@Named(value = "customerDetailsMBean")
@ViewScoped
public class CustomerDetailsMBean implements Serializable {

  private int idCustomer;
  private Customer customer;
  private DiscountCode discountCode;

  @EJB
  private CustomerManager customerManager;
  
  @EJB
  private DiscountCodeManager discountCodeManager;

  public int getIdCustomer() {
    return idCustomer;
  }
  public void setIdCustomer(int idCustomer) {
    this.idCustomer = idCustomer;
  }
    public Customer getDetails() {
      return customer;
    }

  public String update() {
    customer = customerManager.update(customer);
    return "CustomerList";
  }
  public void loadCustomer() {
    this.customer = customerManager.getCustomer(idCustomer);
  }
   public List<DiscountCode> getDiscountCodes() {
    return discountCodeManager.getAllDiscountCodes();
  }
  
}

