package cn.yh.st.blog.dao;

import cn.yh.st.base.MyBatisRepository;
import cn.yh.st.blog.domain.BComment;

import com.github.abel533.mapper.Mapper;

@MyBatisRepository
public interface BCommentDao extends Mapper<BComment> {

}
