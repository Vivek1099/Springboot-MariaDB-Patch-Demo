package com.example.Springboot_MariaDB_Put.Patch_Demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository  extends JpaRepository<Teacher,Integer> 
{

}
