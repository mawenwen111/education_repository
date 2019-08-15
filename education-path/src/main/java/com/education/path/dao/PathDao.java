package com.education.path.dao;

import com.education.path.pojo.Path;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PathDao extends JpaRepository<Path,Integer>, JpaSpecificationExecutor<Path> {

    @Query("SELECT pathid,pathtitle,learncount,pathimage FROM Path ORDER BY LEVEL,learncount desc")
    List<Path> findAllOrderByLevelAndLearncount(PageRequest pageable);

    @Query("SELECT pathid,pathtitle,learncount,pathimage FROM Path WHERE level=1  ORDER BY learncount DESC")
    List<Path> findHotPath(PageRequest pageable);
}
