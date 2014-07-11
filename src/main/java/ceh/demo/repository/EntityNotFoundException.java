package ceh.demo.repository;

import java.lang.ref.WeakReference;

public class EntityNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 4394735761682091470L;

  private final WeakReference<? extends Class> entityClass;
  private final Object id;
  
  public EntityNotFoundException(Class<?> entityClass,
      Object id) {
    super(String.format("entity of type %s with identifier %s not found",
        entityClass.getName(), id));
    this.entityClass = new WeakReference<Class>(entityClass);
    this.id = id;
  }

  public WeakReference<? extends Class> getEntityClass() {
    return entityClass;
  }

  public Object getId() {
    return id;
  }
  
}
