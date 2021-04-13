package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class SellerService {

	private SellerDao dao = DaoFactory.createSellerDao();

	public List<Seller> findAll() {
		return dao.findAll(); // busca no BD os departamento
	}

	//_________Verifica se tem algo no Seller___________
	public void saveOrUpdate(Seller obj) {
		if (obj.getId() == null) {
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}
	}
	//_________Remove um dep do BD_________
	public void remove(Seller obj) {
		dao.deleteById(obj.getId());
	}
}
