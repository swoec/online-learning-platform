package main.java.com.online.web.dao;

import java.util.List;
import main.java.com.online.web.model.Words;
import main.java.com.online.web.model.WordsExample;
import main.java.com.online.web.model.WordsWithBLOBs;
import org.apache.ibatis.annotations.Param;

public interface WordsMapper {
    int countByExample(WordsExample example);

    int deleteByExample(WordsExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(WordsWithBLOBs record);

    int insertSelective(WordsWithBLOBs record);

    List<WordsWithBLOBs> selectByExampleWithBLOBs(WordsExample example);

    List<Words> selectByExample(WordsExample example);

    WordsWithBLOBs selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") WordsWithBLOBs record, @Param("example") WordsExample example);

    int updateByExampleWithBLOBs(@Param("record") WordsWithBLOBs record, @Param("example") WordsExample example);

    int updateByExample(@Param("record") Words record, @Param("example") WordsExample example);

    int updateByPrimaryKeySelective(WordsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(WordsWithBLOBs record);

    int updateByPrimaryKey(Words record);
}