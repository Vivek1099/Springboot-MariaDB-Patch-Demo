package com.example.Springboot_MariaDB_Put.Patch_Demo;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController 
{
	@Autowired
	TeacherRepository trepo;
	
	@GetMapping("/test")
	public String test()
	{
		return "teacher demo";
	}
	
	@PostMapping("/save")
	public String savedata(@RequestBody Teacher teacher)
	{
		trepo.save(teacher);
		return "Data Saved";
	}
	
	@GetMapping("/show")
	public List<Teacher> showdata()
	{
		return trepo.findAll();
	}
	
	@DeleteMapping("/delbyid/{tid}")
	public String DelById(@PathVariable int tid)
	{
		trepo.deleteById(tid);
		return "Data Deleted";
	}
	
	@GetMapping("/byid/{tid}")
	public Optional<Teacher> ById(@PathVariable int tid)
	{
		return trepo.findById(tid);
	}
	
	@PatchMapping("/update/{tid}") //any field can be updated using ReflectionUtils class.
	public Teacher UpdById(@PathVariable int tid,@RequestBody Map<String,Object> fields)
	{
		Optional<Teacher> t=trepo.findById(tid);
		fields.forEach((key, value)->
		{
			Field field = ReflectionUtils.findField(Teacher.class, key);
			field.setAccessible(true);
			ReflectionUtils.setField(field, t.get(), value);
		});
		return trepo.save(t.get());
	}
}
