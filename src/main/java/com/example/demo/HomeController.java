package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String index(Model model) {
        // Create an instance of Employee
        Employee employee = new Employee();
        employee.setName("Sue Purple");
        employee.setSsn("123-45-6789");

        // Create an instance of Laptop
        Laptop laptop = new Laptop();
        laptop.setBrand("Apple");
        laptop.setModel("Macbook Pro 15");

        // Add the laptop to employee
        employee.setLaptop(laptop);

        // Save employee to the database
        employeeRepository.save(employee);

        // Grab all the employees from the database and send them to the template
        model.addAttribute("employees", employeeRepository.findAll());
        return "index";
    }

}
