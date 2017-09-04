package com.nokia.netactplus.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.nokia.netactplus.system.entity.SysRolePermission;

/**
 * <p>
 * 角色权限表 服务类
 * </p>
 *
 * @author mpthink
 * @since 2017-04-17
 */
public interface ISysRolePermissionService extends IService<SysRolePermission> {

	public void addAuth(Long roleId, Long[] permIds);

}
