package com.adminportal.repo;

import com.adminportal.domain.Guitar;
import org.springframework.data.repository.CrudRepository;


public interface GuitarRepository extends CrudRepository<Guitar, Long> {
}
