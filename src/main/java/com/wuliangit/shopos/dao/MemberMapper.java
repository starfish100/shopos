package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.MemberListDTO;
import com.wuliangit.shopos.entity.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper extends BaseMapper<Member, Integer> {

    /**
     * 通过openid获取用户
     * @param openid
     * @return
     */
    Member getByOpenid(String openid);

    /**
     * 通过用户名获取用户
     * @param username
     * @return
     */
    Member getByUsername(String username);

    /**
     * 获取会员列表的数据
     * @param orderColumn
     * @param orderType
     * @param searchKey
     * @return
     */
    List<MemberListDTO> getMemberList(@Param("orderColumn") String orderColumn,@Param("orderType") String orderType,@Param("searchKey") String searchKey);

    /**
     * 删除会员
     * @param memberId
     * @return
     */
    Integer deleteMember(Integer memberId);

    /**
     * 更改会员状态
     * @param memberId
     * @param state
     * @return
     */
    Integer updateMemberState(Integer memberId, String state);
}