package cn.p2p.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.p2p.dao.Tender_recordMapper;
import cn.p2p.pojo.Tender_record;
import cn.p2p.service.Tender_recordService;

@Service
public class Tender_recordServiceImpl implements Tender_recordService {
	@Resource
	private Tender_recordMapper tender_recordMapper;

	@Override
	public List<Tender_record> findByMID(Integer m_id, Integer from, Integer pageSize) {
		return tender_recordMapper.findByMID(m_id, from, pageSize);
	}

	@Override
	public Integer findByMIDCount(Integer m_id) {
		return tender_recordMapper.findByMIDCount(m_id);
	}

	@Override
	public List<Tender_record> findAll(Integer m_id) {
		return tender_recordMapper.findAll(m_id);
	}

	@Override
	public boolean add(Tender_record tender_record) {
		boolean falg = false;
		if (tender_recordMapper.add(tender_record) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public Tender_record findByMidBid(Integer b_id) {
		return tender_recordMapper.findByMidBid(b_id);
	}

	@Override
	public boolean update(Tender_record tender_record) {
		boolean falg = false;
		if (tender_recordMapper.update(tender_record) > 0) {
			falg = true;
		}
		return falg;
	}
}
