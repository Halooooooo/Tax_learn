package com.halo.nsfw.core.permission;

import com.halo.nsfw.user.entity.User;

public interface PermissionCheck {
	/**
	 * 判断用户是否有进入的权限
	 * @param user
	 * @param code
	 * @return
	 */
	boolean isAccessible(User user, String code);

}
