package com.mark1.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mark1.entity.Category;
import com.mark1.repository.CategoryRepository;

@Service
@Transactional(readOnly = true)
public class RestCategoryService implements CategoryService {
	
	@Inject
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category getCategoryById(long id) {
		return categoryRepository.findById(id);
	}

	@Override
	public List<Category> findCategoryByName(String name) {
		return categoryRepository.findByName(name);
	}

	@Override
	@Transactional
	public Category saveCategory(Category category) {
		category.setId(0);
		
		return categoryRepository.save(category);
	}

	@Override
	@Transactional
	public Category updateCategory(long id, Category category) {
		Category ori = getCategoryById(category.getId());
		if (ori != null) {
			ori.setName(category.getName());
			ori.setDescription(category.getDescription());
		}
		
		return ori;
	}

	@Override
	@Transactional
	public void deleteCategory(long id) {
		categoryRepository.delete(id);
	}
	
}
	