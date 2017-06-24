package com.wuyong.repository;

import com.wuyong.pojo.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 坚果
 * on 2017/6/24
 */
//<类，id类型>
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    public List<Girl> findByAgeBetween(Integer firstAge, Integer secondAge);
}
