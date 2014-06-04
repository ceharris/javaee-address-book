package ceh.demo.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ceh.demo.Contact;

@ApplicationScoped
public class JpaContactRepository implements ContactRepository {

  @PersistenceContext
  private EntityManager entityManager;
  
  @Override
  public void add(Contact contact) {
    entityManager.persist(contact);
  }

}
