package com.example.SpringBootSolution.Service;

import com.example.SpringBootSolution.DAO.CourseDAO;
import com.example.SpringBootSolution.Entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDAO courseDAO;
    @Override
    public List<Course> getAllCourse() {

        return this.courseDAO.findAll();
    }

    @Override
    public Course getCourseById(int courseID) {

        Optional<Course> c = this.courseDAO.findById(courseID);
        Course course = null;
        if(c.isPresent()) {
            course = c.get();
        }
        else {
            throw new RuntimeException(" Course is not found for id :: " + courseID);
        }
        return course;
    }
    @Override
    public Course addCourse(Course course) {

        return this.courseDAO.save(course);
    }

    @Override
    public Course updateCourse(Course course) {

        return this.courseDAO.save(course);
    }

    @Override
    public String deleteCourseById(int courseID) {

        this.courseDAO.deleteById(courseID);

        return "Deleted Successfully";
    }

}
