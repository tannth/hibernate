package account;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import api.AccountDAO;
import api.CrudService;
import entites.Account;

/**
 * Session Bean implementation class AccountSessionBean
 */
@Stateless
/*
 * @TransactionAttribute(TransactionAttributeType.MANDATORY)
 */
public class AccountSessionBean implements AccountDAO {
	@PersistenceContext(unitName = "manager")
	private EntityManager em;

	/*
	 * @Override public <T> T find(Class type, Object id) { return (T)
	 * this.em.find(type, id); }
	 */

	@Override
	public Account findByID(String id) {
		// TODO Auto-generated method stub
		System.out.println("ID " + id);
		return this.em.find(Account.class, id);
	}

}
