package main.java.com.online.web.dao;

import java.util.List;
import main.java.com.online.web.model.Videos;
import main.java.com.online.web.model.VideosExample;
import main.java.com.online.web.model.VideosWithBLOBs;
import org.apache.ibatis.annotations.Param;

public interface VideosMapper {
    int countByExample(VideosExample example);

    int deleteByExample(VideosExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(VideosWithBLOBs record);

    int insertSelective(VideosWithBLOBs record);

    List<VideosWithBLOBs> selectByExampleWithBLOBs(VideosExample example);

    List<Videos> selectByExample(VideosExample example);

    VideosWithBLOBs selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") VideosWithBLOBs record, @Param("example") VideosExample example);

    int updateByExampleWithBLOBs(@Param("record") VideosWithBLOBs record, @Param("example") VideosExample example);

    int updateByExample(@Param("record") Videos record, @Param("example") VideosExample example);

    int updateByPrimaryKeySelective(VideosWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(VideosWithBLOBs record);

    int updateByPrimaryKey(Videos record);
}