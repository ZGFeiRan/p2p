package cn.p2p.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.p2p.pojo.Tender_record;

public interface Tender_recordService {
	/**
	 * 根据用户查询投标记录
	 * 
	 * @param id
	 * @return
	 */
	List<Tender_record> findByMID(Integer m_id, Integer from, Integer pageSize);

	/**
	 * 查询分页量总数
	 * 
	 * @param id
	 * @return
	 */
	Integer findByMIDCount(Integer m_id);

	/**
	 * 查询用户所有投标记录
	 * 
	 * @return
	 */
	List<Tender_record> findAll(Integer m_id);

	/**
	 * 添加投标记录
	 * 
	 * @param tender_record
	 * @return
	 */
	boolean add(Tender_record tender_record);

	/**
	 * 根据会员id和标的id查询投标记录
	 * 
	 * @param b_id
	 * @param m_id
	 * @return
	 */
	Tender_record findByMidBid(Integer b_id);

	/**
	 * 修改投标记录
	 * 
	 * @param tender_record
	 * @return
	 */
	boolean update(Tender_record tender_record);
}
