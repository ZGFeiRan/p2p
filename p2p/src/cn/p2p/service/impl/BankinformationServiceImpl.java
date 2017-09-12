package cn.p2p.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.p2p.dao.BankinformationMapper;
import cn.p2p.pojo.Bankinformation;
import cn.p2p.service.BankinformationService;

@Service
public class BankinformationServiceImpl implements BankinformationService {
	@Resource
	private BankinformationMapper bankinformationMapper;

	@Override
	public Integer getAllCount() {
		return bankinformationMapper.getAllCount();
	}

	@Override
	public List<Bankinformation> findByPage(Integer from, Integer pageSize) {
		return bankinformationMapper.findByPage(from, pageSize);
	}

	@Override
	public Bankinformation findById(Integer id) {
		return bankinformationMapper.findById(id);
	}

	@Override
	public boolean add(Bankinformation bankinformation) {
		boolean falg = false;
		if (bankinformationMapper.add(bankinformation) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public boolean update(Bankinformation bankinformation) {
		boolean falg = false;
		if (bankinformationMapper.update(bankinformation) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public boolean delete(Integer id) {
		boolean falg = false;
		if (bankinformationMapper.delete(id) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public List<Bankinformation> findAll() {
		return bankinformationMapper.findAll();
	}

}
