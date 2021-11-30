package com.codegym.demo_c0721g2_spring_boot.repository;

import com.codegym.demo_c0721g2_spring_boot.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface IStudentRepository extends JpaRepository<Student, Integer> {

    //    List<Student> findAllByNameContaining(String name);
//    @Query sẽ giúp các bạn viết theo 2 ngôn ngữ là HQL và SQL
//    nativeQuery = true -> SQL -> native
//    nativeQuery = false -> HQL -> JPQL
    @Query(value = "select * from student where name like :name",nativeQuery = true)
    List<Student> searchByName(@Param("name") String name);
}
