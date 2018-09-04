package com.novel.web.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.novel.web.admin.entity.RechargeDetail;

public interface RechargeDetailRepository extends JpaSpecificationExecutor<RechargeDetail>,JpaRepository<RechargeDetail, Integer> {
	
	@Query(value = "select u.* from tbl_recharge_detail u  where  u.order_no=?1", nativeQuery = true)
	public RechargeDetail findRechargeDetailByOrderNo(@Param("order_no")String order_no);
	

	@Query(value="select u.* from tbl_recharge_detail u where u.user_id=?1 order by id asc", nativeQuery = true)
	List<RechargeDetail> findRechargeDetailByUserID(@Param("user_id")int user_id);
}
