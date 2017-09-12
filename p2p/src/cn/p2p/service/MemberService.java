package cn.p2p.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.p2p.pojo.Member;

public interface MemberService {
	/**
	 * 根据会员名查找会员
	 * 
	 * @param username
	 * @return
	 */
	Member findMemberByName(String username);

	/**
	 * 查询管理员账户
	 * 
	 * @return
	 */
	List<Member> findByAdmin(Integer from, Integer pageSize);

	/**
	 * 查询管理员账户总数
	 * 
	 * @return
	 */
	Integer findByAdminCount();

	/**
	 * 删除会员信息
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteById(Integer id);

	/**
	 * 根据id获取会员
	 * 
	 * @param id
	 * @return
	 */
	Member findMemberById(Integer id);

	/**
	 * 更改会员
	 * 
	 * @param member
	 * @return
	 */
	boolean alter(Member member);

	/**
	 * 添加会员
	 * 
	 * @param member
	 * @return
	 */
	boolean add(Member member);

	/**
	 * 用户名模糊查询用户
	 * 
	 * @param from
	 * @param pageSize
	 * @return
	 */
	List<Member> findAll(String username, Integer from, Integer pageSize);

	/**
	 * 用户名模糊查询用户数量
	 * 
	 * @return
	 */
	int findAllCount(String username);
}
