package com.example.developer_toolbox;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToolService {

    private final ToolRepository toolRepository;

    private final ToolLicenseRepository toolLicenseRepository;

    public List<Tool> getAllTools() {

        return toolRepository.findAll();
    }

    public void saveTool(Tool tool) {

        toolRepository.save(tool);
    }

    public void editTool(Tool tool, int id) {

        tool.setId(id);
        toolRepository.save(tool);
    }

    public Tool EditToolById(int id) {

        return toolRepository.findById(id).orElse(null);
    }

    public void deleteTool(int id) {

        toolRepository.deleteById(id);
    }

    public long count() {

        return toolRepository.count();
    }

    public List<Tool> findByCategory(String category) {

        return toolRepository.findAllByCategory(category);
    }

    public void saveLicense(ToolLicense toolLicense) {

        toolLicenseRepository.save(toolLicense);
    }
}
