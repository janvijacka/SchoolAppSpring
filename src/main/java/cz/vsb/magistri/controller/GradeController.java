package cz.vsb.magistri.controller;

import cz.vsb.magistri.dto.GradeDto;
import cz.vsb.magistri.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GradeController {
    @Autowired
    GradeService gradeService;

    @PostMapping({"/grades", "/grades/"})
    public GradeDto addGrade(@RequestBody GradeDto gradeDto){
        return gradeService.addGrade(gradeDto);
    }
    @GetMapping({"/grades", "/grades/"})
    public List<GradeDto> getAllGrades(){
        return gradeService.getAllGrades();
    }

    @GetMapping({"/grades/{gradeId}", "/grades/{gradeId}/"})
    public  GradeDto getGradeById(@PathVariable("gradeId") int gradeId){
        return gradeService.getGradeById(gradeId);
    }
    @PutMapping({"/grades/{gradeId}", "/grades/{gradeId}/"})
    public GradeDto editGrade(@PathVariable("gradeId") int gradeId, @RequestBody GradeDto gradeDto){
        return gradeService.editGrade(gradeId, gradeDto);
    }

    @DeleteMapping({"/grades/{gradeId}", "/grades/{gradeId}/"})
    public GradeDto deleteGrade(@PathVariable("gradeId") int gradeId){
        return gradeService.deleteGrade(gradeId);
    }
}
