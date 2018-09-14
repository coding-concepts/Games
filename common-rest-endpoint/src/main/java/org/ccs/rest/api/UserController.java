package org.ccs.rest.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

    @RequestMapping(value = "/users", method= RequestMethod.GET, produces = "application/text")
    @ApiOperation(value = "Get a user", response = String.class)
    public String login() {
        return "OK";
    }


    public String registerUser() {
        return "OK";
    }


}
