package com.yl.pmt.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yl.pmt.security.mapper.MenuMapper;
import com.yl.pmt.security.pojo.Menu;
import com.yl.pmt.security.service.IMenuService;
import org.springframework.stereotype.Service;

/**
 * @Description 权限业务实现
 * @Author pch
 * @CreateTime 2020/9/14 15:57
 */
@Service("sysMenuService")
public class MenuService extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
