package com.example.demo.modules.sys.controller;


import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.sys.entity.TbUser;
import com.example.demo.modules.sys.service.ITbUserService;
import io.swagger.annotations.Api;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.common.web.base.BaseController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-08
 */
@RestController
public class TbUserController extends BaseController {
}
