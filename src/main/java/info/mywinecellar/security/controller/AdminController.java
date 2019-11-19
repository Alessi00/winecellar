/*
 * My-Wine-Cellar, copyright 2019
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 */

package info.mywinecellar.security.controller;

import info.mywinecellar.nav.Attributes;
import info.mywinecellar.nav.Paths;
import info.mywinecellar.security.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Inject
    private UserService userService;

    @GetMapping("/userlist")
    public String getAllUsers(Model model) {
        model.addAttribute(Attributes.USERS, userService.findAll());
        return Paths.SECURITY_ADMIN_CONSOLE;
    }

}