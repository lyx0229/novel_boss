package com.novel.web.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.novel.web.admin.entity.NovelScheme;


public interface NovelSchemeRepository extends JpaSpecificationExecutor<NovelScheme>,JpaRepository<NovelScheme, Integer> {

}
