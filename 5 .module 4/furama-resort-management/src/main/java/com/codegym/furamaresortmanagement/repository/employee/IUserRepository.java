package com.codegym.furamaresortmanagement.repository.employee;

import com.codegym.furamaresortmanagement.model.employee.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<AppUser, String> {
}
