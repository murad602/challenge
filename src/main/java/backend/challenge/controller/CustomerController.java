package backend.challenge.controller;
import backend.challenge.entity.Customer;
import backend.challenge.entity.Task;
import backend.challenge.entity.User;
import backend.challenge.service.CustomerService;
import backend.challenge.service.TaskService;
import backend.challenge.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@RestController
@RequestMapping
public class CustomerController {

    private Optional <Customer> customerOptional;
    private Optional <Customer> customerOptionalOrg;
    private Optional <User> userOptional;
    private final CustomerService customerService;
    private final UserService userService;
    private final TaskService taskService;

    public CustomerController(CustomerService customerService, UserService userService, TaskService taskService) {
        this.customerService = customerService;
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/signin")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signin");
        return modelAndView;
    }

    @PostMapping("/singedIn")
    public ModelAndView singin(@RequestParam String customerEmail,
                               @RequestParam String customerPassword) {

        ModelAndView modelAndView = new ModelAndView();
        userOptional = userService.findUserbyEmailAndPassword(customerEmail, customerPassword);
        customerOptional = customerService.findUserbyEmailAndName(customerEmail, customerPassword);
        if (!customerOptional.isPresent() && !userOptional.isPresent()) {
            modelAndView.addObject("errorLogin", "Incorrect email or password");
            modelAndView.setViewName("signin");
            return modelAndView;
        } else if(customerOptional.isPresent()) {
            modelAndView.setViewName("homePage");
            modelAndView.addObject("relatUser", userService.getRelatedUser(customerOptional.get().getOrganizationName()));
            modelAndView.addObject("titname", customerOptional.get().getOrganizationName());
            return modelAndView;
        } else {
            modelAndView.setViewName("TaskHomePageUser");
            modelAndView.addObject("TaskHomePage", taskService.getTasks());
            return modelAndView;
        }

    }
    @GetMapping("/display")
    public ModelAndView displayListUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("homePage");
        modelAndView.addObject("relatUser", userService.getRelatedUser(customerOptional.get().getOrganizationName()));
        modelAndView.addObject("titname", customerOptional.get().getOrganizationName());
        return modelAndView;
    }


    @GetMapping("/singup")
    public ModelAndView signUp() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signupPage");
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView process_register( Customer customer) {
        ModelAndView modelAndView = new ModelAndView();
        customer.setRole("ADMIN");
        customerOptionalOrg = customerService.findCustomerByOrgName(customer.getOrganizationName());
        if (customerOptionalOrg.isPresent()) {
            modelAndView.addObject("error", "Organization " + customer.getOrganizationName() + "artiq movcuddur");
            modelAndView.setViewName("signupPage");
            return modelAndView;
        } else {
            customerService.registerCustomer(customer);
            modelAndView.setViewName("signin");
            return modelAndView;
        }
    }
    @GetMapping("/adduser")
    public ModelAndView addUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adduser");
        modelAndView.addObject("adduser", userService.getRelatedUser(customerOptional.get().getOrganizationName()));
        modelAndView.addObject("titlename", customerOptional.get().getOrganizationName());
        return modelAndView;
    }

    @PostMapping("/useradd")
    public ModelAndView userAdd(User user){
        user.setCustomer(new Customer(customerOptional.get().getOrganizationName()));
        user.setRole("USER");
        userService.registerUser(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("homePage");
        modelAndView.addObject("relatUser",userService.getRelatedUser(customerOptional.get().getOrganizationName()));
        return modelAndView;
    }

    @GetMapping("/addtask")
    public ModelAndView addTask() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("TaskHomePage");
        modelAndView.addObject("TaskHomePage", taskService.getTasks());
        modelAndView.addObject("titlename", customerOptional.get().getOrganizationName());
        return modelAndView;
    }
    @GetMapping("/addtaskmain")
    public ModelAndView addTaskmain() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("taskList");
        modelAndView.addObject("assingedUser",userService.getRelatedUser(customerOptional.get().getOrganizationName()));
        modelAndView.addObject("titlename", customerOptional.get().getOrganizationName());
        return modelAndView;
    }

    @PostMapping("/addtask2")
        public ModelAndView taskAdd(Task task){
            taskService.addTask(task);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("TaskHomePage");
            modelAndView.addObject("TaskHomePage", taskService.getTasks());
            modelAndView.addObject("titlename", customerOptional.get().getOrganizationName());
            return modelAndView;
    }

}
