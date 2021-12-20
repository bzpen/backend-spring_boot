package com.example.demo.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.modules.sys.entity.SysAdmin;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-15
 */
public interface SysAdminService extends IService<SysAdmin> {

    /**
     * 查 询 管 理 员 账 号
     *
     * @param username
     * @return
     */
    SysAdmin selectByUsername(String username);

}
