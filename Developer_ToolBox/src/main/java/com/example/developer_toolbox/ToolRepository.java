package com.example.developer_toolbox;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Integer> {

    List<Tool> findAllByToolNameEqualsIgnoreCaseAndCategoryEqualsIgnoreCase(String toolName, String category);

    List<Tool> findAllByToolDetailsPlatformEqualsIgnoreCase(String toolDetailsPlatform, Sort sort);
    List<Tool> deleteAllByCategory(String category);
    List<Tool> deleteAllByToolDetailsPlatform(String toolDetailsPlatform);
    List<Tool> findAllByCategory(String category);
}
