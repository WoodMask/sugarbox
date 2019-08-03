package com.sugarbox.jellyframeworktools.mybatisplus.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.sugarbox.jellyframeworktools.mybatisplus.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
