package com.mymock.mvc;

import com.mymock.Service.ILoginService;
import com.mymock.Service.IStudentService;
import com.mymock.domain.Student;
import com.mymock.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


/**
 * Created by rkavya on 3/19/2015.
 */

@Controller
public class MainClass{

    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private ILoginService iLoginService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.put("account", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login( @ModelAttribute(value = "account")User user,ModelMap model,HttpSession session)
    {

       /* User user1 = new User();
        user1.setUsername("kavya");
        user1.setPassword("kavz");

        iLoginService.addUser(user1);

        User user2 = new User();
        user2.setUsername("admin");
        user2.setPassword("admin");

        iLoginService.addUser(user2);*/

        if(iLoginService.login(user)) {
         /*   Student student1 = new Student();
              student1.setName("Mrudhul");
            student1.setPword("mrudhulk@mail.com");
            iStudentService.insert(student1);*/
            model.put("student", new Student());
            model.put("studentList",iStudentService.getAllStudents());
            //model.put("student",new Student());
            return "main";
        }
        else
        {
            model.put("message", "Login failed");
            model.put("account", new User());
            return "login";
        }

    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String SaveStudent( @ModelAttribute(value = "student")Student student,ModelMap model,HttpSession session,BindingResult result,@RequestParam String action)
    {

        Student student1 = new Student();
        System.out.println(action);
        if(action.toLowerCase().equals("add")){
            System.out.println("Student Name is " + student.getName());
            session.setAttribute("username",student.getName());
            iStudentService.insert(student);

            model.put("message"," Student Object added successfully");
            model.put("student",student);
            model.put("studentList",iStudentService.getAllStudents());
            return "main";
        }
        if(action.toLowerCase().equals("delete")){
            iStudentService.deleteStudent(student.getId());
            model.put("message"," Student Object deleted successfully");
            model.put("student",new Student());
            model.put("studentList",iStudentService.getAllStudents());
            return "main";
        }
        if(action.toLowerCase().equals("search")){
            student1 = iStudentService.getStudent(student.getId());
            model.put("student",student1);
            model.put("studentList",iStudentService.getAllStudents());
            return "main";
        }
        if(action.toLowerCase().equals("edit")){
            iStudentService.editStudent(student);
            model.put("student",student);
            model.put("studentList",iStudentService.getAllStudents());
            return "main";
        }
        else
            {
             model.put("message","Login Again");
             return "main";
            }
    }


}