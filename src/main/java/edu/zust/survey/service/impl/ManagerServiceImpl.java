package edu.zust.survey.service.impl;

import com.google.common.collect.Lists;
import edu.zust.survey.common.GenericBuilder;
import edu.zust.survey.dao.*;
import edu.zust.survey.entity.*;
import edu.zust.survey.service.IDisplayFormService;
import edu.zust.survey.service.IManagerService;
import edu.zust.survey.util.DeleteFileUtil;
import edu.zust.survey.util.DownloadUtil;
import edu.zust.survey.util.HTML2WordUtil;
import edu.zust.survey.util.ZipUtil;
import edu.zust.survey.vo.AnswerSheetVo;
import edu.zust.survey.vo.QuestionAndAnswerEntry;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * Created by Lee on 2017/10/19.
 */
@Service
public class ManagerServiceImpl implements IManagerService{

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private ManagerMapper managerMapper;

    @Autowired
    private GradeTableMapper gradeTableMapper;

    @Autowired
    private IDisplayFormService displayFormService;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StuAnsMapper stuAnsMapper;

    @Autowired
    private SuggestionMapper suggestionMapper;

    @Autowired
    private DisplayFormMapper displayFormMapper;

    @Autowired
    private MajorMapper majorMapper;

    @Override
    public Manager login(String username, String password) {
        Manager manager = managerMapper.selectByUsernameAndPassword(username, password);
        if (manager != null){
            manager.setPassword(StringUtils.EMPTY);
        }
        return manager;
    }

    @Override
    @Transactional
    public boolean addManager(String username, String password, Integer majorId) {
        Manager manager = new Manager(username, password, majorId);
        managerMapper.insert(manager);
        return true;
    }

    @Override
    @Transactional
    public boolean addGrade(Integer majorId, Integer grade) {
        gradeTableMapper.insertSelective(GenericBuilder.of(GradeTable::new)
                                    .with(GradeTable::setGrade, grade)
                                    .with(GradeTable::setMajorId, majorId)
                                    .build());
        /*List<Integer> allQuestionnaireIds = questionnaireMapper.selectAllId();
        for (Integer questionnaireId : allQuestionnaireIds){
            displayFormMapper.insertSelective(GenericBuilder.of(DisplayForm::new)
                    .with(DisplayForm::setGrade, grade)
                    .with(DisplayForm::setQuestionnaireId, questionnaireId)
                    .build());
        }*/
        //displayFormService.synchronizeDisplayForm();
        return true;
    }

    @Override
    public AnswerSheetVo assembleAnswerSheetVo(Integer studentId) {
        Student student = studentMapper.selectByPrimaryKey(studentId);
        logger.info("student: " + student);
/*        int questionnaireId = majorMapper.selectByPrimaryKey(student.getMajorId()).getDisplayQuestionnaireId();
        DisplayForm displayForm = displayFormMapper.selectByQuestionnaireIdAndGrade(questionnaireId, student.getGrade());

        boolean part1IsDisplay = displayForm.getPart1IsDisplay();
        boolean part2IsDisplay = displayForm.getPart2IsDisplay();
        List<QuestionAndAnswerEntry> part1 =null;
        List<QuestionAndAnswerEntry> part2 =null;
        if (part1IsDisplay){
            part1 = stuAnsMapper.selectByStudentIdAndType(studentId, 1);
        }
        if (part2IsDisplay){
            part2 = stuAnsMapper.selectByStudentIdAndType(studentId, 2);
        }
        String suggestionContent = suggestionMapper.selectContentByStudentId(studentId);*/
        return GenericBuilder.of(AnswerSheetVo::new)
                .with(AnswerSheetVo::setStudent, student)
/*                .with(AnswerSheetVo::setPart1, part1)
                .with(AnswerSheetVo::setPart2, part2)
                .with(AnswerSheetVo::setSuggestionContent, suggestionContent)*/
                .build();
    }

    /**
     *
     * @param majorId
     * @param grade
     */
    @Override
    public void getAllAnswerSheet(Integer majorId, Integer grade, String rootPath, HttpServletResponse response) {
        List<Student> students = studentMapper.selectAllByMajorIdAndGrade(majorId, grade);
        String baseUrl = new StringBuilder("http://localhost:8080").append("/admin/answerSheets/").toString();
        logger.info("baseUrl:" + baseUrl);
        logger.info("rootPath:" + rootPath);
        List<String> fileNames = Lists.newArrayList();
        String fileName = null;
        Major currentMajor = majorMapper.selectByPrimaryKey(majorId);
        String majorName = currentMajor.getMajorName();
        String subPath = new StringBuilder()
                .append(majorName)
                .append("/")
                .append(grade)
                .append("/")
                .toString();
        String documentPath = new StringBuilder()
                                .append(rootPath)
                                .append("documents/")
                                .append(subPath)
                                .toString();
        String zipPath = new StringBuilder()
                .append(rootPath)
                .append("zips/")
                .append(subPath)
                .toString();
        for (Student student : students){
            fileName = new StringBuilder(4)
                        .append(student.getUsername())
                        .append(student.getName())
                        .append(".doc").toString();
            System.out.println(fileName.length() + "!!!");
            fileNames.add(fileName);
            HTML2WordUtil.generatorWordFile(documentPath, fileName, baseUrl + student.getId());
        }
        String zipFileName = new StringBuilder().append(majorName).append(grade).append(".zip").toString();
        ZipUtil.compressToZip(documentPath, zipPath, zipFileName,fileNames);
        DownloadUtil.download(zipPath, zipFileName, response);
        boolean deleteDocuments = DeleteFileUtil.deleteFile(new File(rootPath +"documents"));
        boolean deleteZip = DeleteFileUtil.deleteFile(new File(rootPath +"zips"));
        logger.info("删除文档：" + deleteDocuments);
        logger.info("删除压缩包：" + deleteZip);
    }

    @Override
    public boolean importStudentInformation(MultipartFile multipartFile, HttpServletRequest request) {
        System.out.println("开始");
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = multipartFile.getOriginalFilename();
        //multipartFile.getInputStream();
        return false;
    }
}
