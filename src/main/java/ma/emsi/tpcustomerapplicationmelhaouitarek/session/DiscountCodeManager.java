/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.emsi.tpcustomerapplicationmelhaouitarek.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ma.emsi.tpcustomerapplicationmelhaouitarek.entities.DiscountCode;

/**
 *
 * @author Xune
 */
@Stateless
public class DiscountCodeManager {
     @PersistenceContext(unitName = "discountCodePU")
    private EntityManager em;
     
       public List<DiscountCode> getAllDiscountCodes() {
        Query query = em.createNamedQuery("DiscountCode.findAll");
        return query.getResultList();
    }
         public DiscountCode update(DiscountCode discountCode) {
        return em.merge(discountCode);
    }

    public void persist(DiscountCode discountCode) {
        em.persist(discountCode);
    }

    public DiscountCode DiscountCode(int idDiscountCode) {
        return em.find(DiscountCode.class, idDiscountCode);
    }
       
}
