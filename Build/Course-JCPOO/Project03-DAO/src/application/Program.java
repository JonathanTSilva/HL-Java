package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

    public static void main(String[] args) {
        
        Department obj = new Department(1, "Books");
        Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.00, obj);
        SellerDao sellerDao = DaoFactory.createSellerDao(); // Para instanciar um Dao, não precisa chamar o SellerDaoJDBC, mas o DaoFactory
        // Uma forma de fazer a injeção de dependência, sem explicitar a implementação
        System.out.println(seller);

    }

}
