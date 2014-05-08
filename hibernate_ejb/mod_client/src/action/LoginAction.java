package action;

import javax.naming.Context;

import util.ServiceLookup;
import account.AccountSessionBean;
import api.AccountDAO;

import com.opensymphony.xwork2.ActionSupport;

import entites.Account;

public class LoginAction extends ActionSupport {
	private String id;
	private String passowrd;

	public LoginAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute() throws Exception {
		Context ctx = ServiceLookup.getInitialContext();

		String lookupName = ServiceLookup.getLookupName(
				AccountSessionBean.class.getSimpleName(),
				AccountDAO.class.getName());

		AccountDAO accountDAO = (AccountDAO) ctx.lookup(lookupName);
		System.out.println("username :" + id);
		Account a = accountDAO.findByID(id);
		if (a != null) {
			return "success";
		}
		return "fail";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassowrd() {
		return passowrd;
	}

	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}
}
