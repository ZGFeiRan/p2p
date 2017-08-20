package cn.appsys.service.developer;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DevUser;

/**
 * 开发者用户服务接口
 * 
 * @author 117
 *
 */
public interface DevUserService {
	/**
	 * 根据开发者用户名查找用户
	 * 
	 * @param devCode
	 *            开发者登录名
	 * @return
	 */
	public DevUser getDevUserByCode(@Param("devCode") String devCode);
}
