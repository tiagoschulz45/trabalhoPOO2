
import dataservices.dao.JPAUtil;
import dataservices.dao.SerieDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.Genero;
import model.Serie;


/**
 *
 * @author Tiago
 */
public class Teste {
        public static void main(String[] args) {
            
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        Serie s = new Serie("LOST",Genero.ACAO,10);
        
        
        SerieDAO dao = new SerieDAO();
        dao.save(s);
        
        System.out.println("testando");
        
    }
}
