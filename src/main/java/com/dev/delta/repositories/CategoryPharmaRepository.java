package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dev.delta.fastbus.entities.Assign;
import com.dev.delta.pharmalife.entities.CategoryPharma;
@RepositoryRestResource
public interface CategoryPharmaRepository  extends JpaRepository<CategoryPharma, Long> {

}
