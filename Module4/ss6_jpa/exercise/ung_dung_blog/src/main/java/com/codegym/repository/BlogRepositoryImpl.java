package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class BlogRepositoryImpl implements BlogRepository<Blog> {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List findAll() {
        TypedQuery<Blog> blogTypedQuery = entityManager.createQuery("select c from Blog c",Blog.class);
        return blogTypedQuery.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        TypedQuery<Blog>  blogTypedQuery = entityManager.createQuery("select c from Blog c where c.id=:id",Blog.class);
        blogTypedQuery.setParameter("id",id);
        try{
            return blogTypedQuery.getSingleResult();
        }catch (NoResultException e){
            return null;
        }

    }

    @Override
    public void save(Blog blog) {
        if(blog.getId() != null){
            entityManager.merge(blog);
        }else {
            entityManager.persist(blog);
        }
    }

    @Override
    public void remove(Long id) {
        Blog blog = findById(id);
        if(blog!=null){
            entityManager.remove(blog);
        }
    }
}
