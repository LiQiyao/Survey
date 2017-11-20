package edu.zust.survey.service;

import edu.zust.survey.entity.Manager;
import edu.zust.survey.vo.AnswerSheetVo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Lee on 2017/10/19.
 */
public interface IManagerService {

    Manager login(String username, String password);

    boolean addManager(String username, String password, Integer majorId);

    boolean addGrade(Integer majorId, Integer grade);

    AnswerSheetVo assembleAnswerSheetVo(Integer studentId);

    void getAllAnswerSheet(Integer majorId, Integer grade, String rootPath, HttpServletResponse response);

    boolean importStudentInformation(MultipartFile multipartFile, HttpServletRequest request);
}
