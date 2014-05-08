package api;

import javax.ejb.Remote;

import entites.*;

@Remote
public interface AccountDAO {
	Account findByID(String id);
}
