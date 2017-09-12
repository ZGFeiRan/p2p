package cn.p2p.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.p2p.dao.RoleMapper;
import cn.p2p.pojo.Role;
import cn.p2p.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleMapper roleMapper;

	@Override
	public List<Role> findAll() {
		return roleMapper.findAll();
	}

	@Override
	public boolean add(Role role) {
		boolean falg = false;
		if (roleMapper.add(role) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public boolean delete(Integer id) {
		boolean falg = false;
		if (roleMapper.delete(id) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public Role findRoleById(Integer id) {
		return roleMapper.findRoleById(id);
	}

	@Override
	public boolean update(Role role) {
		boolean falg = false;
		if (roleMapper.update(role) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public List<Role> findAllPage(Integer from, Integer pageSize) {
		return roleMapper.findAllPage(from, pageSize);
	}

	@Override
	public Integer findAllCount() {
		return roleMapper.findAllCount();
	}

}
