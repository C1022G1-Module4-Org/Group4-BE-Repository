package com.example.cs_module.repository.coffee_shop;

import com.example.cs_module.model.coffee_shop.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBranchRepository extends JpaRepository<Branch,Integer> {
//    @Query(value = "select *from branch where  email like %:email%)",nativeQuery = true)
//    Page<Branch>getAll(Pageable pageable, @Param("email")String email);
//
//    @Query(value = "select *from branch where address like concat('%',:param,'%') and coffe_shop_id=:id",nativeQuery = true)
//    Page<Branch> getAllByAddress(Pageable pageable,@Param("param")String address,@Param("id")long id);

    Page<Branch> findBranchByNameContainingAndIsDelete(Pageable pageable,String name,boolean isDelete);
    List<Branch>findCoffeShopName(String name);
}
