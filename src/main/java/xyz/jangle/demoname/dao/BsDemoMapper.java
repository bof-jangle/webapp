package xyz.jangle.demoname.dao;

import java.util.List;
import xyz.jangle.demoname.model.BsDemo;

public interface BsDemoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BsDemo record);

    BsDemo selectByPrimaryKey(Long id);

    List<BsDemo> selectAll();

    int updateByPrimaryKey(BsDemo record);
}