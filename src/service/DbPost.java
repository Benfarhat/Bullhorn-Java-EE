package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Bhpost;
import model.Bhuser;

public class DbPost {

	public static void insert(Bhpost bhPost) {
		EntityManager em = DbUtil.getEntityManager("Bullhorn");
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(bhPost);
			trans.commit();
		} catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}
	

	public static void update(Bhpost bhPost) {
		EntityManager em = DbUtil.getEntityManager("Bullhorn");
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(bhPost);
			trans.commit();
		} catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}
	

	public static void delete(Bhpost bhPost) {
		EntityManager em = DbUtil.getEntityManager("Bullhorn");
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(bhPost));
			trans.commit();
		} catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static List<Bhpost> bhPost(){
		EntityManager em = DbUtil.getEntityManager("Bullhorn");
		String qString = "Select u from Bhpost u";
		List<Bhpost> posts = null;
		
		try {
			TypedQuery<Bhpost> q = em.createQuery(qString, Bhpost.class);
			posts = q.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return posts;
	}	
	
	
	public static List<Bhpost> postOfUser(long userid){
		EntityManager em = DbUtil.getEntityManager("Bullhorn");
		String qString = "Select u from Bhpost u where u.bhuser.bhuserid =: userid";
		List<Bhpost> userposts = null;
		
		try {
			TypedQuery<Bhpost> q = em.createQuery(qString, Bhpost.class);
			q.setParameter("userid", userid);
			userposts = q.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return userposts;
	}
	
	
	
	public static List<Bhpost> postOfUser(String email){
		EntityManager em = DbUtil.getEntityManager("Bullhorn");
		String qString = "Select u from Bhpost u where u.bhuser.useremail =: email";
		List<Bhpost> userposts = null;
		
		try {
			TypedQuery<Bhpost> q = em.createQuery(qString, Bhpost.class);
			q.setParameter("email", email);
			userposts = q.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return userposts;
	}	
	
	
	public static List<Bhpost> searchPosts(String search){
		EntityManager em = DbUtil.getEntityManager("Bullhorn");
		String qString = "Select u from Bhpost u where u.posttext like =: search";
		List<Bhpost> posts = null;
		
		try {
			TypedQuery<Bhpost> q = em.createQuery(qString, Bhpost.class);
			q.setParameter("search", "%" + search + "%");
			posts = q.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return posts;
	}
	
}
