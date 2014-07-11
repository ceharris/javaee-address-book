package ceh.demo.repository;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ceh.demo.Contact;
import ceh.demo.domain.ContactEntity;

@ApplicationScoped
public class JpaContactRepository implements ContactRepository {

  @PersistenceContext
  private EntityManager entityManager;
  
  @Override
  public void add(Contact contact) {
    entityManager.persist(contact);
  }

  @Override
  public Contact update(Contact contact) throws UpdateConflictException {
    try {
      if (entityManager.find(ContactEntity.class, contact.getId()) == null) {
        throw new EntityNotFoundException(Contact.class, contact.getId());
      }
      return entityManager.merge(contact);
    }
    catch (OptimisticLockException ex) {
      throw new UpdateConflictException(ex);
    }
  }

  @Override
  public void remove(Contact contact) {
    entityManager.remove(entityManager.merge(contact));
  }

  @Override
  public Collection<Contact> findAll() {
    TypedQuery<Contact> query = entityManager.createNamedQuery(
        "findAllContacts", Contact.class);
    return query.getResultList();
  }

  @Override
  public Contact findById(Long id) {
    TypedQuery<Contact> query = entityManager.createNamedQuery(
        "findContactById", Contact.class);
    query.setParameter("id", id);
    try {
      return query.getSingleResult();
    }
    catch (NoResultException ex) {
      return null;
    }
  }

  @Override
  public void flush() {
    entityManager.flush();
  }

}
