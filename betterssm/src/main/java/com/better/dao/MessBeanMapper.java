package com.better.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.better.entity.MessBean;
import com.better.entity.MessBeanWithBLOBs;
/**
 * MessBeanMapper:Interface<br>
 * 信息dao接口
 * 
 * @version 1.0
 * @author zhulei
 * @since 2016-01-07
 *
 */
@Repository("messBeanMapper")
public interface MessBeanMapper {
	
	/**
	 * 按主键删除一条信息
	 * @param messId 主键id
	 * @return 删除记录条数
	 */
    int deleteByPrimaryKey(Integer messId);
    
    /**
     * 添加一条信息类型记录
     * @param record 类型Bean
     * @return
     */
    int insert(MessBeanWithBLOBs messBeanWithBLOBs);
    
    /**
     * 添加一条信息 
     * @param record
     * @return
     */
    int insertSelective(MessBeanWithBLOBs messBeanWithBLOBs);
    
    /**
     * 查询一条信息<br>
     * 完整信息
     * 
     * @param messId 信息id
     * @return 信息
     */
    public MessBeanWithBLOBs selectMessBeanWithBLOBs(Integer messId);
    
    public MessBean selectMessBean(Integer messId);
    
    /**
     * 更新一条信息<br>
     * 包括了每一个字段
     * 
     * @param record 信息
     * @return 成功数量
     */
    int updateByPrimaryKeySelective(MessBeanWithBLOBs messBeanWithBLOBs);
    
    /**
     * 更新一条信息
     * 包括了每一个字段
     * @param record 信息
     * @return 成功数量
     */
    int updateByPrimaryKeyWithBLOBs(MessBeanWithBLOBs messBeanWithBLOBs);
    
    /**
     * 更新一条信息<br>
     * 更新内容不包括内容和收件人字段
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKey(MessBean messBean);
    
    /**
     * 查询已查看信息记录列表<br>
     * 根据用户id，信息不包括信息内容<br>
     * 此处应该用分页查询
     * 
     * @param userId 用户id
     * @param pageNo 页码
     * @param pageCount 单页记录数量
     * @return
     */
    public List<MessBean> querySeenPage(int userId, int pageNo, int pageCount);
    
    
    
}