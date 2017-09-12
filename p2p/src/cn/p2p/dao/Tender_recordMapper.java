package cn.p2p.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.p2p.pojo.Tender_record;

public interface Tender_recordMapper {
	/**
	 * 根据用户查询投标记录
	 * 
	 * @param id
	 * @return
	 */
	List<Tender_record> findByMID(@Param(value = "m_id") Integer m_id, @Param(value = "from") Integer from,
			@Param(value = "pageSize") Integer pageSize);

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
	int add(Tender_record tender_record);

	/**
	 * 根据标的id查询投标记录
	 * 
	 * @param b_id
	 * @param m_id
	 * @return
	 */
	Tender_record findByMidBid(@Param(value = "b_id") Integer b_id);

	/**
	 * 修改投标记录
	 * 
	 * @param tender_record
	 * @return
	 */
	int update(Tender_record tender_record);
}
