package cn.p2p.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.p2p.pojo.Member;

public interface MemberMapper {
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
	List<Member> findByAdmin(@Param(value = "from") Integer from, @Param(value = "pageSize") Integer pageSize);

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
	Integer deleteById(Integer id);

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
	int alter(Member member);

	/**
	 * 添加会员
	 * 
	 * @param member
	 * @return
	 */
	int add(Member member);

	/**
	 * 用户名模糊查询用户
	 * 
	 * @param from
	 * @param pageSize
	 * @return
	 */
	List<Member> findAll(@Param(value = "username") String username, @Param(value = "from") Integer from,
			@Param(value = "pageSize") Integer pageSize);

	/**
	 * 用户名模糊查询用户数量
	 * 
	 * @return
	 */
	int findAllCount(@Param(value = "username") String username);
}
