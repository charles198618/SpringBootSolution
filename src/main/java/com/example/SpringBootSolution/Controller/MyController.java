package com.example.SpringBootSolution.Controller;

import com.example.SpringBootSolution.Entity.Course;
import com.example.SpringBootSolution.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private com.example.SpringBootSolution.Service.CourseService CourseService;

    @GetMapping("/")
    public String home() {
        return "<HTML><H1>Welcome to Java FullStack Application</H1></HTML>";
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.CourseService.getAllCourse();
    }

    @GetMapping("/courses/{courseID}")
    private Course getCourse(@PathVariable String courseID) {
        return this.CourseService.getCourseById(Integer.parseInt(courseID));
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return this.CourseService.addCourse(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
        return this.CourseService.updateCourse(course);
    }

    @DeleteMapping("/courses/{courseID}")
    private String deleteCourse(@PathVariable String courseID) {
        return this.CourseService.deleteCourseById(Integer.parseInt(courseID));
    }
}
