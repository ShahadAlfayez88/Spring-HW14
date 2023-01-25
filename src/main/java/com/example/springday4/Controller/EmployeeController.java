package com.example.springday4.Controller;

import com.example.springday4.ApiResponse;
import com.example.springday4.Pogo.Employees;
import com.example.springday4.Pogo.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    ArrayList<Employees> employees = new ArrayList<>();

    // display
    @GetMapping("/display")
    public ArrayList<Employees> getEmployee(){
        return employees;
    }

    // add
    @PostMapping("/add")
    public ResponseEntity addEmployees(@Valid @RequestBody Employees employee, Errors error){ // كلاس جاهز يعرض لي وش الخطأ اللي صار
        if( error.hasErrors()){
            String message=error.getFieldError().getDefaultMessage();
            return  ResponseEntity.status(400).body(new ApiResponse(message));

        }
        employees.add(employee);
        return ResponseEntity.status(200).body(new ApiResponse("User added"));
    }


    // update

    @PutMapping("/update/{index}")
    public ResponseEntity updateEmployee(@PathVariable int index , @Valid @RequestBody Employees employee, Errors error){
        if( error.hasErrors()){
            String message=error.getFieldError().getDefaultMessage();
            return  ResponseEntity.status(400).body(new ApiResponse(message));
        }
        employees.set(index,employee);
        return ResponseEntity.status(200).body(new ApiResponse("User updated"));
    }

    // apply for a annual leave

    @GetMapping("/apply/{index}")
    public ResponseEntity applyLeave(@PathVariable int index , @Valid Employees employee, Errors error){
                for (Employees emp : employees) {
                    if (employees.get(index).getAnnualLeave() > 0) {
                        int balance = emp.getAnnualLeave();
                        balance -= 1;
                        emp.setAnnualLeave(balance);
                        emp.setOnLeave("true");
                        return ResponseEntity.status(200).body(new ApiResponse("Have a good time"));
                    } else if (emp.getAnnualLeave() == 0) {

                        ResponseEntity.status(400).body(new ApiResponse("You dont have a balance"));
                    }
                }

        return ResponseEntity.status(400).body(new ApiResponse("You dont have a balance"));
    }

    // remove

    @DeleteMapping("/remove/{index}")
    public ResponseEntity deleteEmployee(@PathVariable int index , @Valid@RequestBody Employees employee, Errors error){
        if( error.hasErrors()){
            String message=error.getFieldError().getDefaultMessage();
            return  ResponseEntity.status(400).body(new ApiResponse(message));
        }
        employees.set(index,employee);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted"));
    }

}
