package repository;

import model.Category;
import model.Product;

import java.util.List;

public interface ICategoryRepository {

    List<Category> findAll();
}
