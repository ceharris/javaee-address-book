package ceh.demo.repository;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ceh.demo.Contact;

@ApplicationScoped
public class JpaContactRepository implements ContactRepository {

  @PersistenceContext
  private EntityManager entityManager;
  
  @Override
  public void add(Contact contact) {
    entityManager.persist(contact);
  }

  @Override
  public Collection<Contact> findAll() {
    TypedQuery<Contact> query = entityManager.createNamedQuery(
        "findAllContacts", Contact.class);
    return query.getResultList();
  }

}
