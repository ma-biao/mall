package com.mabiao.mall.member.dao;

import com.mabiao.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author mabiao
 * @email mabiao0408@gmail.com
 * @date 2021-12-27 10:41:30
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
