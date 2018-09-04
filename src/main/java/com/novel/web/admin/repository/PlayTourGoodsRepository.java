package com.novel.web.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.novel.web.admin.entity.PlayTourGoods;

public interface PlayTourGoodsRepository extends JpaSpecificationExecutor<PlayTourGoods>,JpaRepository<PlayTourGoods, Integer> {
}
