package me.lumen.demo.dao;

import me.lumen.demo.domain.Product;
import org.apache.ibatis.annotations.Select;

/**
 * Created by lumen on 18-1-5.
 */
public interface ProductMapper {
//    @Select("select * from product where id = #{id}")
    Product select(long id);
}
