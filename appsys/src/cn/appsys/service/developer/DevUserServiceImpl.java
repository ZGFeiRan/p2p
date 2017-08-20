package cn.appsys.service.developer;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appsys.dao.devUser.DevUserMapper;
import cn.appsys.pojo.DevUser;

/**
 * 开发者服务接口实现类
 * 
 * @author 117
 *
 */
@Service
@Transactional
public class DevUserServiceImpl implements DevUserService {
	@Resource
	private DevUserMapper devUserMapper;

	@Override
	public DevUser getDevUserByCode(String devCode) {
		return devUserMapper.getDevUserByCode(devCode);
	}

}
