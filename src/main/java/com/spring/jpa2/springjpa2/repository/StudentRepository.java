package com.spring.jpa2.springjpa2.repository;

import com.spring.jpa2.springjpa2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {

    public List<Student> findByFirstName(String firstName); // custom method

    //JPQL query
    @Query("select s from Student s where s.emailId= ?1") // based on class and attribute
    Student getStudentByEmailAddress(String email);

    // native sql query
    @Query(
            value = "select * from student s where s.email_id= ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String email);

    //parameterised query
    @Query(
            value = "select * from student s where s.email_id= :email",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeParam(@Param("email") String email);

    @Transactional // used for insert , update , delete  once method is completed it will be done in db , actually done in service layer
    // can call any no. of methods , once all done then can commit the transactoin
    // right now it is in the repository and not in service layer
    @Modifying // as modifying so use this ,  a transaction is created and done
    @Query(

            value = "update student set first_name =?1 where email_id=?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName , String emailId);

}
