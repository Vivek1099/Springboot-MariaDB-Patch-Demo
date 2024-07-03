package com.example.Springboot_MariaDB_Put.Patch_Demo;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="TeacherData")
public class Teacher 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int tid;
	String tname;
	String tcity;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTcity() {
		return tcity;
	}
	public void setTcity(String tcity) {
		this.tcity = tcity;
	}
	
	
}
