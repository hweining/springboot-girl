package com.imooc.girl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer> {
    public List<Girl> findByAge(Integer age);
    public List<Girl> findByCupSize(String cupSize);
    public List<Girl> findByName(String name);
    public List<Girl> findByMoney(Double money);
}
